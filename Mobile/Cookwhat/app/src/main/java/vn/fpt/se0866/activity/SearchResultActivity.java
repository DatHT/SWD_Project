package vn.fpt.se0866.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import vn.fpt.se0866.adapter.ResultAdapter;
import vn.fpt.se0866.common.core.AsyncLoader;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/15/2015.
 */
public class SearchResultActivity extends AppCompatActivity {
    public static final String DATA_EXCHANGE_OBJECT = "food";
    ListView listView;
    ResultAdapter adapter;
    private List<Food> foods;

    private int pageCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        //setSupportActionBar(toolbar);
        setTitle("");
        foods = executeData("bo", String.valueOf(0));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView = (ListView) findViewById(ResultAdapter.LAYOUT_RESOURCES_ID);
        adapter = new ResultAdapter(getBaseContext(), foods);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnScrollListener(onScrollListener());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchResultActivity.this, FoodDetailActivity.class);
                intent.putExtra(DATA_EXCHANGE_OBJECT, foods.get(position));
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private List<Food> executeData(String key, String start) {
    String[] params = {key, start, "5"};
    List<Food> tempFoods = null;
        AsyncLoader asy = new AsyncLoader(this);
        asy.execute(params);
        try {
            tempFoods = asy.get();
            pageCount++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  tempFoods;
    }

    private AbsListView.OnScrollListener onScrollListener() {
        return new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int threshold = 1;
                int count = listView.getCount();
                if (scrollState == SCROLL_STATE_IDLE) {
                    if (listView.getLastVisiblePosition() >= count -threshold && pageCount < getPageCount() + 2) {
                        List<Food> temps = executeData("bo", String.valueOf(count));
                        for(Food item: temps) {
                            foods.add(item);
                        }
                        adapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        };
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
