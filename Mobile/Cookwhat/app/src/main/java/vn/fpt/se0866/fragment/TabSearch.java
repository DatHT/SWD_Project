package vn.fpt.se0866.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.activity.SearchResultActivity;

/**
 * Created by DatHT on 11/23/2015.
 */
public class TabSearch extends android.support.v4.app.Fragment {

    EditText etSearch1, etSearch2, etSearch3, etSearch4, etSearch5;
    ImageView btnSearch;
    int count = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etSearch1 = (EditText) view.findViewById(R.id.search_1_et);
        etSearch2 = (EditText) view.findViewById(R.id.search_2_et);
        etSearch3 = (EditText) view.findViewById(R.id.search_3_et);
        etSearch4 = (EditText) view.findViewById(R.id.search_4_et);
        etSearch5 = (EditText) view.findViewById(R.id.search_5_et);
        btnSearch = (ImageView) view.findViewById(R.id.search_btn);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.search_fab);
        count = 2;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count) {
                    case 2:
                        count++;
                        etSearch2.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        count++;
                        etSearch3.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        count++;
                        etSearch4.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        count++;
                        etSearch5.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });
    }
}
