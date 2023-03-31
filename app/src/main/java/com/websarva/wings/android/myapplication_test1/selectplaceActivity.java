package com.websarva.wings.android.myapplication_test1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class selectplaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectplace);
        Intent intent=getIntent();
        String username=intent.getStringExtra("inputname");
        TextView hello=findViewById(R.id.hello);
        hello.setText(username+"さん、初めまして！");
        Button Nextbutton=findViewById(R.id.nextbutton2);
        Mapword mapword=new Mapword();
        Nextbutton.setOnClickListener(mapword);
    }
    private class Mapword implements View.OnClickListener {
        public void onClick(View view) {
            Intent intent=new Intent(selectplaceActivity.this,toiletMapsActivity.class);
            startActivity(intent);

        }
    }
}