package com.example.popup_healofy;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import xyz.klinker.android.drag_dismiss.activity.DragDismissRecyclerViewActivity;


public class PopupActivity extends DragDismissRecyclerViewActivity {

    private CharSequence[] strings;

    @Override
    protected void setupRecyclerView(RecyclerView recyclerView) {
        Intent intent = getIntent();
        recyclerView.setId(R.id.comments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        strings = intent.getCharSequenceArrayExtra("cities");
        PopupAdapter adapter = new PopupAdapter(strings, this);
        recyclerView.setAdapter(adapter);
    }
}
