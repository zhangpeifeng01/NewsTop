package com.example.administrator.mytestrecyclerviewapplication.madapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mytestrecyclerviewapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/17.
 */

public class HomeRecyclerviewAdapter extends RecyclerView.Adapter<HomeRecyclerviewAdapter.MyViewHolder> {
private ArrayList<String> mList;
    private Context mContext;
    OnItemclickListener monItemclickListener=null;

    public HomeRecyclerviewAdapter(ArrayList<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(mList.get(position));
        if (monItemclickListener!=null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position1 = holder.getLayoutPosition();
                    monItemclickListener.onItemClick(holder.textView,position);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position1 = holder.getLayoutPosition();
                    monItemclickListener.onItemLongClick(holder.textView,position1);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
    public interface OnItemclickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view,int position);

    }
    public void setOnItemClickListener(OnItemclickListener monItemClickListener){
        this.monItemclickListener=monItemClickListener;

    }
}
