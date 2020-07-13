package org.techtown.ds_homework10;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberText = (EditText) findViewById(R.id.phoneNumberText);

    }

    public void onCallClicked(View v) {
        String data = phoneNumberText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(data));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "권한 없음", Toast.LENGTH_SHORT).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                Toast.makeText(this, "권한설명 필요함.", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }

        }else{
            startActivity(intent);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case  1:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"권한을 사용자가 승인함",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"권한 거부됨",Toast.LENGTH_SHORT).show();
                }

                return;
            }
        }
    }

    public void onDialClicked(View v){
        String data = phoneNumberText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(data));
        startActivity(intent);

    }

}
