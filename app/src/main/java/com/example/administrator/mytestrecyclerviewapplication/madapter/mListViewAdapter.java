package com.example.administrator.mytestrecyclerviewapplication.madapter;

import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytestrecyclerviewapplication.R;
import com.example.administrator.mytestrecyclerviewapplication.bean.Info;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/16.
 */

public class mListViewAdapter extends BaseAdapter {
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_COMPANY = 1;
    ArrayList<Info> list1;
    Context mcontext;
    public mListViewAdapter( Context mcontext) {
        this.mcontext=mcontext;
        getDate();
    }

    @Override
    public int getCount() {
        return list1.size()>0?list1.size():0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return TYPE_TITLE;

        }else {
            return TYPE_COMPANY;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder1 holder1 = null;
        viewHolder2 holder2 = null;
        int type = getItemViewType(position);
        if (convertView==null){
        switch (type){
                case TYPE_TITLE:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent,false);
                    holder1 = new viewHolder1();
                    holder1.list_item_tv1= (TextView) convertView.findViewById(R.id.list_item_title);

                     convertView.setTag(holder1);
                  break;
                case TYPE_COMPANY:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item2, parent,false);
                    holder2 =  new viewHolder2();
                    holder2.list_item_tv= (TextView) convertView.findViewById(R.id.list_item_tv);
                    holder2.list_item_textView= (TextView) convertView.findViewById(R.id.list_item_textView);
                    holder2.list_item_tv2= (TextView)convertView.findViewById(R.id.list_item_tv2);
                    holder2.list_item_textView2= (TextView) convertView.findViewById(R.id.list_item_textView2);
                   holder2.list_item_img= (ImageView) convertView.findViewById(R.id.list_item_img);
                    holder2.list_item_img2= (ImageView) convertView.findViewById(R.id.list_item_img2);
                    convertView.setTag(holder2);
                   break;
            }
        }else {
            switch (type){
                case TYPE_TITLE:
                    holder1= (viewHolder1) convertView.getTag();
                    break;
                case TYPE_COMPANY:
                    holder2= (viewHolder2) convertView.getTag();
                    break;
            }

        }
        switch (type){
            case TYPE_TITLE:
                holder1.list_item_tv1.setText(list1.get(position).getTitle11());
                break;
            case TYPE_COMPANY:
                holder2.list_item_tv.setText(list1.get(position).getTitle11());
                holder2.list_item_textView.setText(list1.get(position).getTitle12());
                holder2.list_item_img.setImageResource(list1.get(position).getImg11());

                holder2.list_item_tv2.setText(list1.get(position).getTitle21());
                holder2.list_item_textView2.setText(list1.get(position).getTitle22());
                holder2.list_item_img2.setImageResource(list1.get(position).getImg21());
                break;
        }

        return convertView;
    }
    class viewHolder2 {

        TextView list_item_tv;
        TextView list_item_textView;
        ImageView list_item_img;

        TextView list_item_tv2;
        TextView list_item_textView2;
        ImageView list_item_img2;
    }
    class viewHolder1 {

        TextView list_item_tv1;

    }
    private void getDate(){

        list1=new ArrayList<>();
        Info tinfo1=new Info();
        tinfo1.setTitle11("惠支付");
        list1.add(tinfo1);

        Info info3=new Info();
        info3.setTitle11("五折起");
        info3.setTitle12("1212打牌品牌");
        info3.setImg11(R.mipmap.zfb_10_01);
        info3.setTitle21("支付宝发红包");
        info3.setTitle22("邀请好友赚赏金");
        info3.setImg21(R.mipmap.zfb_10_02);
        list1.add(info3);

        Info tinfo2=new Info();
        tinfo2.setTitle11("生活服务");

        list1.add(tinfo2);
        Info info4=new Info();
        info4.setTitle11("一键叫水电费");
        info4.setTitle12("躺在家里就能办哟");
        info4.setImg11(R.mipmap.zfb_10_03);
        info4.setTitle21("交了多年医保");
        info4.setTitle22("你用对了么？");
        info4.setImg21(R.mipmap.zfb_10_04);
        list1.add(info4);
    }
}
