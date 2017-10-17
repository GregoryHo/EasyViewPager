package com.ns.greg.easyviewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.ns.greg.library.easy_viewpager.InfiniteViewPager;
import com.ns.greg.library.easy_viewpager.adapter.BaseFragmentStatePagerAdapter;
import com.ns.greg.library.easy_viewpager.adapter.InfinitePagerAdapter;
import com.ns.greg.library.easy_viewpager.transformer.TransformerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/2
 */
public class DemoActivity extends AppCompatActivity {

  private InfiniteViewPager viewPager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_demo);

    //DemoFragmentAdapter adapter = demoFragments();
    DemoInfinitePageAdapter adapter = demoPages();

    viewPager = (InfiniteViewPager) findViewById(R.id.viewpager);
    viewPager.setScrollDurationFactor(1d);
    viewPager.setPageTransformer(false, TransformerFactory.orderScaleTransformer());
    viewPager.setAdapter(adapter);
  }

  @NonNull private DemoInfinitePageAdapter demoPages() {
    List<DemoView> pages = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      pages.add(new DemoView(getApplicationContext(), Integer.toString(i)));
    }
    return new DemoInfinitePageAdapter(pages);
  }

  @NonNull private DemoFragmentAdapter demoFragments() {
    List<Fragment> fragments = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      fragments.add(DemoFragment.newInstance(Integer.toString(i)));
    }

    return new DemoFragmentAdapter(getSupportFragmentManager(), fragments);
  }

  private DemoFragmentAdapter getAdapter() {
    return (DemoFragmentAdapter) viewPager.getAdapter();
  }

  private static class DemoFragmentAdapter extends BaseFragmentStatePagerAdapter {

    DemoFragmentAdapter(FragmentManager fm) {
      super(fm);
    }

    DemoFragmentAdapter(FragmentManager fm, Fragment fragment) {
      super(fm, fragment);
    }

    DemoFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
      super(fm, fragments);
    }
  }

  private static class DemoInfinitePageAdapter extends InfinitePagerAdapter<DemoView> {

    public DemoInfinitePageAdapter(DemoView view) {
      super(view);
    }

    public DemoInfinitePageAdapter(List<DemoView> view) {
      super(view);
    }
  }
}
