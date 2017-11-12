package com.example.liuyi.learncontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by liuyi on 16/5/29.
 */
public class main2 extends Activity {
    private TextView textView;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        textView = ((TextView)findViewById(R.id.textView));
        textView.setText(getApp().getData());
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.btnSendData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
                getApp().setData(editText.getText().toString());
            }
        });
        System.out.println("main2 onCreate");
    }

    private App getApp() {
        return (App)getApplicationContext();
    }

    protected void onDestroy() {
        super.onDestroy();
        System.out.println("main 2 destroy");
    }

}
