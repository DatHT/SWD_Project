package vn.fpt.se0866.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;

import vn.fpt.se0866.common.core.IOnTaskCompleted;
import vn.fpt.se0866.dataloader.FoodDetailAsyncLoader;
import vn.fpt.se0866.manager.FoodManager;
import vn.fpt.se0866.model.Food;
import vn.fpt.se0866.model.FoodDetail;

public class FoodDetailActivity extends AppCompatActivity implements IOnTaskCompleted {
    private FoodManager manager;
    protected FoodDetail foodDetail;
    private static final String HTML_STYLE = "<style>img{display: inline;height: auto;max-width: 100%;}</style>";
    private Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        checkSupportAndroidVersion();

        manager = new FoodManager(this);
        //get data
        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra(SearchResultActivity.DATA_EXCHANGE_OBJECT);
        FoodDetailAsyncLoader loader = new FoodDetailAsyncLoader(this, FoodDetailActivity.this);
        loader.execute(String.valueOf(food.getFoodId()));

        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //load view
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        TextView tvtitle = (TextView) findViewById(R.id.food_detail_title_tv);
        tvtitle.setText(food.getFoodName());
        tvtitle.setSelected(true);
        ImageView cover = (ImageView) findViewById(R.id.food_detail_cover_iv);
        Picasso.with(this).load(food.getAvatarLink()).placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(cover);


        //set bookmark
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (checkBookmarked(food)) {
            fab.setTag(R.drawable.ic_star_yellow);
            fab.setImageResource(R.drawable.ic_star_yellow);
        } else fab.setTag(R.drawable.ic_star);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fabResourceId = (int) fab.getTag();
                if (fabResourceId == R.drawable.ic_star) {
                    fab.setImageResource(R.drawable.ic_star_yellow);
                    fab.setTag(R.drawable.ic_star_yellow);
                    manager.insert(food);
                    Snackbar.make(view, "Bạn đã lưu vào yêu thích", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    fab.setImageResource(R.drawable.ic_star);
                    fab.setTag(R.drawable.ic_star);
                    manager.deleteById(food.getFoodId());
                    Snackbar.make(view, "Bạn đã dừng lưu vào yêu thích", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private boolean checkBookmarked(Food f) {
        Food temp = manager.getById(f.getFoodId());

        return (temp != null) ? true : false;
    }

    private void checkSupportAndroidVersion() {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onTaskCompleted(Object list) {
        foodDetail = (FoodDetail) list;
        WebView wvMaterial = (WebView) findViewById(R.id.food_detail_material_wv);
        wvMaterial.loadDataWithBaseURL(null, HTML_STYLE + "<h2>Nguyên liệu</h2>" + foodDetail.getMaterialDetail(), "text/html", "UTF-8", null);

        WebView wvTuitorial = (WebView) findViewById(R.id.food_detail_tuitorial_wv);
        wvTuitorial.loadDataWithBaseURL(null, HTML_STYLE + "<h2>Hướng dẫn nấu</h2>" + foodDetail.getTutorial(), "text/html", "UTF-8", null);

        TextView tvSource = (TextView) findViewById(R.id.food_detail_source_tv);
        tvSource.setText("Nguồn: " + foodDetail.getSource());

        //set data to add to database local
        food.setMaterialDetail(foodDetail.getMaterialDetail());
        food.setTutorial(foodDetail.getTutorial());
        food.setSource(foodDetail.getSource());

    }

}
