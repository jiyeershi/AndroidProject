package com.example.liuyi.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.liuyi.startservicefromanotherapp.IAppServiceRemoteBinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        findViewById(R.id.btnStartService).setOnClickListener(this);

        findViewById(R.id.btnsStopService).setOnClickListener(this);

        findViewById(R.id.btnBindService).setOnClickListener(this);

        findViewById(R.id.btnsUnbindService).setOnClickListener(this);

        findViewById(R.id.btnSynch).setOnClickListener(this);

        intent = new Intent();
        intent.setComponent(new ComponentName("com.example.liuyi.startservicefromanotherapp", "com.example.liuyi.startservicefromanotherapp.AppService"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                startService(intent);
                break;
            case R.id.btnsStopService:
                stopService(intent);
                break;
            case R.id.btnBindService:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnsUnbindService:
                unbindService(this);
                binder = null;
                break;
            case R.id.btnSynch:
                if (binder != null) {
                    try {
                        binder.setData(editText.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("bind Service");
        System.out.println(service);
        binder = IAppServiceRemoteBinder.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    private IAppServiceRemoteBinder binder;
}
