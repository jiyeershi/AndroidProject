package com.example.liuyi.learncustomlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liuyi on 16/6/19.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resId;
    public FruitAdapter(Context context, int textViewResId, List<Fruit> objects) {
        super(context, textViewResId, objects);
        resId = textViewResId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resId, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.fruitImage);
            TextView textView = (TextView) view.findViewById(R.id.fruitName);
            viewHolder = new ViewHolder(imageView, textView);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.fruitImage.setImageResource(fruit.getfId());
        viewHolder.fruitTextView.setText(fruit.getfName());

        return  view;
    }

    public class ViewHolder {
        ImageView fruitImage;
        TextView fruitTextView;
        public ViewHolder(ImageView imageView, TextView textView) {
            fruitImage = imageView;
            fruitTextView = textView;
        }
    }
}
