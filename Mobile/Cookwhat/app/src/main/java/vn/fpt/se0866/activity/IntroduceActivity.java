package vn.fpt.se0866.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by DatHT on 11/17/2015.
 */
public class IntroduceActivity extends AppCompatActivity {
    TextView tvIntro;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        tvIntro = (TextView) findViewById(R.id.introduce_tv);
        handler = new Handler();
        tvIntro.setText("Hôm nay nấu gì nhỉ?");
        tvIntro.startAnimation(AnimationUtils.loadAnimation(IntroduceActivity.this, android.R.anim.slide_in_left));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvIntro.setText("Bạn đã chuẩn bị những nguyên liệu?");
                tvIntro.startAnimation(AnimationUtils.loadAnimation(IntroduceActivity.this, R.anim.right_left));
            }
        }, 3000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
