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

  public void updateList(List<Fragment> list) {
    this.list.clear();
    this.list.addAll(list);
    notifyDataSetChanged();
  }

  public void clear() {
    synchronized (list) {
      list.clear();
    }

    notifyDataSetChanged();
  }

  public List<Fragment> getList() {
    return list;
  }

  public boolean contains(Object object) {
    synchronized (list) {
      for (Fragment fragment : list) {
        if (fragment.equals(object)) {
          return true;
        }
      }

      return false;
    }
  }

  public void add(Fragment fragment) {
    synchronized (list) {
      list.add(fragment);
    }

    notifyDataSetChanged();
  }

  public void set(int index, Fragment fragment) {
    synchronized (list) {
      list.set(index, fragment);
    }
  }

  public void remove(Fragment fragment) {
    synchronized (list) {
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

  @Override public int getItemPosition(Object object) {
    debug("getItemPosition, object: [" + object.hashCode() + "]");
    int index = getIndex((Fragment) object);
    if (index == -1) {
      return POSITION_NONE; // return for create new instance
    }

    return index;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    Fragment fragment = (Fragment) super.instantiateItem(container, position);
    debug("instantiateItem, position : " + position + ", object : " + fragment.hashCode());
    set(position, fragment);
    return fragment;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    debug("destroyItem, position : " + position + ", object : " + object.hashCode());
    super.destroyItem(container, position, object);
  }

  private void debug(String message) {
    if (DEBUG) {
      Log.e(TAG, message);
    }
  }
}
