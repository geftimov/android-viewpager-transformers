package com.eftimoff.viewpager.tranformators;

import android.view.View;

public class ParallaxPageTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		int pageWidth = view.getWidth();


		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setAlpha(1);

		} else if (position <= 1) { // [-1,1]

			view.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setAlpha(1);
		}


	}

}
