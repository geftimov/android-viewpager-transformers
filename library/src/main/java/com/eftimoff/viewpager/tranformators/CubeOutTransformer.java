package com.eftimoff.viewpager.tranformators;

import android.view.View;

public class CubeOutTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setPivotX(position < 0f ? view.getWidth() : 0f);
		view.setPivotY(view.getHeight() * 0.5f);
		view.setRotationY(90f * position);
	}

	@Override
	public boolean isPagingEnabled() {
		return true;
	}

}
