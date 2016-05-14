package com.example.kongsin.moveablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.kongsin.moveablelistview.adapter.ListAdapter;
import com.example.kongsin.moveablelistview.adapter.SimpleTouchItemAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Object> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lists = new ArrayList<>();
        for (char i = 'a' ; i <= 'z'; i++){
            lists.add(""+i);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        ListAdapter adapter = new ListAdapter(this, lists);
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            layoutManager.setAutoMeasureEnabled(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(false);
            recyclerView.offsetChildrenVertical(5);
            recyclerView.setAdapter(adapter);
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SimpleTouchItemAdapter(adapter, lists));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
