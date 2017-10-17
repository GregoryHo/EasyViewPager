package com.ns.greg.easyviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author Gregory
 * @since 2017/9/30
 */

public class DemoView extends FrameLayout {

  private String title;

  public DemoView(Context context, String title) {
    this(context, null, title);
  }

  public DemoView(Context context, AttributeSet attrs, String title) {
    this(context, attrs, 0, title);
  }

  public DemoView(Context context, AttributeSet attrs, int defStyle, String title) {
    super(context, attrs, defStyle);
    this.title = title;
    findView();
  }

  private void findView() {
    LayoutInflater.from(getContext()).inflate(R.layout.page_demo, this, true);
    ((TextView) findViewById(R.id.title_tv)).setText(title);
  }
}
