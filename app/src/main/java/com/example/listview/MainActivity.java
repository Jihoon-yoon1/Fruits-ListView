package com.example.listview;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] titles ={
            "Apple",
            "Grape",
            "Orange",
            "Banana",
            "WaterMelon",
            "Cherry",
            "Melon",
            "Mango",
            "Pitch",
            "Shine Musket"
    };

    Integer[] images = {
            R.drawable.fruit1,
            R.drawable.fruit2,
            R.drawable.fruit3,
            R.drawable.fruit4,
            R.drawable.fruit5,
            R.drawable.fruit6,
            R.drawable.fruit7,
            R.drawable.fruit8,
            R.drawable.fruit9,
            R.drawable.fruit10,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CuList adapter = new CuList(MainActivity.this);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
           @Override
           public void onItemClick(AdapterView<?>parent, View view, int position, long id){
               Toast.makeText(getBaseContext(), titles[+position], Toast.LENGTH_LONG).show();
           }
        });

    }
    public class CuList extends ArrayAdapter<String>{
        private final Activity context;
        public CuList(Activity context){
            super(context, R.layout.listitem, titles);
            this.context = context;
        }

        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView rating = (TextView) rowView.findViewById(R.id.rating);
            TextView genre = (TextView) rowView.findViewById(R.id.genre);
            TextView year = (TextView) rowView.findViewById(R.id.year);

            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText("이 과일은 "+position+"번째 과일이다.");
            genre.setText("fruit");
            year.setText("과일"+position+"");
            return rowView;
        }
    }
}