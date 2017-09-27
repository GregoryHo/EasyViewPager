package com.ns.greg.easyviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.ns.greg.library.easy_viewpager.EasyViewPager;
import com.ns.greg.library.easy_viewpager.adapter.BaseFragmentStatePagerAdapter;
import com.ns.greg.library.easy_viewpager.transformer.TransformerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/2
 */
public class DemoActivity extends AppCompatActivity {

  private EasyViewPager viewPager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_demo);

    List<Fragment> fragments = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      fragments.add(DemoFragment.newInstance(Integer.toString(i)));
    }

    DemoFragmentAdapter adapter = new DemoFragmentAdapter(getSupportFragmentManager(), fragments);

    viewPager = (EasyViewPager) findViewById(R.id.viewpager);
    viewPager.setScrollDurationFactor(1d);
    viewPager.setPageTransformer(false, TransformerFactory.orderScaleTransformer());
    viewPager.setAdapter(adapter);
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
}
