package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class FlipVerticalTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    final float rotation = -180f * position;

    page.setAlpha(rotation > 90f || rotation < -90f ? 0f : 1f);
    page.setPivotX(page.getWidth() * 0.5f);
    page.setPivotY(page.getHeight() * 0.5f);
    page.setRotationX(rotation);
  }
}
