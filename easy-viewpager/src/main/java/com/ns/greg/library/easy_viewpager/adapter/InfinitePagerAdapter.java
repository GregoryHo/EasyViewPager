package com.ns.greg.library.easy_viewpager.adapter;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/9/30
 */

public abstract class InfinitePagerAdapter<T extends View> extends BasePageAdapter<T> {

  public InfinitePagerAdapter(T view) {
    super(view);
  }

  public InfinitePagerAdapter(List<T> view) {
    super(view);
  }

  @Override public int getCount() {
    if (getRealCount() == 0) {
      return 0;
    }

    return Integer.MAX_VALUE;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    final int virtualPosition = position % getRealCount();
    View view = get(virtualPosition);
    container.addView(view);
    return view;
  }

  public int getRealCount() {
    return getList().size();
  }
}
