package com.ns.greg.library.easy_viewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Field;

/**
 * @author Gregory
 * @since 2016/4/1
 */
public class EasyViewPager extends ViewPager {

  private boolean isSwipe = true;
  private CustomScroller mScroller = null;

  public EasyViewPager(Context context) {
    super(context);
    postInitViewPager();
  }

  public EasyViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
    postInitViewPager();
  }

  /**
   * Override the Scroller instance with our own class so we can change the duration
   */
  private void postInitViewPager() {
    try {
      Field scroller = ViewPager.class.getDeclaredField("mScroller");
      scroller.setAccessible(true);
      Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
      interpolator.setAccessible(true);

      mScroller = new CustomScroller(getContext(), (Interpolator) interpolator.get(null));
      scroller.set(this, mScroller);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the scroll factor for adjust speed
   *
   * @param scrollFactor 1 is default speed, factor is inversely proportional to speed
   */
  public void setScrollDurationFactor(double scrollFactor) {
    mScroller.setScrollDurationFactor(scrollFactor);
  }

  public void setSwipeEnable(boolean enable) {
    isSwipe = enable;
  }

  @Override public boolean onTouchEvent(MotionEvent ev) {
    return isSwipe && super.onTouchEvent(ev);
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent event) {
    return isSwipe && super.onInterceptTouchEvent(event);
  }

  private static class CustomScroller extends Scroller {

    private double mScrollFactor = 1;

    CustomScroller(Context context) {
      super(context);
    }

    CustomScroller(Context context, Interpolator interpolator) {
      super(context, interpolator);
    }

    @SuppressLint("NewApi")
    public CustomScroller(Context context, Interpolator interpolator, boolean flywheel) {
      super(context, interpolator, flywheel);
    }

    /**
     * Set the factor by which the duration will change
     */
    void setScrollDurationFactor(double scrollFactor) {
      mScrollFactor = scrollFactor;
    }

    @Override public void startScroll(int startX, int startY, int dx, int dy, int duration) {
      super.startScroll(startX, startY, dx, dy, (int) (duration * mScrollFactor));
    }
  }
}