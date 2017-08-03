package com.ns.greg.library.easy_viewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author Gregory
 * @since 2016/4/6
 */
public abstract class BaseTransformer implements ViewPager.PageTransformer {

  private static final float DEFAULT_SCALE = 1f;

  /**
   * @param page Apply the transformation to this page
   * @param position Position of page relative to the current front-and-center position of the
   * pager. 0 is front and center. 1 is one full page position to the right, and
   * -1 is one page position to the left.
   */
  @Override public void transformPage(View page, float position) {
    if (isPreTransformEnable()) {
      onPreTransform(page, position);
    }

    onTransform(page, position);
    onPostTransform(page, position);
  }

  /**
   * previous for transform
   */
  private void onPreTransform(View page, float position) {
    float width = page.getWidth();

    /**
     * Sets the degrees that the view is rotated around the pivot point. Increasing values
     * result in clockwise rotation.
     *
     * @param rotation The degrees of rotation.
     */
    page.setRotation(0f);

    /**
     * Sets the degrees that the view is rotated around the horizontal axis through the pivot point.
     * Increasing values result in clockwise rotation from the viewpoint of looking down the
     * x axis.
     *
     * @param rotationX The degrees of X rotation.
     */
    page.setRotationX(0f);

    /**
     * Sets the degrees that the view is rotated around the vertical axis through the pivot point.
     * Increasing values result in counter-clockwise rotation from the viewpoint of looking
     * down the y axis.
     *
     * @param rotationY The degrees of Y rotation.
     */
    page.setRotationY(0f);

    /**
     * Sets the amount that the view is scaled in x around the pivot point, as a proportion of
     * the view's unscaled width. A value of 1 means that no scaling is applied.
     *
     * @param scaleX The scaling factor.
     */
    page.setScaleX(DEFAULT_SCALE);

    /**
     * Sets the amount that the view is scaled in Y around the pivot point, as a proportion of
     * the view's unscaled width. A value of 1 means that no scaling is applied.
     *
     * @param scaleX The scaling factor.
     */
    page.setScaleY(DEFAULT_SCALE);

    /**
     * The x location of the point around which the view is
     * {@link #setRotation(float) rotated} and {@link #setScaleX(float) scaled}.
     *
     *  @param pivotX The x location of the pivot point.
     */
    page.setPivotX(0f);

    /**
     * The y location of the point around which the view is
     * {@link #setRotation(float) rotated} and {@link #setScaleY(float) scaled}.
     *
     *  @param pivotY The y location of the pivot point.
     */
    page.setPivotY(0f);

    /**
     * Sets the horizontal location of this view relative to its {@link #getLeft() left} position.
     * This effectively positions the object post-layout, in addition to wherever the object's
     * layout placed it.
     *
     * @param translationX The horizontal position of this view relative to its left position,
     * in pixels.
     */
    page.setTranslationX(useDefaultAnimation() ? 0f : -width * position);

    /**
     * Sets the vertical location of this view relative to its {@link #getTop() top} position.
     * This effectively positions the object post-layout, in addition to wherever the object's
     * layout placed it.
     *
     * @param translationY The vertical position of this view relative to its top position,
     * in pixels.
     */
    page.setTranslationY(0f);

    if (isHideOffScreen()) {
      page.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
      page.setEnabled(false);
    } else {
      page.setAlpha(1f);
      page.setEnabled(true);
    }
  }

  /**
   * doing transform
   */
  protected abstract void onTransform(View page, float position);

  /**
   * post for transform
   */
  protected void onPostTransform(View page, float position) {
    // TODO...
  }

  /**
   * Indicates if reset view property before transform
   *
   * @return true enable, false disable
   */
  protected boolean isPreTransformEnable() {
    return true;
  }

  /**
   * If the position offset of a fragment is less than negative one or greater than one, returning
   * true will set the fragment alpha to 0f. Otherwise fragment alpha is always defaulted to 1f.
   */
  protected boolean isHideOffScreen() {
    return true;
  }

  /**
   * Indicates if the default animations of the view pager should be used.
   */
  protected boolean useDefaultAnimation() {
    return false;
  }

  /**
   * Same as {@link Math#min(double, double)} without double casting, zero closest to infinity
   * handling, or NaN support.
   */
  static float min(float val, float min) {
    return val < min ? min : val;
  }
}
