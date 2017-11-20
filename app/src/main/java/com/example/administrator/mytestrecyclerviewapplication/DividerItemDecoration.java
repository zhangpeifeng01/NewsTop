package com.example.administrator.mytestrecyclerviewapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/**
 * Created by Administrator on 2017/11/17.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS=new int[]{ android.R.attr.listDivider};
    public static final int HORIZONTAL_LIST= LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST= LinearLayoutManager.VERTICAL;
    private Drawable mDiviade;
    private int mOrientation;
    public DividerItemDecoration(Context context,int orientation){
        final TypedArray a=context.obtainStyledAttributes(ATTRS);
        mDiviade = a.getDrawable(0);
        setOriention(orientation);

    }
    public void setOriention(int oriention){
        if (oriention!=HORIZONTAL_LIST && oriention!=VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation=oriention;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
        super.onDraw(c, parent);
        if (mOrientation==VERTICAL_LIST){
            drawVertical(c,parent);
        }else {
            drawHorizontal(c,parent);
        }

    }
    public void drawVertical(Canvas canvas ,RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int rigth = parent.getWidth() - parent.getPaddingRight();
        final  int childCount = parent.getChildCount();
        for (int i=0;i <childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDiviade.getIntrinsicHeight();
            mDiviade.setBounds(left,top,rigth,bottom);
            mDiviade.draw(canvas);
        }
    }
    public void drawHorizontal(Canvas canvas ,RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i=0;i <childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int rigth = left + mDiviade.getIntrinsicHeight();
            mDiviade.setBounds(left,top,rigth,bottom);
            mDiviade.draw(canvas);
        }
    }
}
