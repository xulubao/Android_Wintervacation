package com.example.wintervacation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
/*
 *   @创建者        徐路宝
 *   @创建描述      2020/3/27 9:23
 *   @描述          Gallery
 *
 */
public class myAdapter extends BaseAdapter {
    int[] imgs = new int[]{
            R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6
            ,R.drawable.img66, R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,
    };
    Context c;
    public myAdapter(Context context){
        this.c = context;
    }


    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(c);
        imageView.setImageResource(imgs[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new Gallery.LayoutParams(260,300));
        return imageView;
    }
}
