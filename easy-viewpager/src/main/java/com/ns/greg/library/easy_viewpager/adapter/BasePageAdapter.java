package com.ns.greg.library.easy_viewpager.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.ns.greg.library.easy_viewpager.AdapterHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/3/10
 */
public abstract class BasePageAdapter<T extends View> extends PagerAdapter {

  private static final String TAG = "BasePageAdapter";
  private static final boolean DEBUG = false;

  private final List<T> list = new ArrayList<>();

  public BasePageAdapter(T view) {
    this.list.add(view);
  }

  public BasePageAdapter(List<T> view) {
    this.list.addAll(view);
  }

  @Override public int getCount() {
    synchronized (list) {
      return list.size();
    }
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view.equals(object);
  }

  @SuppressWarnings("unchecked") @Override public int getItemPosition(Object object) {
    debug("getItemPosition, object: [" + object.hashCode() + "]");
    int index = getIndex((T) object);
    if (index == -1) {
      return POSITION_NONE;
    }

    return index;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    View view = get(position);
    debug("instantiateItem, position: [" + position + "], object: [" + view.hashCode() + "]");
    if (view.getParent() == null) {
      container.addView(view);
    }

    return view;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    debug("destroyItem, position: [" + position + "], object: [" + object.hashCode() + "]");
    container.removeView((View) object);
  }

  public List<T> getList() {
    return list;
  }

  /**
   * Update list must be called on UI-thread
   *
   * @param views list of view
   */
  public void updateList(List<T> views) {
    synchronized (list) {
      list.clear();
      list.addAll(views);
    }

    notifyDataSetChanged();
  }

  public void clear() {
    synchronized (list) {
      list.clear();
    }

    notifyDataSetChanged();
  }

  /**
   * Check list contains object or not
   */
  protected boolean contains(Object object) {
    synchronized (list) {
      Iterator<T> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (iterator.next().equals(object)) {
          return true;
        }
      }
    }

    return false;
  }

  public void add(T view) {
    synchronized (list) {
      list.add(view);
    }

    notifyDataSetChanged();
  }

  public void addAll(List<T> views) {
    synchronized (list) {
      list.addAll(views);
    }

    notifyDataSetChanged();
  }

  public void remove(T view) {
    synchronized (list) {
      list.remove(view);
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

  public T get(int index) {
    synchronized (list) {
      return AdapterHelper.getListItem(list, index);
    }
  }

  public int getIndex(T view) {
    synchronized (list) {
      Iterator<T> iterator = list.iterator();
      int index = 0;
      while (iterator.hasNext()) {
        if (iterator.next().equals(view)) {
          return index;
        }

        index++;
      }
    }

    return -1;
  }

  private void debug(String message) {
    if (DEBUG) {
      Log.e(TAG, message);
    }
  }
}
