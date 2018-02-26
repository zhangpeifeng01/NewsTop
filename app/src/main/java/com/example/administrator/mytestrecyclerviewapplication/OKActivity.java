package com.example.administrator.mytestrecyclerviewapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class OKActivity extends AppCompatActivity {
    TextView ok_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ok);
        Intent intent=	getIntent();
        String m=intent.getStringExtra("M");
        ok_text=(TextView) findViewById(R.id.ok_text);

        String cuttedStr = m;
	                 /* 删除字符串中的dot */
        for (int i = m.length()-1; i >= 0; i--) {
            char c = m.charAt(i);
            if ('.' == c) {

                if(m.length()-i>=3){
                    ok_text.setText(Double.parseDouble(cuttedStr)+"");
                    break;
                }
                ok_text.setText(Double.parseDouble(cuttedStr)+"0");
                break;
            }
            ok_text.setText(Double.parseDouble(cuttedStr)+"0");
        }
    }
}
