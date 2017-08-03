package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2017/8/3
 */

class ScaleTransformer extends BaseTransformer {

  private static final float SCALE_FACTOR = 0.9f;

  @Override protected void onTransform(View page, float position) {
    if (position < -1 || position > 1) {
      page.setScaleX(SCALE_FACTOR);
      page.setScaleY(SCALE_FACTOR);
    } else {
      float scale = Math.max(SCALE_FACTOR, 1 - Math.abs(position));

      page.setScaleX(scale);
      page.setScaleY(scale);
    }
  }

  @Override protected boolean isPreTransformEnable() {
    return false;
  }
}
