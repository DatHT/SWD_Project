package vn.fpt.se0866.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.fpt.se0866.activity.BookmarkFoodDetailActivity;
import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.adapter.BookmarkAdapter;
import vn.fpt.se0866.manager.FoodManager;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/23/2015.
 */
public class TabBookmark extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {
    public static final String DATA_EXCHANGE_OBJECT = "DATADETAIL";
    private ListView listView;
    private BookmarkAdapter adapter;
    private List<Food> foods;
    private FoodManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bookmark, container, false);
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
        listView.setOnItemClickListener(this);
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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), BookmarkFoodDetailActivity.class);
        intent.putExtra(DATA_EXCHANGE_OBJECT, foods.get(position));
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
