package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.assignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String imageUrl1;
    private String imageUrl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);

        if(getIntent()!= null) {
            imageUrl1 = getIntent().getStringExtra("url1");
            imageUrl2 = getIntent().getStringExtra("url2");
            binding.image1Text.setText("Url : "+imageUrl1);
            binding.image2Text.setText("Url : "+imageUrl2);

            loadImages(imageUrl1,binding.image1);
            loadImages(imageUrl2,binding.image2);
        }


    }


    private void loadImages(String url, ImageView imageView){
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);
    }


}