package com.example.blujackkost;

import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemClickSupport {

    private final RecyclerView mRecyclerView;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final OnItemLongClickListener mOnItemLongClickListener;


    private ItemClickSupport(RecyclerView RecyclerView, AdapterView.OnItemClickListener mOnItemClickListener) {
        mRecyclerView = RecyclerView;
        this.mOnItemClickListener = mOnItemClickListener;
        mRecyclerView.setTag(R.id.item_click_support, this);
        mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener);

    }

    private View.OnClickListener mOnItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null){
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
            }
        }
    };

    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if(mOnItemLongClickListener != null){
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);

                return mOnItemLongClickListener.onItemLongClicked(mRecyclerView, holder. getAdapterPosition(),v);
            }
            return false;
        }
    };

    private RecyclerView.OnChildAttachStateChangeListener mAttachListener = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {
            if(mOnItemClickListener != null){
                view.setOnClickListener(mOnClickListener);
            }
            if(mOnItemLongClickListener != null){
                view.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {

        }
    };

    public static ItemClickSupport addTo(RecyclerView view){
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if(support == null){
            support =new ItemClickSupport(view, mOnItemClickListener);
        }
        return support;
    }

    public static ItemClickSupport removeFrom (RecyclerView view){
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if(support != null){
            support.detach(view);
        }
        return support;
    }

    public ItemClickSupport setOnItemClickListener(AdapterView.OnItemClickListener listener){
        mOnItemClickListener = listener;
        return this;
    }

    public ItemClickSupport setOnItemLongClickListener (AdapterView.OnItemLongClickListener listener){
        mOnItemLongClickListener =  listener;
        return this;
    }

    private void detach (RecyclerView view){
        view.removeOnChildAttachStateChangeListener(mAttachListener);
        view.setTag(R.id.item_click_support, null);
    }

    public interface  OnItemClickListener{
        void  OnItemClicked (RecyclerView recyclerView, int position, View v);
    }

    public interface OnItemLongClickListener{
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
    }
}
