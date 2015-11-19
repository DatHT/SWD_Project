package vn.fpt.se0866.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText etSearch1, etSearch2, etSearch3, etSearch4, etSearch5;
    ImageView btnSearch;
    int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etSearch1 = (EditText) findViewById(R.id.search_1_et);
        etSearch2 = (EditText) findViewById(R.id.search_2_et);
        etSearch3 = (EditText) findViewById(R.id.search_3_et);
        etSearch4 = (EditText) findViewById(R.id.search_4_et);
        etSearch5 = (EditText) findViewById(R.id.search_5_et);
        btnSearch = (ImageView) findViewById(R.id.search_btn);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.search_fab);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    public void searchFood(View view) {
        Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
//        Bundle bndlanimation =
//                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.pull_in_right, R.anim.pull_in_left).toBundle();
        //startActivity(intent, bndlanimation);
        startActivity(intent);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
