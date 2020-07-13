package org.techtown.ds_homework5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);
        Button callXML = (Button) findViewById(R.id.callXML);
        Button callToast = (Button) findViewById(R.id.callToast);

        callXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.call_toast,container,true);
            }
        });

    }

    public void onCallToastClick(View v){
        Toast.makeText(this,"Inflation 과제 완료",Toast.LENGTH_SHORT).show();
    }

}
