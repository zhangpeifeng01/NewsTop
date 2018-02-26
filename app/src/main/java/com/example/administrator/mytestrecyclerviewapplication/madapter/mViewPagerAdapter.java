package com.example.administrator.mytestrecyclerviewapplication.madapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.mytestrecyclerviewapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/16.
 */

public class mViewPagerAdapter extends PagerAdapter {
    private ArrayList<View> views;

    public mViewPagerAdapter(ArrayList<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }
}
