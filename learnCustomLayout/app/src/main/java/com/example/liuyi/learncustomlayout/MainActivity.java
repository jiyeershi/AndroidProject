package com.example.liuyi.learncustomlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"apple", "banana", "orange", "pear", "mango", "grape", "cherry", "other1",
    "other2", "other3", "other4", "other1", "beauty"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.testlistview_layout);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        initFruitData();

        FruitAdapter fruitadapter = new FruitAdapter(this, R.layout.fruit_item_layout, fruitList);
        listView.setAdapter(fruitadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getfName(), Toast.LENGTH_SHORT).show();
            }
        });

        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;

        Log.d("Main", "xdpi = " + xdpi);
        Log.d("Main", "ydpi = " + ydpi);
        Log.e("22222", "333333");

    }

    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private void initFruitData() {
        Fruit apple = new Fruit("apple", R.drawable.back);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana", R.drawable.back);
        fruitList.add(banana);
        Fruit orange = new Fruit("orange", R.drawable.back);
        fruitList.add(orange);
        Fruit pear = new Fruit("pear", R.drawable.back);
        fruitList.add(pear);
        Fruit mango = new Fruit("mango", R.drawable.back);
        fruitList.add(mango);
        Fruit beauty = new Fruit("beauty", R.drawable.back);
        fruitList.add(beauty);
        Fruit grape = new Fruit("grape", R.drawable.back);
        fruitList.add(grape);
        Fruit cherry = new Fruit("cherry", R.drawable.back);
        fruitList.add(cherry);
        Fruit other1 = new Fruit("other1", R.drawable.back);
        fruitList.add(other1);
        Fruit other2 = new Fruit("other2", R.drawable.back);
        fruitList.add(orange);
        Fruit other3 = new Fruit("other3", R.drawable.back);
        fruitList.add(other3);

    }
}
