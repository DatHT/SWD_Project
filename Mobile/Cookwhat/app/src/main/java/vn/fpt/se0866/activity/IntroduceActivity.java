package vn.fpt.se0866.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DatHT on 11/17/2015.
 */
public class IntroduceActivity extends AppCompatActivity {
    TextView tvIntro;
    Handler handler;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        tvIntro = (TextView) findViewById(R.id.introduce_tv);
        btnStart = (Button) findViewById(R.id.introduce_start_btn);
        handler = new Handler();
        final Animation animationSlideInLeft = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        final Animation animationSlideOutRight = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        animationSlideInLeft.setDuration(1000);
        animationSlideOutRight.setDuration(500);
        animationSlideInLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvIntro.startAnimation(animationSlideOutRight);

                    }
                }, 1000);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animationSlideOutRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        tvIntro.setText("Nấu gì bây giờ nhỉ?");
        tvIntro.startAnimation(animationSlideInLeft);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvIntro.setText("Icook sẽ giúp bạn chọn món ăn phù hợp.......");
                tvIntro.startAnimation(animationSlideInLeft);
            }
        }, 2700);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tvIntro.clearAnimation();
    }

    public void goToMain(View v)  {
        Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
