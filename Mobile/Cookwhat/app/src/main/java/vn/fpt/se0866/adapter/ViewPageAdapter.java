package vn.fpt.se0866.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;


import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.fragment.TabBookmark;
import vn.fpt.se0866.fragment.TabSearch;

/**
 * Created by Daniel on 9/24/2015.
 * ViewPager adapter to provide the views for every page i.e every Tab
 */
public class ViewPageAdapter extends FragmentStatePagerAdapter {
    CharSequence titles[]; // store title of tab which are going to be pass when ViewPageAdapter is created
    int numOfTabs;
    int icons[] = {R.drawable.ic_home_black_48dp, R.drawable.ic_favorite_black_48dp};
    Context context;

    public ViewPageAdapter(FragmentManager fm, CharSequence[] titles, int numOfTabs, Context context) {
        super(fm);
        this.titles = titles;
        this.numOfTabs = numOfTabs;
        this.context = context;
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
        Drawable drawable = context.getResources().getDrawable(icons[position]);
        drawable.setBounds(0, 0, 72, 72);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //return titles[position];
        return spannableString;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
