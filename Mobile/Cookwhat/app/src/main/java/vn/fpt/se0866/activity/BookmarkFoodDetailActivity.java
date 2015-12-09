package vn.fpt.se0866.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vn.fpt.se0866.fragment.TabBookmark;
import vn.fpt.se0866.manager.FoodManager;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 12/6/2015.
 */
public class BookmarkFoodDetailActivity extends AppCompatActivity {
    private FoodManager manager;
    private Food food;
    private static final String HTML_STYLE = "<style>img{display: inline;height: auto;max-width: 100%;}</style>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        checkSupportAndroidVersion();
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        manager = new FoodManager(this);
        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra(TabBookmark.DATA_EXCHANGE_OBJECT);


        //load view
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(food.getFoodName());
        ImageView cover = (ImageView) findViewById(R.id.food_detail_cover_iv);
        Picasso.with(this).load(food.getAvatarLink()).placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(cover);
        WebView wvMaterial = (WebView) findViewById(R.id.food_detail_material_wv);
        wvMaterial.loadDataWithBaseURL(null, HTML_STYLE + "<h2>Nguyên liệu</h2>" + food.getMaterialDetail(), "text/html", "UTF-8", null);

        WebView wvTuitorial = (WebView) findViewById(R.id.food_detail_tuitorial_wv);
        wvTuitorial.loadDataWithBaseURL(null, HTML_STYLE + "<h2>Hướng dẫn nấu</h2>" + food.getTutorial(), "text/html", "UTF-8", null);

        TextView tvSource = (TextView) findViewById(R.id.food_detail_source_tv);
        tvSource.setText("Nguồn: " + food.getSource());

        food.setMaterialDetail(food.getMaterialDetail());
        food.setTutorial(food.getTutorial());
        food.setSource(food.getSource());

        //disable foating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
    }

    private void checkSupportAndroidVersion() {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){
            Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
