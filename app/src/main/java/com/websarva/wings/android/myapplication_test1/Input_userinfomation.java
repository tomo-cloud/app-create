package com.websarva.wings.android.myapplication_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Input_userinfomation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_userinfomation);
        //インテントオブジェクトの取得
        Intent intent=getIntent();
        Button next_button=findViewById(R.id.nextbutton2);
       HelloListener2 listener=new HelloListener2();
        next_button.setOnClickListener(listener);
    }
    private class HelloListener2 implements View.OnClickListener{
        @Override
        //クリックした後の処理
        public void onClick(View view){
            EditText username=findViewById(R.id.edituserName);
            EditText useraddress=findViewById(R.id.edituseraddress);
            String inputname=username.getText().toString();
            String inputaddress=useraddress.getText().toString();
            Intent intent=new Intent(Input_userinfomation.this,selectplaceActivity.class);
            intent.putExtra("inputname",inputname);
            intent.putExtra("inputaddress",inputaddress);
            startActivity(intent);
        }
    }
}