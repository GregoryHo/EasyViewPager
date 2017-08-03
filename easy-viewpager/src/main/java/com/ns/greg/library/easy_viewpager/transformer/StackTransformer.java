package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class StackTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    page.setTranslationX(position < 0 ? 0f : -page.getWidth() * position);
  }
}
