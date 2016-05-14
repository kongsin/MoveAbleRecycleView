package com.example.kongsin.moveablelistview.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

/**
 * Created by kongsin on 14/5/2559.
 */
public class SimpleTouchItemAdapter extends ItemTouchHelper.Callback {

    public RecyclerView.Adapter<?> adapter;
    public ArrayList<Object> lists;

    public SimpleTouchItemAdapter(RecyclerView.Adapter<?> adapter, ArrayList<Object> lists){
        this.adapter = adapter;
        this.lists = lists;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        lists.remove(viewHolder.getAdapterPosition());
        adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
    }

    @Override
    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
        Object tmp = lists.get(toPos);
        lists.set(toPos, lists.get(fromPos));
        lists.set(fromPos, tmp);
    }

}
