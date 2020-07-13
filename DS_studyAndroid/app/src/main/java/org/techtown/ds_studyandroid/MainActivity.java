package org.techtown.ds_studyandroid;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvShow;
    private Button btnCheck;
    private ImageButton ibtnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initView
        tvShow = findViewById(R.id.tvName);
        btnCheck = findViewById(R.id.btnCheck);
        ibtnPlus = findViewById(R.id.ibtnPlus);


        String str = tvShow.getText().toString();

        tvShow.setText(str+" 더블슬래시");

        tvShow.setTextColor(Color.parseColor("#123ABC"));
        tvShow.setPadding(10,10,10,10);
        tvShow.getTextColors();
        tvShow.getPaddingBottom();

        //initInstance

        //initListener
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼 클릭 시 발생 이벤트
            }
        });

        ibtnPlus.setOnClickListener(ibtnListener);


    }

    View.OnClickListener ibtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //버튼 클릭 시 발생 이벤트
            //버튼 여러개와 리스너 하나를 매칭시킬 수 있음.
            //권장
            //비슷한 부류의 리스너끼리 묶어서 사용
            //switch문 활용하는 것도 좋음.
        }
    };

}
