package vn.fpt.se0866.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.activity.SearchResultActivity;

/**
 * Created by DatHT on 11/23/2015.
 */
public class TabSearch extends android.support.v4.app.Fragment {

    public static final String TEXT_SEARCH_EXTRA = "TEXTSEARCH";
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
        hideKeyboard();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textSearch = "";
                try {
                    String temp = etSearch1.getText().toString().trim();
                    if (!temp.equals("")) {

                        textSearch += Base64.encode(temp.getBytes("UTF-8"), Base64.DEFAULT);
                    }
                    temp = etSearch2.getText().toString().trim();
                    if (!temp.equals("")) {
                        textSearch = textSearch + "-" + Base64.encode(temp.getBytes("UTF-8"), Base64.DEFAULT);
                    }
                    temp = etSearch3.getText().toString().trim();
                    if (!temp.equals("")) {
                        textSearch = textSearch + "-" + Base64.encode(temp.getBytes("UTF-8"), Base64.DEFAULT);
                    }
                    temp = etSearch4.getText().toString().trim();
                    if (!temp.equals("")) {
                        textSearch = textSearch + "-" + Base64.encode(temp.getBytes("UTF-8"), Base64.DEFAULT);
                    }
                    temp = etSearch5.getText().toString().trim();
                    if (!temp.equals("")) {
                        textSearch = textSearch + "-" + Base64.encode(temp.getBytes("UTF-8"), Base64.DEFAULT);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                intent.putExtra(TEXT_SEARCH_EXTRA, textSearch);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });
    }

    private void hideKeyboard() {
        etSearch1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftkeyboeard(v);
                }
            }
        });
        etSearch2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftkeyboeard(v);
                }
            }
        });
        etSearch3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftkeyboeard(v);
                }
            }
        });
        etSearch4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftkeyboeard(v);
                }
            }
        });
        etSearch5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideSoftkeyboeard(v);
                }
            }
        });
    }

    private void hideSoftkeyboeard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
