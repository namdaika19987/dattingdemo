package com.example.datting.Users;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.datting.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheets_Dialog extends BottomSheetDialogFragment {
    RelativeLayout relativeLayout;
    RadioButton radio_1, radio_2, radio_3, radio_4, radio_ID;
    RadioGroup radioGroup;
    CompoundButton.OnClickListener clickListener;
    String s="";
    TextView textview;

    public BottomSheets_Dialog(TextView textview) {
        this.textview = textview;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_bottom_sheets__user_, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //relativeLayout = view.findViewById(R.id.bottonSheets2);
        radio_1 = view.findViewById(R.id.radioOne);
        radio_2 = view.findViewById(R.id.radioTwo);
        radio_3 = view.findViewById(R.id.radioThree);
        radio_4 = view.findViewById(R.id.radioFour);

        radio_1.setOnCheckedChangeListener(checkedChangeListener);
        radio_2.setOnCheckedChangeListener(checkedChangeListener);
        radio_3.setOnCheckedChangeListener(checkedChangeListener);
        radio_4.setOnCheckedChangeListener(checkedChangeListener);

        //radioGroup = view.findViewById(R.id.radio_group);

}

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                 s = buttonView.getText().toString();
                 textview.setText(s);
            }
        }
    };


}
