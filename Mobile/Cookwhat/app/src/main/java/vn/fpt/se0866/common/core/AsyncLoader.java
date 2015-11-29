package vn.fpt.se0866.common.core;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.util.List;

import vn.fpt.se0866.activity.SearchResultActivity;
import vn.fpt.se0866.factory.FoodFactory;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/28/2015.
 */
public class AsyncLoader extends AsyncTask<String, Integer, List<Food>> {
    private Activity activity;
    private ProgressDialog dialog;
    private FoodFactory factory;

    public AsyncLoader(Activity activity) {
        super();
        this.activity = activity;
        factory = new FoodFactory(activity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(activity);
        dialog.setTitle("Loading");
        dialog.setMessage("Load more...");
        dialog.setIndeterminate(false);
        dialog.show();
    }

    @Override
    protected List<Food> doInBackground(String... params) {
        String keys = params[0];
        String start = params[1];
        String end = params[2];
        try {
            return factory.getFoods(keys, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Food> result) {
        super.onPostExecute(result);
//        int pageCount = ((SearchResultActivity) activity).getPageCount();
//        ((SearchResultActivity) activity).setPageCount(pageCount + 1);
//        ((SearchResultActivity) activity).setFoods(result);
        dialog.dismiss();
    }
}
