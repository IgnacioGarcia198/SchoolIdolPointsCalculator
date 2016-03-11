package com.nacho.schoolidolpoints5;

import android.os.Bundle;
import android.os.CountDownTimer;

import static com.nacho.schoolidolpoints5.GlobalFunctions.pullBoolean;

public class HomeScreen extends MyActivity {
    private boolean checked = true;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        countDownTimer = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                checked = pullBoolean("checked", getApplicationContext());
                if(checked) {
                    changeScreenClosing(MainActivity.class);
                }
                else {
                    changeScreenClosing(GreetingScreen.class);
                }
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();
        countDownTimer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
