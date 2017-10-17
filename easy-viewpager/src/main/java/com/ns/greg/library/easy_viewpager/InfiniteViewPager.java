package com.ns.greg.library.easy_viewpager;

import android.content.Context;
import android.util.AttributeSet;
import com.ns.greg.library.easy_viewpager.adapter.InfinitePagerAdapter;

/**
 * @author Gregory
 * @since 2017/9/30
 */

public class InfiniteViewPager extends EasyViewPager {

  public InfiniteViewPager(Context context) {
    super(context);
  }

  public InfiniteViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public void setCurrentItem(int item, boolean smoothScroll) {
    if (getAdapter().getCount() == 0) {
      super.setCurrentItem(item, smoothScroll);
      return;
    }
    item = getOffsetAmount() + (item % getAdapter().getCount());
    super.setCurrentItem(item, smoothScroll);
  }

  public int getOffsetAmount() {
    if (getAdapter().getCount() == 0) {
      return 0;
    }

    if (getAdapter() instanceof InfinitePagerAdapter) {
      InfinitePagerAdapter adapter = (InfinitePagerAdapter) getAdapter();
      return adapter.getRealCount() * 100;
    } else {
      return 0;
    }
  }
}
