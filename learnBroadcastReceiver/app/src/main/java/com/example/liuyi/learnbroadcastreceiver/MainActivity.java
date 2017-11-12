package com.example.liuyi.learnbroadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendMsg).setOnClickListener(this);
        findViewById(R.id.btnRegist).setOnClickListener(this);
        findViewById(R.id.btnUnRegist).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendMsg:
//                Intent intent = new Intent(this, MyReceiver.class);
                Intent intent = new Intent(MyReceiver.ACTION);
                intent.putExtra("data", "learn boardCast");
//                sendBroadcast(intent);
                sendOrderedBroadcast(intent, null);
                break;
            case R.id.btnRegist:
                System.out.println("click btnReg");
                if (receiver == null) {
                    receiver = new MyReceiver();
                    registerReceiver(receiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.btnUnRegist:
                System.out.println("click btnUnReg");
                if (receiver != null) {
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;
        }
    }

    private MyReceiver receiver = null;
}
