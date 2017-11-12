package com.example.liuyi.learncontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MainActivity继承自context,所以下面的textView构造时直接可以传this
//        textView = new TextView(this);
//        textView.setText("hello liuyi");
//        textView.setText(R.string.app_name); setContentView(textView);
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
        System.out.println("MainActivity onCreate");
    }

    private App getApp() {
        return (App)getApplicationContext();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity destroy");
    }
}
