package com.websarva.wings.android.myapplication_test1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next_button=findViewById(R.id.NextButton);
        HelloListener listener=new HelloListener();
        next_button.setOnClickListener(listener);
    }
    //ボタンをクリックした時のリスナクラスの定義HelloListener
    private class HelloListener implements View.OnClickListener{
        @Override
        //クリックした後の処理
        public void onClick(View view){
            Intent intent=new Intent(MainActivity.this,LookingPlaceActivity.class);
            startActivity(intent);
        }
    }
}