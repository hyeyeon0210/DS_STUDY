package org.techtown.doitmisson_03;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int imageIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =(ImageView) findViewById(R.id.imageView);
        imageView2 =(ImageView) findViewById(R.id.imageView2);

    }

    public void onButton1Clicked(View v){
        upImage();
    }
    public void onButton2Clicked(View v){
        downImage();
    }

    private void upImage(){
        if(imageIndex==0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 0;
        }
        else if(imageIndex==1){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 0;
        }
    }

    private  void downImage(){
        if(imageIndex==0){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex = 1;
        }
        else if(imageIndex==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex = 1;
        }
    }
}
