package vn.fpt.se0866.common.core;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import vn.fpt.se0866.factory.AuthorizationFactory;
import vn.fpt.se0866.factory.FoodFactory;

/**
 * Created by DatHT on 12/7/2015.
 */
public abstract class BaseAsyncLoader extends AsyncTask<String, Integer, Object> {
    private Activity activity;
    private ProgressDialog dialog;
    protected FoodFactory factory;
    protected AuthorizationFactory authFactory;
    private IOnTaskCompleted listener;

    public BaseAsyncLoader(Activity activity, IOnTaskCompleted listener) {
        super();
        this.activity = activity;
        this.listener = listener;
        authFactory = new AuthorizationFactory(activity);
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
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        listener.onTaskCompleted(result);
        dialog.dismiss();
    }
}
