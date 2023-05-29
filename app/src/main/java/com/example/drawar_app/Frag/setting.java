package com.example.drawar_app.Frag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drawar_app.Adapter.adapter_setting;
import com.example.drawar_app.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class setting extends Fragment {

RecyclerView recyclerView;
String name[]={"About Phone","Battery","Security status","SIM card","Sound & vibration","Apps updater"};
ArrayList images=new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting, container, false);
        recyclerView=view.findViewById(R.id.recycle_setting);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        String image[];
        try {
            image=getContext().getAssets().list("image");
            images=new ArrayList(Arrays.asList(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        recyclerView.setLayoutManager(layoutManager);
        adapter_setting adapterSetting=new adapter_setting(getContext(),images,name);
        recyclerView.setAdapter(adapterSetting);
        return view;
    }
}