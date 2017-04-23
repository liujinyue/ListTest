

package com.example.a86505.listtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();


    public static class Fruit {
        private String name;
        private int imageId;

        public Fruit(String name, int imageId) {
            this.name = name;
            this.imageId = imageId;
        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return imageId;
        }

        public static class FruitAdapter extends ArrayAdapter<Fruit> {
            private int resourceId;

            public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
                super(context, textViewResourceId, objects);
                resourceId = textViewResourceId;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Fruit fruit = getItem(position);
                View view;
                ViewHolder viewHolder;
                if (convertView == null) {
                    view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
                    viewHolder = new ViewHolder();
                    viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
                    viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
                    view.setTag(viewHolder);//将viewHolder存储在view中
                } else {
                    view = convertView;
                    viewHolder = (ViewHolder) view.getTag();//重新获取ViewHolder
                }
                viewHolder.fruitImage.setImageResource(fruit.getImageId());
                viewHolder.fruitName.setText(fruit.getName());
                    return view;
                }
                class ViewHolder {
                    ImageView fruitImage;
                    TextView fruitName;
                }

               /* ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
                TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
                fruitImage.setImageResource(fruit.getImageId());
                fruitName.setText(fruit.getName());
                return view;*/
            }
        }

    private String[] data = {"Apple", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
            "Apple", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        Fruit.FruitAdapter adapter = new Fruit.FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View view,
            int position,long id){
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
private void initFruits() {
    for (int i = 0; i < 2; i++) {
        Fruit apple = new Fruit("Apple", R.drawable.apple_image);
        fruitList.add(apple);
        Fruit orange = new Fruit("Orange", R.drawable.orange_image);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_image);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.drawable.pear_image);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.drawable.grape_image);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_image);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_image);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.drawable.cherry_image);
        fruitList.add(cherry);
    }
}
}