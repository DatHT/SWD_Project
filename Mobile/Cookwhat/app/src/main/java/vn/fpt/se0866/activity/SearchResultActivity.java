package vn.fpt.se0866.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import vn.fpt.se0866.adapter.ResultAdapter;
import vn.fpt.se0866.dataloader.FoodsAsyncLoader;
import vn.fpt.se0866.common.core.IOnTaskCompleted;
import vn.fpt.se0866.fragment.TabSearch;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/15/2015.
 */
public class SearchResultActivity extends AppCompatActivity{
    public static final String DATA_EXCHANGE_OBJECT = "food";
    ListView listView;
    ResultAdapter adapter;
    private List<Food> foods;
    private String textSearch;
    private int pageCount;
    private IOnTaskCompleted complete;

    public SearchResultActivity() {
        pageCount = 0;
        complete = new IOnTaskCompleted() {
            @Override
            public void onTaskCompleted(Object list) {
                if (adapter == null) {
                    if (list != null)
                        foods = (List<Food>) list;
                    else foods = new ArrayList<>();
                    adapter = new ResultAdapter(getBaseContext(), foods);
                    adapter.notifyDataSetChanged();
                    listView.setAdapter(adapter);
                }else {
                    foods.addAll((Collection<? extends Food>) list);
                    adapter.notifyDataSetChanged();
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        checkSupportAndroidVersion();
        setTitle("");
        Intent intent = getIntent();
        textSearch = intent.getStringExtra(TabSearch.TEXT_SEARCH_EXTRA);
        executeData(textSearch, String.valueOf(0));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView = (ListView) findViewById(ResultAdapter.LAYOUT_RESOURCES_ID);
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


    private void executeData(String key, String start) {
        String[] params = {key, start, "10"};
        FoodsAsyncLoader asy = new FoodsAsyncLoader(this, complete);
        asy.execute(params);
        pageCount++;
    }

    private AbsListView.OnScrollListener onScrollListener() {
        return new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int threshold = 1;
                int count = listView.getCount();

                if (scrollState == SCROLL_STATE_IDLE) {
                    if (listView.getLastVisiblePosition() >= count -threshold && pageCount < pageCount + 2) {
                        executeData(textSearch, String.valueOf(count + 1));
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

    private void checkSupportAndroidVersion() {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){
            Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
            setSupportActionBar(toolbar);
        }
    }

}
