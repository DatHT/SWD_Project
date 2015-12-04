package vn.fpt.se0866.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.adapter.BookmarkAdapter;
import vn.fpt.se0866.adapter.ResultAdapter;
import vn.fpt.se0866.manager.FoodManager;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/23/2015.
 */
public class TabBookmark extends android.support.v4.app.Fragment {
    private ListView listView;
    private BookmarkAdapter adapter;
    private List<Food> foods;
    private FoodManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_search_result, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(BookmarkAdapter.LAYOUT_RESOURCE_ID);
        manager = new FoodManager(view.getContext());
        foods = manager.getAll();
        if (foods == null) {
            foods = new ArrayList<>();
        }

        adapter = new BookmarkAdapter(view.getContext(), foods);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        manager = new FoodManager(getActivity());
        foods = manager.getAll();
        if (foods == null) {
            foods = new ArrayList<>();
        }

        adapter = new BookmarkAdapter(getActivity(), foods);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }


}
