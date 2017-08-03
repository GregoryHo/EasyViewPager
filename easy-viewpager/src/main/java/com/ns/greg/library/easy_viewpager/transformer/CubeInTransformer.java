package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/6
 */
class CubeInTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    page.setPivotX(position > 0f ? 0f : page.getWidth());
    page.setPivotY(page.getHeight() * 0.5f);
    page.setRotationY(-90f * position);
  }

  @Override protected boolean useDefaultAnimation() {
    return true;
  }
}
