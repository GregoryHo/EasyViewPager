package com.ns.greg.easyviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Gregory
 * @since 2017/8/2
 */
public class DemoFragment extends Fragment {

  public static DemoFragment newInstance(String name) {
    DemoFragment demoFragment = new DemoFragment();
    Bundle bundle = new Bundle();
    bundle.putString("title", name);
    demoFragment.setArguments(bundle);
    return demoFragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return LayoutInflater.from(getContext()).inflate(R.layout.page_demo, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Bundle bundle = getArguments();
    String title = bundle.getString("title", "");
    if (!title.isEmpty()) {
      ((TextView) view.findViewById(R.id.title_tv)).setText(title);
    }
  }
}
