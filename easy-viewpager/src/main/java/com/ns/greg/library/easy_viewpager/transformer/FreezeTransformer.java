package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/5/29
 */
class FreezeTransformer extends BaseTransformer {
  @Override protected void onTransform(View page, float position) {
    if (position <= -1.0f) {
      page.setAlpha(0);
    } else if (position < 0f) {
      page.setAlpha(1);
      page.setTranslationX((int) ((float) (page.getWidth()) * -position));
    } else if (position >= 0f) {
      page.setAlpha(1);
    } else if (position > 1.0f) {
      page.setAlpha(0);
    }
  }
}
