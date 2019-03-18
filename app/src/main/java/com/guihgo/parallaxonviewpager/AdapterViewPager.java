package com.guihgo.parallaxonviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.guihgo.parallaxonviewpager.kin.FragmentStatePagerAdapter;


public class AdapterViewPager extends FragmentStatePagerAdapter {
    int[] imgArr = new int[]{R.drawable.img_0037, R.drawable.img_3174, R.drawable.img_3175, R.drawable.img_3185, R.drawable.img_3943, R.drawable.img_3944};

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentPage fragmentPage = new FragmentPage();
        Bundle bundle = new Bundle();
        bundle.putInt("img", imgArr[position]);
        fragmentPage.setArguments(bundle);
        return fragmentPage;
    }

    @Override
    public int getCount() {
        return imgArr.length; //the number of paggers on ViewPager -_-
    }
}

