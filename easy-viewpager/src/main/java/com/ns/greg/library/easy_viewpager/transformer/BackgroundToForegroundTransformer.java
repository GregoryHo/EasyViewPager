package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class BackgroundToForegroundTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    final float height = page.getHeight();
    final float width = page.getWidth();
    final float scale = min(position < 0 ? 1f + position : Math.abs(1f - position), 0.5f);

    page.setScaleX(scale);
    page.setScaleY(scale);
    page.setPivotX(width * 0.5f);
    page.setPivotY(height * 0.5f);
    page.setTranslationX(position < 0 ? width * position * 0.25f : -width * position * 0.25f);
  }
}
