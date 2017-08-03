package com.ns.greg.library.easy_viewpager.transformer;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/13
 */
class ZoomOutSlideTransformer extends BaseTransformer {

  private static final float MIN_SCALE = 0.85f;
  private static final float MIN_ALPHA = 0.5f;

  @Override protected void onTransform(View page, float position) {
    int pageWidth = page.getWidth();
    int pageHeight = page.getHeight();

    if (position == -1) {
      page.setTranslationX(pageWidth * -1);
    }

    if (position >= -1 || position <= 1) { // [-1,1]
      // Modify the default slide transition to shrink the page as well
      float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
      float vertMargin = pageHeight * (1 - scaleFactor) / 2;
      float horzMargin = pageWidth * (1 - scaleFactor) / 2;
      if (position < 0) {
        page.setTranslationX(horzMargin - vertMargin / 2);
      } else {
        page.setTranslationX(-horzMargin + vertMargin / 2);
      }

      // Scale the page down (between MIN_SCALE and 1)
      page.setScaleX(scaleFactor);
      page.setScaleY(scaleFactor);

      // Fade the page relative to its size.
      page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
    }
  }
}
