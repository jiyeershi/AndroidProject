package com.example.liuyi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main1);
        System.out.println("MainActivity create");
        setContentView(R.layout.mylayout);
        textView = (TextView) findViewById(R.id.returnValueText);
        findViewById(R.id.btnStartAnotherActivity).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:www.baidu.com")
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data", "hello world liuyi");

                //数据包传递
                Bundle bundle = new Bundle();
                bundle.putString("data", "test bundle");
                intent.putExtras(bundle);

                //自定义数据传递
                intent.putExtra("user", new User("liuyi", 27));

//                startActivity(intent);
                //得到另一个activity 的返回值
                startActivityForResult(intent, 2);
                //隐式intent启动activity
//                startActivity(new Intent("com.example.liuyi.start_main2"));

            }
        });
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity destroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode);
        System.out.println(resultCode);
        textView.setText("另一个activity 返回的值是 %s" + data.getStringExtra("data"));
        System.out.println("requestCode "+requestCode + "resultCode " + resultCode);
    }
}
