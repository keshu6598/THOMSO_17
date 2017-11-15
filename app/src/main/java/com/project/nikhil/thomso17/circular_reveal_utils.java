package com.project.nikhil.thomso17;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;

import static android.view.ViewAnimationUtils.createCircularReveal;
/**
 * Created by nikhil on 11/10/17.
 */

public class circular_reveal_utils {


    private int revealX;
    private int revealY;

    View rootLayout;

    public circular_reveal_utils(View view, Intent intent) {

        rootLayout = view;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
                intent.hasExtra(view.getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_X)) &&
                intent.hasExtra(view.getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_Y))) {
            rootLayout.setVisibility(View.INVISIBLE);

            revealX = intent.getIntExtra(view.getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_X), 0);
            revealY = intent.getIntExtra(view.getResources().getString(R.string.EXTRA_CIRCULAR_REVEAL_Y), 0);


            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        revealActivity(revealX, revealY);
                        rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            rootLayout.setVisibility(View.VISIBLE);
        }
    }

    protected void revealActivity(int x, int y) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);

            // create the animator for this view (the start radius is zero)
            Animator circularReveal = createCircularReveal(rootLayout, x, y, 0, finalRadius);
            circularReveal.setDuration(400);
            circularReveal.setInterpolator(new AccelerateInterpolator());

            // make the view visible and start the animation
            rootLayout.setVisibility(View.VISIBLE);
            circularReveal.start();
        } else {
            //  finish();
        }
    }


    protected void unRevealActivity() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //       finish();
        } else {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);
            Animator circularReveal = createCircularReveal(
                    rootLayout, revealX, revealY, finalRadius, 0);

            circularReveal.setDuration(400);
            circularReveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    rootLayout.setVisibility(View.INVISIBLE);
                    //            finish();
                }
            });


            circularReveal.start();
        }

    }
}
