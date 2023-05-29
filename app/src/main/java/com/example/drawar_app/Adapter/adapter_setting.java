package com.example.drawar_app.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawar_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class adapter_setting extends RecyclerView.Adapter<adapter_setting.User_holde> {
    Context context;
    String[] name;
    ArrayList images;
    public adapter_setting(Context context, ArrayList images, String[] name) {
        this.context=context;
        this.name=name;
        this.images=images;
    }

    @NonNull
    @Override
    public adapter_setting.User_holde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.setting_iteam,parent,false);
        User_holde holde=new User_holde(view);
        return holde;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_setting.User_holde holder, int position) {
            holder.textView.setText(""+name[position]);
        InputStream stream=null;
        try {
            stream=context.getAssets().open("image/"+images.get(position));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class User_holde extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public User_holde(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.setting_image);
            textView=itemView.findViewById(R.id.setting_name);
        }
    }
}
