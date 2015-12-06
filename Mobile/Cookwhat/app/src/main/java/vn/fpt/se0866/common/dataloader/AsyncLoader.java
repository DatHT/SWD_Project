package vn.fpt.se0866.common.dataloader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import vn.fpt.se0866.common.core.IOnTaskCompleted;
import vn.fpt.se0866.factory.AuthorizationFactory;
import vn.fpt.se0866.factory.FoodFactory;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/28/2015.
 */
public class AsyncLoader extends AsyncTask<String, Integer, List<Food>> {
    private Activity activity;
    private ProgressDialog dialog;
    private FoodFactory factory;
    private AuthorizationFactory authFactory;
    private IOnTaskCompleted listener;

    public AsyncLoader(Activity activity, IOnTaskCompleted listener) {
        super();
        this.activity = activity;
        this.listener = listener;
        factory = new FoodFactory(activity);
        authFactory = new AuthorizationFactory(activity);
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
            String token = authFactory.getAccessToken().getValue();
            return factory.getFoods(keys, start, end, token);
        } catch (Exception e) {
            Log.e(getClass().getName(), "Create Dao fail " + e.getMessage());

        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Food> result) {
        super.onPostExecute(result);
        listener.onTaskCompleted(result);
        dialog.dismiss();

    }
}
