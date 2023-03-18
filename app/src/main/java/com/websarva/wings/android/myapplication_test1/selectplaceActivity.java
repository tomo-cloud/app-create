package com.websarva.wings.android.myapplication_test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
        Spinner Placelist=findViewById(R.id.Placelist);

    }
    public void onMapsearch(View view){
        Spinner Text=findViewById(R.id.Placelist);
        String text=Text.getContext().toString();
        if(text.equals("トイレ")){
            String uriStr="https://www.google.com/maps/d/u/2/edit?mid=1sDV8VGoCMU42u562hQvCxZo1IoPYxfw&usp=sharing";
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uriStr));
            startActivity(intent);
        }else if(text.equals("礼拝所")){
            String uriStr1="https://www.google.com/maps/d/u/2/edit?mid=1aiJraOhvhYh21zetOzvWMEXFjm58z4I&usp=sharing";
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uriStr1));
            startActivity(intent);
        }
    }

}