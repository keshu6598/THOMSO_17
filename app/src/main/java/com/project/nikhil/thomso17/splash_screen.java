package com.project.nikhil.thomso17;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class splash_screen extends AppCompatActivity {
    Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();

    }
    private void StartAnimations()
    {
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView)findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);
        splashThread = new Thread()
        {
            @Override
            public  void run()
            {
                try {
                    int waited = 0;
                    while (waited<3000)
                    {
                        sleep(100);
                        waited+=100;
                    }
                    Intent intent = new Intent(splash_screen.this,LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    splash_screen.this.finish();
                }
                catch (InterruptedException e)
                {

                }
                finally {
                    splash_screen.this.finish();
                }
            }
        };
        splashThread.start();
    }
}
