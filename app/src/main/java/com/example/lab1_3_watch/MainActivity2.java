package com.example.lab1_3_watch;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.lab1_3_watch.databinding.ActivityMain2Binding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity2 extends Activity {

    private TextView textView;
    private ImageView imageViewIcon;
    private ImageView imageViewImage;
    private TextView textViewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle arg = getIntent().getExtras();
        textView = (TextView) findViewById(R.id.textViewMenuName);
        textViewText = (TextView) findViewById(R.id.textViewText);
        imageViewIcon = (ImageView) findViewById(R.id.imageView_iconMenu);
        imageViewImage = (ImageView) findViewById(R.id.imageViewImage);



        if (arg != null){
            textView.setText(arg.getString("nameMenu"));
            textViewText.setText(arg.getString("text"));
            imageViewIcon.setImageResource(arg.getInt("icon"));
            imageViewImage.setImageResource(arg.getInt("image"));
        }
    }


}