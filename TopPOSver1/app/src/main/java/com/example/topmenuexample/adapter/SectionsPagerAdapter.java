package com.example.topmenuexample.adapter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.topmenuexample.R;
import com.example.topmenuexample.ui.main.CalculateLayoutFragment;
import com.example.topmenuexample.ui.main.DaySellLayoutFragment;
import com.example.topmenuexample.ui.main.MenuLayoutFragment;
import com.example.topmenuexample.ui.main.OrderLayoutFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4};
    private final Context mContext;


    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.d("---", "position:" + position);
                return MenuLayoutFragment.newInstance(0, "MenuPage loaded");
            case 1:
                Log.d("---", "position:" + position);
                return OrderLayoutFragment.newInstance(1, "OrderPage loaded");
            case 2:
                Log.d("---", "position:" + position);
                return CalculateLayoutFragment.newInstance(2, "calculatePage loaded");
            case 3:
                Log.d("---", "position:" + position);
                return DaySellLayoutFragment.newInstance(3, "daySellPage loaded");

                default:
                    Log.d("---","position:null");
                    return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

}