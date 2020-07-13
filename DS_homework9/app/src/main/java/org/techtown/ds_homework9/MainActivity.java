package org.techtown.ds_homework9;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStartServiceButtonClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);
    }

    public void onEndServiceButtonClicked(View v){
        Intent intent = new Intent(getApplicationContext(),MyService.class);
        stopService(intent);

    }
}
