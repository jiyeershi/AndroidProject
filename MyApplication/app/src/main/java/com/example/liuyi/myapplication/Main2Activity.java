package com.example.liuyi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.ShowIntentExtal);
        Intent intent = getIntent();
        String str = intent.getStringExtra("data");
        Bundle bundle = intent.getExtras();
//        textView.setText(String.format("get buddle = %s", bundle.getString("data", "default value")));
////        User user = (User) intent.getSerializableExtra("user");
//        User user = (User) intent.getParcelableExtra("user");
//        textView.setText(String.format("get user name = %s, age = %d", user.getName(), user.getAge()));

        editText = (EditText) findViewById(R.id.editText);

        Button btn = (Button) findViewById(R.id.sendBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data", editText.getText().toString());
                setResult(3, intent);
                finish();
            }
        });
    }

}
