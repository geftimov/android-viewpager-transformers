package com.eftimoff.viewpagertransformers;

import android.view.View;

public class ParallaxPageTransformer extends BaseTransformer {

    private final int viewToParallax;

    public ParallaxPageTransformer(final int viewToParallax) {
        this.viewToParallax = viewToParallax;

    }

    @Override
    protected void onTransform(View view, float position) {
        int pageWidth = view.getWidth();


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]

            view.findViewById(viewToParallax).setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }


    }

}
