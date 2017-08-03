package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class ScaleInOutTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    page.setPivotX(position < 0 ? 0 : page.getWidth());
    page.setPivotY(page.getHeight() / 2f);
    float scale = position < 0 ? 1f + position : 1f - position;
    page.setScaleX(scale);
    page.setScaleY(scale);
  }
}
