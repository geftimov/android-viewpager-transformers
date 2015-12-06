/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.eftimoff.viewpagertransformers;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public abstract class BaseTransformer implements PageTransformer {

	/**
	 * Called each {@link #transformPage(android.view.View, float)}.
	 *
	 * @param view
	 * @param position
	 */
	protected abstract void onTransform(View view, float position);

	@Override
	public void transformPage(View view, float position) {
		onPreTransform(view, position);
		onTransform(view, position);
		onPostTransform(view, position);
	}

	/**
	 * If the position offset of a fragment is less than negative one or greater than one, returning true will set the
	 * visibility of the fragment to {@link android.view.View#GONE}. Returning false will force the fragment to {@link android.view.View#VISIBLE}.
	 *
	 * @return
	 */
	protected boolean hideOffscreenPages() {
		return true;
	}

	/**
	 * Indicates if the default animations of the view pager should be used.
	 *
	 * @return
	 */
	protected boolean isPagingEnabled() {
		return false;
	}

	/**
	 * Called each {@link #transformPage(android.view.View, float)} before {{@link #onTransform(android.view.View, float)} is called.
	 *
	 * @param view
	 * @param position
	 */
	protected void onPreTransform(View view, float position) {
		final float width = view.getWidth();

		view.setRotationX(0);
		view.setRotationY(0);
		view.setRotation(0);
		view.setScaleX(1);
		view.setScaleY(1);
		view.setPivotX(0);
		view.setPivotY(0);
		view.setTranslationY(0);
		view.setTranslationX(isPagingEnabled() ? 0f : -width * position);

		if (hideOffscreenPages()) {
			view.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
		} else {
			view.setAlpha(1f);
		}
	}

	/**
	 * Called each {@link #transformPage(android.view.View, float)} call after {@link #onTransform(android.view.View, float)} is finished.
	 *
	 * @param view
	 * @param position
	 */
	protected void onPostTransform(View view, float position) {
	}

}
