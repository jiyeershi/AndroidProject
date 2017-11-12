package com.example.liuyi.learncustomlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by liuyi on 16/6/19.
 */
public class MyLayout extends LinearLayout implements View.OnClickListener {
//    public MyLayout(Context context) {
//        super(context);
//    }

    private Context context1;
    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        System.out.println("Mylayout create");
        context1 = context;
        LayoutInflater.from(context).inflate(R.layout.customlayout, this);

        findViewById(R.id.button).setOnClickListener(this);
//
        findViewById(R.id.button2).setOnClickListener(this);
//        Button btn = (Button) findViewById(R.id.button);
//        btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(MyLayout.this, "btn onclick", Toast.LENGTH_LONG).show();
//                System.out.println("fdadadfafad");
//            }
//        });

//        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                System.out.println("hhhhhhhhh");
                Toast.makeText(context1, "button Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                break;
        }
    }
}
