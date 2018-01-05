package com.example.student.a20180105;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int ch=-1;
    int a=-1;
    boolean[] b=new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("this is title");
        builder.setMessage("hi");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了確定",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("help", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了help",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click2(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("this is title");
        final EditText ed= new EditText(MainActivity.this);
        final TextView tv=(TextView)findViewById(R.id.textView);//放在裡面要用final宣告
        ed.setText(tv.getText().toString());//顯示之前輸入的紀錄
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下了確定",Toast.LENGTH_SHORT).show();
                tv.setText(ed.getText().toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選項");
        final String animals[]={"鼠","牛","虎","兔"};
        final TextView tv2=(TextView)findViewById(R.id.textView2);
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv2.setText(animals[i]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false);//只加這個會無法取消
        builder.show();
    }
    public void click4(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選項");
        final String animals[]={"鼠","牛","虎","兔"};
        final TextView tv3=(TextView)findViewById(R.id.textView3);
        a=ch;//沒設定的話會在第一次確定後 再選擇取消 然後再按確定會跳出剛剛取消選擇的物件
        builder.setSingleChoiceItems(animals, ch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //ch=i;//
                a=i;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ch=a;
                tv3.setText(animals[ch]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void click5(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選項");
        final String animals[]={"鼠","牛","虎","兔"};
        final TextView tv4=(TextView)findViewById(R.id.textView4);
        builder.setMultiChoiceItems(animals, b, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int p) {

                StringBuilder sb=new StringBuilder();
                for(int i=0;i<=3;i++)
                {
                    if(b[i])
                    {
                        sb.append(animals[i]+",");
                    }
                }
                tv4.setText(sb.toString());
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("This is title");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1 = inflater.inflate(R.layout.layout1, null);
        final TextView tv = v1.findViewById(R.id.textView5);
        Button btn1 = v1.findViewById(R.id.button7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("Hello World");
            }
        });
        builder.setView(v1);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}