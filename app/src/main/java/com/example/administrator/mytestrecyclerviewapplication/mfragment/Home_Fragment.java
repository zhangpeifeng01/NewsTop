package com.example.administrator.mytestrecyclerviewapplication.mfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.mytestrecyclerviewapplication.FKActivity;
import com.example.administrator.mytestrecyclerviewapplication.R;
import com.example.administrator.mytestrecyclerviewapplication.madapter.GridviewAdapter;
import com.example.administrator.mytestrecyclerviewapplication.madapter.mListViewAdapter;
import com.example.administrator.mytestrecyclerviewapplication.madapter.mViewPagerAdapter;
import com.example.administrator.mytestrecyclerviewapplication.zxing.activity.CaptureActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/11.
 */

public class Home_Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        LinearLayout erweima= (LinearLayout) view.findViewById(R.id.erweima);
        erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(container.getContext(),CaptureActivity.class),0);

            }
        });
        GridView gridView= (GridView) view.findViewById(R.id.home_gridview);
        gridView.setAdapter(new GridviewAdapter(getActivity()));
        ViewPager viewPager= (ViewPager) view.findViewById(R.id.vp);
        View view1 = inflater.inflate(R.layout.vp_item, null);
        View view2 = inflater.inflate(R.layout.vp_item2, null);
        ArrayList<View> Views = new ArrayList<>();
        Views.add(view1);
        Views.add(view2);
        viewPager.setAdapter(new mViewPagerAdapter(Views));
        ListView listView= (ListView) view.findViewById(R.id.home_lv);
        listView.setAdapter(new mListViewAdapter(getActivity()));
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        startActivity(new Intent(getActivity(), FKActivity.class));
    }
}
