package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class ZoomInTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    final float scale = position < 0 ? position + 1f : Math.abs(1f - position);
    page.setScaleX(scale);
    page.setScaleY(scale);
    page.setPivotX(page.getWidth() * 0.5f);
    page.setPivotY(page.getHeight() * 0.5f);
    page.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
  }
}
