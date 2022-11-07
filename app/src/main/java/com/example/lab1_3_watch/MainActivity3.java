package com.example.lab1_3_watch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity3 extends Activity {

    ArrayList<Menu> menus = new ArrayList<>();
    ListView categoriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main3);
        setInitialData();
        categoriesList = (ListView) findViewById(R.id.categoriesList);
        AdapterMenu adapterMenu = new AdapterMenu(this, R.layout.item_list, menus);
        categoriesList.setAdapter(adapterMenu);
        categoriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {

                Menu selectedMenuItem = (Menu) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                Bundle extras = new Bundle();
                extras.putString("nameMenu", selectedMenuItem.getCategoryName());
                String text = readFile(selectedMenuItem.getTextResource());
                extras.putString("text", text);
                extras.putInt("icon", selectedMenuItem.getIconResource());
                extras.putInt("image", selectedMenuItem.getPhotoResource());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }

    @NonNull
    private String readFile(int res){
        InputStream inputStream = getResources().openRawResource(
                res);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();

    }

    private void setInitialData() {
        menus.add(new Menu (R.drawable.ic_blinchik, "Блинчики", R.drawable.blinchik, R.raw.t_blinchik));
        menus.add(new Menu (R.drawable.ic_borsch, "Борщ", R.drawable.borsch, R.raw.t_borsch));
        menus.add(new Menu (R.drawable.ic_cesar, "Цезарь", R.drawable.cesar, R.raw.t_cesar));
        menus.add(new Menu (R.drawable.ic_milkshake, "Мол. коктейль", R.drawable.milkshake, R.raw.t_milkshake));
        menus.add(new Menu (R.drawable.ic_spagetti, "Спагетти", R.drawable.spagetti, R.raw.t_spagetti));
    }
}