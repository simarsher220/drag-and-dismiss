package com.example.popup_healofy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import xyz.klinker.android.drag_dismiss.DragDismissIntentBuilder;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private CharSequence[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.countries);
        strings = getResources().getTextArray(R.array.countries);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strings){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                // do whatever you want with this text view
                textView.setTextSize(80);
                return view;
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String listItem = String.valueOf(strings[position]);
        Intent intent = new Intent(MainActivity.this, PopupActivity.class);
        new DragDismissIntentBuilder(MainActivity.this)
                .setTheme(DragDismissIntentBuilder.Theme.LIGHT)
                .setPrimaryColorResource(R.color.colorPrimary)
                .setShowToolbar(false)
                .setDragElasticity(DragDismissIntentBuilder.DragElasticity.XXLARGE)
                .setToolbarTitle("Normal Activity Sample")
                .build(intent);
        if (listItem.equalsIgnoreCase("India")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.indian_cities));
        }
        else if (listItem.equalsIgnoreCase("Pakistan")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.pakistan_cities));
        }
        else if (listItem.equalsIgnoreCase("Germany")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.germany_cities));
        }
        else if (listItem.equalsIgnoreCase("Israel")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.israel_cities));
        }
        else if (listItem.equalsIgnoreCase("Italy")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.italy_cities));
        }
        else if (listItem.equalsIgnoreCase("Canada")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.canada_cities));
        }
        else if (listItem.equalsIgnoreCase("China")) {
            intent.putExtra("cities", getResources().getTextArray(R.array.china_cities));
        }
        startActivity(intent);
    }
}
