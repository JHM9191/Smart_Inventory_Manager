package com.example.topmenuexample.ui.main;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.topmenuexample.R;

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
                return menulayout.newInstance(0, "MenuPage");
            case 1:
                Log.d("---", "position:" + position);
                return orderlayout.newInstance(1, "OrderPage");
            case 2:
                Log.d("---", "position:" + position);
                return calculatelayout.newInstance(2, "calculatePage");
            case 3:
                Log.d("---", "position:" + position);
                return dayselllayout.newInstance(3, "daySellPage");

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