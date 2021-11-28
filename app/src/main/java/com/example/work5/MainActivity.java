package com.example.work5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Runnable myWorker=new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                int num=Integer.parseInt(str);
                int p=2;
                while(p<num){
                    if(num%p==0) {
                        Toast.makeText(MainActivity.this, num+"不是素数", Toast.LENGTH_LONG).show();
                        break;
                    }
                    else{
                        p++;
                    }
                }
                if(p>=num){
                    Toast.makeText(MainActivity.this, num+"是素数", Toast.LENGTH_LONG).show();
                }
                Looper.loop();
            }
        };
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text=(EditText)findViewById(R.id.text);
                str=text.getText().toString();
                Thread workThread=new Thread(null,myWorker,"WorkThread");
                workThread.start();
            }
        });
    }
}