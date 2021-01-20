package com.example.datting.BottomNavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.datting.Home.Home.CustomItemDecorator;
import com.example.datting.Home.Home.People;
import com.example.datting.Home.Home.People_Apdapter;
import com.example.datting.R;

import java.util.ArrayList;

public class Home_Fragments extends Fragment {
    ArrayList<People> people;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        data();


         ///
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.addItemDecoration(new CustomItemDecorator(getResources().getDimensionPixelSize(R.dimen._16sdp), getResources().getDimensionPixelSize(R.dimen._90sdp)));
        recyclerView.setLayoutManager(manager);

//        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        People_Apdapter studentAdapter = new People_Apdapter(people, getContext());
        recyclerView.setAdapter(studentAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }
    public  void data()
    {
        people = new ArrayList<>();
        for(int i=0;i<2;i++)
        {
            people.add(new People("Nam Thần", R.drawable.nhung1, 18, "Ha Noi", R.drawable.online));
            people.add(new People("Hiếu Thành ", R.drawable.nhung3, 20, "Đông Anh", R.drawable.online));
            people.add(new People("Nam Thần", R.drawable.thanhh, 18, "Ha Noi", R.drawable.online));
            people.add(new People("Hiếu Thành ", R.drawable.nhunglon, 20, "Đông Anh", R.drawable.online));
            people.add(new People("Hồng Nhung", R.drawable.nhugn2, 21, "Thanh Xuân", R.drawable.online));
            people.add(new People("Nam Đzai", R.drawable.nhungheo, 18, "Ha Noi", R.drawable.online));
        }
    }
}
