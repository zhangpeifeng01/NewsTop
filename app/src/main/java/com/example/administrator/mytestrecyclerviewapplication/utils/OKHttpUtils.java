package com.example.administrator.mytestrecyclerviewapplication.utils;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/18.
 */

public class OKHttpUtils {
   public  static  OkHttpClient M_OK_HTTP_CLIENT = new OkHttpClient();
    static {
        M_OK_HTTP_CLIENT.setConnectTimeout(30, TimeUnit.SECONDS);
    }
    /**
     * 开启异步线程访问，访问结果自行处理
     *
     * @author wangsong 2015-10-9
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback) {
        M_OK_HTTP_CLIENT.newCall(request).enqueue(responseCallback);
    }

    /**
     * 开启异步线程访问,不对访问结果进行处理
     *
     * @author wangsong 2015-10-9
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request) {
         M_OK_HTTP_CLIENT.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Response arg0) throws IOException {
            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {
            }
        });

    }
}
