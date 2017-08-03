package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class DefaultTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    // do nothing
  }

  @Override protected boolean useDefaultAnimation() {
    return true;
  }
}
