package com.websarva.wings.android.myapplication_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class LookingPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_place);
        Intent intent=getIntent();
        Button next_button=findViewById(R.id.Japanese);
        HelloListener1 listener=new HelloListener1();
        next_button.setOnClickListener(listener);
    }
    private class HelloListener1 implements View.OnClickListener{
        @Override
        //クリックした後の処理
        public void onClick(View view){
            Intent intent=new Intent(LookingPlaceActivity.this,Input_userinfomation.class);
            startActivity(intent);
        }
    }
    public void onBackButtonClick(View view){
        finish();
    }
}