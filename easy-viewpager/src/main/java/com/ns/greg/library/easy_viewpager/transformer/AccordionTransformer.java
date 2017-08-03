package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class AccordionTransformer extends BaseTransformer {

  @Override protected void onTransform(View page, float position) {
    page.setPivotX(position < 0 ? 0 : page.getWidth());
    page.setScaleX(position < 0 ? 1f + position : 1f - position);
  }
}
