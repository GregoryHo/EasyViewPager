package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class RotateUpTransformer extends BaseTransformer {

  private static final float ROTATE_FACTOR = -15f;

  @Override protected void onTransform(View page, float position) {
    final float width = page.getWidth();
    final float rotation = ROTATE_FACTOR * position;

    page.setPivotX(width * 0.5f);
    page.setPivotY(0f);
    page.setTranslationX(0f);
    page.setRotation(rotation);
  }

  @Override protected boolean useDefaultAnimation() {
    return true;
  }
}
