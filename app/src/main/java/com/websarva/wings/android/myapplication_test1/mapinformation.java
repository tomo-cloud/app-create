package com.websarva.wings.android.myapplication_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class mapinformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapinformation);
        Button Returnbutton=findViewById(R.id.Register);
        MapReturn mapReturn=new MapReturn();
        Returnbutton.setOnClickListener(mapReturn);
    }
    private class MapReturn implements View.OnClickListener {
        public void onClick(View view) {
            EditText editText1=(EditText) findViewById(R.id.putusername);
            EditText editText2=(EditText)findViewById(R.id.edituserName);
            String username=editText1.getText().toString();
            String username1=editText2.getText().toString();
            if(username.equals(username1)) {
                Intent intent = new Intent(mapinformation.this, toiletMapsActivity.class);
                startActivity(intent);
            }else{
                Log.d("","Error");
        }}
    }
}