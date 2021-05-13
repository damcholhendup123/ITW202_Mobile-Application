package com.example.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WorldListAdapter extends RecyclerView.Adapter<WorldListAdapter.Wordviewholder> {
    private  final LinkedList<String> mWorldList;
    private LayoutInflater mInflater;

   public WorldListAdapter (Context context, LinkedList<String>mWorldList){
       mInflater = LayoutInflater.from(context);
       this.mWorldList = mWorldList;
   }


    @NonNull
    @Override
    public WorldListAdapter.Wordviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemview = mInflater.inflate(R.layout.worldlist_item,parent,false);
        return new Wordviewholder(mItemview,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldListAdapter.Wordviewholder holder, int position) {
        String mcurrent = mWorldList.get(position);
        holder.wordItemView.setText(mcurrent);

    }

    @Override
    public int getItemCount() {
        return mWorldList.size();
    }

    class Wordviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView wordItemView;
        final WorldListAdapter mAdapter;

        public Wordviewholder(@NonNull View itemView,  WorldListAdapter mAdapter) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWorldList.get(mPosition);
            mWorldList.set(mPosition, "Clicked!" + element);
            mAdapter.notifyDataSetChanged();

        }
    }
}