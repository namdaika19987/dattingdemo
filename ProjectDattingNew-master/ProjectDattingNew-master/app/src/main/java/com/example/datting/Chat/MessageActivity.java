package com.example.datting.Chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.datting.Chat.AdapterChat.AdapterMessage;
import com.example.datting.Model.Message;
import com.example.datting.R;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.sql.Time;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageActivity extends AppCompatActivity {

    // connection default values
    private static final String BROKER_URI = "tcp://broker.hivemq.com:1883";
    private static final String TOPIC = "testtopic/2";
    public static final int QOS = 2;

    EditText editText;
    CircleImageView image_message, status_message;
    TextView name_message, txt_online_message;
    ImageView quaylai;
    // user name for the chat lấy tên thiết bi
    //public static final String USER_NAME = Build.TAGS;
    public static final String USER_NAME = Build.USER;
    public String clientId = MqttClient.generateClientId();


    // global types
    private MqttAndroidClient client;

    // khai báo recyc
    ArrayList<Message> messages = new ArrayList<>();
    AdapterMessage adapterMessage;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        image_message = findViewById(R.id.image_message);
        name_message = findViewById(R.id.name_message);
        recyclerView = findViewById(R.id.recyc_chat);
        editText = findViewById(R.id.edit_message);
        quaylai = findViewById(R.id.quaylai);
        status_message = findViewById(R.id.status_message);
        txt_online_message = findViewById(R.id.txt_online_message);

        Intent intent = getIntent();
        int image = intent.getIntExtra("image", 0);
        boolean check_status_message = intent.getBooleanExtra("status_message", false);

        String name = intent.getStringExtra("name");

        Glide.with(this).load(image).into(image_message);

        if (check_status_message == true) {
            status_message.setImageResource(R.drawable.online);
            txt_online_message.setText("đang hoạt động");
            txt_online_message.setTextSize(12);
        } else {
            txt_online_message.setText("đã hoạt động 2 phút trước");
            txt_online_message.setTextSize(12);
            txt_online_message.setTextColor(Color.parseColor("#7a7a7a"));
            status_message.setImageResource(R.drawable.offline);
        }

        name_message.setText(name);
        quaylai();

        adapterMessage = new AdapterMessage(this, messages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterMessage);
        connect();

    }

    private void quaylai() {
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void connect() {
        client = new MqttAndroidClient(this, BROKER_URI, clientId);
        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true); // clean session in order to don't get duplicate messages each time we connect

            client.connect(options, new IMqttActionListener() {

                @Override
                public void onSuccess(IMqttToken iMqttToken) {
                    Toast.makeText(MessageActivity.this, "sẵn sàng", Toast.LENGTH_SHORT).show();
                    subscribe();
                }

                @Override
                public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                    Toast.makeText(MessageActivity.this, "Unavailable chat, cause: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
                }

            });
        } catch (MqttException e) {
            Toast.makeText(this, "ERROR, client not connected to broker in " + BROKER_URI, Toast.LENGTH_LONG).show();
        }
    }


    public void publish(View view) {
        // we are in the right view?
        if (view.getId() == R.id.publish) {
            // we only publish if connected
            if (null != client && client.isConnected()) {

                String message = editText.getText().toString();
                // we only publish if there is message to publish
                if (!message.isEmpty()) {

                    message = USER_NAME + ":" + message;
                    //message = message.;
                    editText.setText("");
                    MqttMessage mqttMessage = new MqttMessage();
                    mqttMessage.setQos(QOS);
                    mqttMessage.setPayload(message.getBytes());

                    try {
                        client.publish(TOPIC, mqttMessage, null, new IMqttActionListener() {

                            @Override
                            public void onSuccess(IMqttToken iMqttToken) {
                                Toast.makeText(MessageActivity.this, "Đã gửi", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                                Toast.makeText(MessageActivity.this, "Tin nhắn chưa được gửi: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
                            }

                        });
                    } catch (MqttException e) {
                        Toast.makeText(this, " ERROR, an error occurs when publishing", Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                Toast.makeText(this, "WARNING, client not connected", Toast.LENGTH_LONG).show();
            }

        }
    }

    public void subscribe() {
        try {
            client.subscribe(TOPIC, QOS);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    //String mess = new String(message.getPayload());
                    messages.add(new Message(new String(message.getPayload())));
                    adapterMessage.notifyDataSetChanged();
                    // Log.d("hhh", new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });

        } catch (MqttException e) {
            Toast.makeText(this, "ERROR, an error occurs when subscribing", Toast.LENGTH_LONG).show();
        }
    }


}
