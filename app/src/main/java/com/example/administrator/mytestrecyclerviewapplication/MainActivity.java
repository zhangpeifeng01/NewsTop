package com.example.administrator.mytestrecyclerviewapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.mytestrecyclerviewapplication.madapter.HomeRecyclerviewAdapter;
import com.example.administrator.mytestrecyclerviewapplication.utils.OKHttpUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.administrator.mytestrecyclerviewapplication.utils.OKHttpUtils.M_OK_HTTP_CLIENT;
import static com.example.administrator.mytestrecyclerviewapplication.utils.OKHttpUtils.enqueue;

public class MainActivity extends AppCompatActivity {
    private RecyclerView MyRecyclerView;
    ArrayList<String> mList;
   private static final String KEY_ = "386d3190efa79dda5048f554a62a0178";
    private static final String URL_="http://v.juhe.cn/toutiao/86d3190efa79dda5048f554a62a0178";
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyRecyclerView= (RecyclerView) findViewById(R.id.MyRecyclerView);

        MyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerView.setItemAnimator(new DefaultItemAnimator());
       getData();
        MyRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        final HomeRecyclerviewAdapter adapter = new HomeRecyclerviewAdapter(mList, this);
        MyRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new HomeRecyclerviewAdapter.OnItemclickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"点击的是第"+position+"个",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(MainActivity.this,HomeActivity.class));

            }

            @Override
            public void onItemLongClick(View view, final int position) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("确实删除吗？")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.removeData(position);
                            }
                        }).show();

            }
        });


    }
   public void getData(){
//       new Thread(new Runnable() {
//           @Override
//           public void run() {
//               Request request = new Request.Builder().url(URL_).build();
//               Call call = M_OK_HTTP_CLIENT.newCall(request);
//               try {
//                   Response response = call.execute();
//                   if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//                   Log.d(TAG,response.body().toString());
//
//
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//           }
//       }
//       ).start();



       mList=new ArrayList<String>();
       for (int i=0;i<10;i++){
           mList.add("第"+i+"行");
       }

   }
}
