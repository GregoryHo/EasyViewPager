package com.ns.greg.library.easy_viewpager.adapter;

import android.support.v4.view.PagerAdapter;
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

  @Override public Object instantiateItem(ViewGroup container, int position) {
    View view = get(position);
    container.addView(view);

    return view;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
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
    clear();
    addAll(views);
  }

  /**
   * Check list contains object or not
   */
  protected boolean contains(Object object) {
    synchronized (list) {
      for (T t : list) {
        if (t.equals(object)) {
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

  public void clear() {
    synchronized (list) {
      list.clear();
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
}
