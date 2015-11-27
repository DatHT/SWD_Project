package vn.fpt.se0866.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import vn.fpt.se0866.fragment.TabBookmark;
import vn.fpt.se0866.fragment.TabSearch;

/**
 * Created by Daniel on 9/24/2015.
 * ViewPager adapter to provide the views for every page i.e every Tab
 */
public class ViewPageAdapter extends FragmentStatePagerAdapter {
    CharSequence titles[]; // store title of tab which are going to be pass when ViewPageAdapter is created
    int numOfTabs;

    public ViewPageAdapter(FragmentManager fm, CharSequence[] titles, int numOfTabs) {
        super(fm);
        this.titles = titles;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            TabSearch tabSearch = new TabSearch();
            return  tabSearch;
        }else {
            TabBookmark tabBookmark = new TabBookmark();
            return tabBookmark;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
