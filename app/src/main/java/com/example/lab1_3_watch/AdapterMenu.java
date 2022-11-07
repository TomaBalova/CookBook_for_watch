package com.example.lab1_3_watch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMenu extends ArrayAdapter<Menu> {

    private LayoutInflater inflater;
    private int layout;
    private List<Menu> menus;

    public AdapterMenu(Context context, int resource, List<Menu> menus){
        super(context,resource, menus);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.menus = menus;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(this.layout, parent, false);

        ImageView menuView = (ImageView) view.findViewById(R.id.imageView_icon);
        TextView nameView = (TextView) view.findViewById(R.id.textView_categoryName);

        Menu menu = menus.get(position);

        menuView.setImageResource(menu.getIconResource());
        nameView.setText(menu.getCategoryName());

        return view;
    }

}
