package vn.fpt.se0866.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.fpt.se0866.activity.R;

/**
 * Created by DatHT on 11/23/2015.
 */
public class TabBookmark extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab2, container, false);
        return v;
    }

}
