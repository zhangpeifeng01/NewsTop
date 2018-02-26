package com.example.administrator.mytestrecyclerviewapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FKActivity extends AppCompatActivity implements View.OnClickListener{
EditText editText;
    private Button but_0;
    private Button but_1;
    private Button but_2;
    private Button but_3;
    private Button but_4;
    private Button but_5;
    private Button but_6;
    private Button but_7;
    private Button but_8;
    private Button but_9;
    private Button but_Removed;
    private Button but_quer;
    StringBuffer stringBuffer=new StringBuffer();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            StringBuffer sb= (StringBuffer) msg.obj;
            editText.setText(sb.toString());
            editText.setSelection(sb.length());
            if (sb.equals(null)&sb.equals("")){
                but_Removed.setAlpha(0.5f);
                but_Removed.setFocusable(false);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fk);
        editText= (EditText) findViewById(R.id.editText2);
        editText.setInputType(InputType.TYPE_NULL);
        ((Button) findViewById(R.id.but_0)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_1)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_2)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_3)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_4)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_5)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_6)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_7)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_8)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_9)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_Removed)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_quer)).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.but_1:

                stringBuffer.append(1);
                Message message1 = new Message();
                message1.obj=stringBuffer;
                handler.sendMessage(message1);

                break;
            case R.id.but_2:
                stringBuffer.append(2);
                Message message2 = new Message();
                message2.obj=stringBuffer;
                handler.sendMessage(message2);
                break;
            case R.id.but_3:
                stringBuffer.append(3);
                Message message3 = new Message();
                message3.obj=stringBuffer;
                handler.sendMessage(message3);
                break;
            case R.id.but_4:
                stringBuffer.append(4);
                Message message4 = new Message();
                message4.obj=stringBuffer;
                handler.sendMessage(message4);
                break;
            case R.id.but_5:
                stringBuffer.append(5);
                Message message5 = new Message();
                message5.obj=stringBuffer;
                handler.sendMessage(message5);
                break;
            case R.id.but_6:
                stringBuffer.append(6);
                Message message6 = new Message();
                message6.obj=stringBuffer;
                handler.sendMessage(message6);
                break;
            case R.id.but_7:
                stringBuffer.append(7);
                Message message7 = new Message();
                message7.obj=stringBuffer;
                handler.sendMessage(message7);
                break;
            case R.id.but_8:
                stringBuffer.append(8);
                Message message8 = new Message();
                message8.obj=stringBuffer;
                handler.sendMessage(message8);
                break;
            case R.id.but_9:
                stringBuffer.append(9);
                Message message9 = new Message();
                message9.obj=stringBuffer;
                handler.sendMessage(message9);
                break;
            case R.id.but_0:
                stringBuffer.append(0);
                Message message0 = new Message();
                message0.obj=stringBuffer;
                handler.sendMessage(message0);
                break;
            case R.id.but_:
                stringBuffer.append(".");
                Message message = new Message();
                message.obj=stringBuffer;
                handler.sendMessage(message);
                break;
            case R.id.but_Removed:

                if (!editText.getText().toString().isEmpty()){
                    stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length()-1);
                    Message but_Removed = new Message();
                    but_Removed.obj=stringBuffer;
                    handler.sendMessage(but_Removed);
                }else {
                    Toast.makeText(FKActivity.this,"已经为空!!!",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.but_quer:
                Intent intent=new Intent(this,OKActivity.class);
                intent.putExtra("M",stringBuffer.toString());
                startActivity(intent);
                finish();
                break;
        }


    }
}
