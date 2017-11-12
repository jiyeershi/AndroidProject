package com.example.liuyi.learnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;
    private EditText editText;
    private MyService.MyBinder binder;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MyService.class);
//        intent = new Intent(this, MyService.class);

        editText = (EditText) findViewById(R.id.editText);

        findViewById(R.id.btnStartService).setOnClickListener(this);

        findViewById(R.id.btnStopService).setOnClickListener(this);

        findViewById(R.id.btnBindService).setOnClickListener(this);

        findViewById(R.id.btnUnBindService).setOnClickListener(this);

        findViewById(R.id.btnSynchData).setOnClickListener(this);

        textView = (TextView) findViewById(R.id.tvOut);

        findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("stop service");
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra("data", editText.getText().toString());
                startService(intent);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
            case R.id.btnBindService:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnBindService:
                unbindService(this);
                break;
            case R.id.btnSynchData:
                if (binder != null) {
                    ((MyService.MyBinder)binder).setData(editText.getText().toString());
                }
                break;
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.getData().getString("data"));
        }
    };

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("service connected");
        binder = (MyService.MyBinder)service;
        binder.getService().setCallback(new MyService.Callback() {
            @Override
            public void onDataChanged(String data) {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("service dis connected");
    }
}
