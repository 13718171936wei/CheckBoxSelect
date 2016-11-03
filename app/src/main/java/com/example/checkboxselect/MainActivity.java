package com.example.checkboxselect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private FruitAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        initView();

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Fruit fruit = fruitList.get(position);
                FruitAdapter.ViewHolder holder = (FruitAdapter.ViewHolder) view.getTag();
                if (fruit.isChecked()) {
                    fruit.setChecked(false);

                    holder.cb.setChecked(false);

                } else {
                    fruit.setChecked(true);

                    holder.cb.setChecked(true);

                }
                Toast.makeText(MainActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void selectAll(View view) {

        for (Fruit fruit : fruitList) {
            fruit.setChecked(true);
        }
        adapter.notifyDataSetChanged();

    }

    public void selectOppo(View view) {
        for (Fruit fruit : fruitList) {
            fruit.setChecked(!fruit.isChecked());
        }
        adapter.notifyDataSetChanged();
    }

    public void yinCang(View view) {
        if(!adapter.isEmpty()){
            fruitList.clear();
        }
        initFruits();
        adapter.notifyDataSetChanged();
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.mipmap.ic_launcher);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.mipmap.ic_launcher);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.mipmap.ic_launcher);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.mipmap.ic_launcher);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.mipmap.ic_launcher);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.mipmap.ic_launcher);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.mipmap.ic_launcher);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.mipmap.ic_launcher);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.mipmap.ic_launcher);
        fruitList.add(cherry);
        for (int i = 0; i < 10; i++) {
            Fruit mango = new Fruit("Mango", R.mipmap.ic_launcher);
            fruitList.add(mango);
        }
    }
}
