package com.example.administrator.mytestrecyclerviewapplication.madapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytestrecyclerviewapplication.R;

/**
 * Created by Administrator on 2017/12/11.
 */

public class GridviewAdapter extends BaseAdapter{
    Context mcontext;

    public GridviewAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    private Integer[] imgs = {R.mipmap.zfb_06_02,R.mipmap.zfb_06_04,
            R.mipmap.zfb_06_06,R.mipmap.zfb_06_08,R.mipmap.zfb_06_20,
            R.mipmap.zfb_06_22,R.mipmap.zfb_06_24,R.mipmap.zfb_06_26};
    private String[] tvs={"转账","充值中心","信用卡还款","余额宝","花呗","天猫超市","蚂蚁森林","更多"};
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_gridview, null);
        ImageView imageView= (ImageView) view.findViewById(R.id.item_img);
        TextView textView= (TextView) view.findViewById(R.id.item_tv);
        imageView.setImageResource(imgs[position]);
        textView.setText(tvs[position]);


        return view;
    }
}
