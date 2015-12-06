package vn.fpt.se0866.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import vn.fpt.se0866.manager.FoodManager;
import vn.fpt.se0866.model.Food;

public class FoodDetailActivity extends AppCompatActivity {
    private FoodManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        manager = new FoodManager(this);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //get data
        Intent intent = getIntent();
        final Food food = (Food) intent.getSerializableExtra(SearchResultActivity.DATA_EXCHANGE_OBJECT);

        //load view
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(food.getFoodName());
        TextView tvDetail = (TextView) findViewById(R.id.food_detail_tv);
        tvDetail.setText(food.getDescription());
        ImageView cover = (ImageView) findViewById(R.id.food_detail_cover_iv);
        Picasso.with(this).load(food.getAvatarLink()).placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(cover);

        //set bookmark
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (checkBookmarked(food)){
            fab.setTag(R.drawable.ic_star_yellow);
            fab.setImageResource(R.drawable.ic_star_yellow);
        }
        else fab.setTag(R.drawable.ic_star);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fabResourceId = (int) fab.getTag();
                if (fabResourceId == R.drawable.ic_star) {
                    fab.setImageResource(R.drawable.ic_star_yellow);
                    fab.setTag(R.drawable.ic_star_yellow);
                    manager.insert(food);
                }else {
                    fab.setImageResource(R.drawable.ic_star);
                    fab.setTag(R.drawable.ic_star);
                    manager.deleteById(food.getFoodId());
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
        switch (item.getItemId()){
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
}
