package com.ns.greg.library.easy_viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import com.ns.greg.library.easy_viewpager.AdapterHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/3/10
 */
public abstract class BaseFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

  private static final String TAG = "BaseFragmentAdapter";
  private static final boolean DEBUG = false;

  private final List<Fragment> list = new ArrayList<Fragment>();

  public BaseFragmentStatePagerAdapter(FragmentManager fm) {
    super(fm);
  }

  public BaseFragmentStatePagerAdapter(FragmentManager fm, Fragment fragment) {
    this(fm);
    list.add(fragment);
  }

  public BaseFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
    this(fm);
    list.addAll(fragments);
  }

  public void add(Fragment fragment) {
    synchronized (list) {
      list.add(fragment);
    }

    notifyDataSetChanged();
  }

  public void remove(Fragment fragment) {
    synchronized (fragment) {
      list.remove(fragment);
    }

    notifyDataSetChanged();
  }

  public void remove(int index) {
    synchronized (list) {
      if (AdapterHelper.checkIsLegalIndex(list, index)) {
        list.remove(index);
      }
    }

    notifyDataSetChanged();
  }

  public int getIndex(Fragment fragment) {
    synchronized (list) {
      Iterator iterator = list.iterator();
      int index = 0;
      while (iterator.hasNext()) {
        if (iterator.next().equals(fragment)) {
          return index;
        }

        index++;
      }
    }

    return -1;
  }

  @Override public Fragment getItem(int position) {
    synchronized (list) {
      Fragment fragment = AdapterHelper.getListItem(list, position);
      if (fragment == null) {
        throw new AssertionError("Illegal position.");
      }

      return fragment;
    }
  }

  @Override public int getCount() {
    synchronized (list) {
      return list.size();
    }
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    Object fragment = super.instantiateItem(container, position);
    if (DEBUG) {
      Log.d(TAG, "instantiateItem, object : "
          + fragment.getClass().getSimpleName()
          + ", position : "
          + position);
    }

    return fragment;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    if (DEBUG) {
      Log.d(TAG, "destroyItem, object : "
          + object.getClass().getSimpleName()
          + ", position : "
          + position);
    }

    super.destroyItem(container, position, object);
  }
}
