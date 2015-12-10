package vn.fpt.se0866.dataloader;

import android.app.Activity;
import android.util.Log;

import java.util.List;

import vn.fpt.se0866.common.core.BaseAsyncLoader;
import vn.fpt.se0866.common.core.IOnTaskCompleted;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/28/2015.
 */
public class FoodsAsyncLoader extends BaseAsyncLoader {


    public FoodsAsyncLoader(Activity activity, IOnTaskCompleted listener) {
        super(activity, listener);

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
            Log.e(getClass().getName(), "API call fail " + e.getMessage());

        }
        return null;
    }
}
