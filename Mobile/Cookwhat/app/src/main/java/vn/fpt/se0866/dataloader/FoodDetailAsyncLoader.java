package vn.fpt.se0866.dataloader;

import android.app.Activity;
import android.util.Log;

import vn.fpt.se0866.common.core.BaseAsyncLoader;
import vn.fpt.se0866.common.core.IOnTaskCompleted;

/**
 * Created by DatHT on 12/6/2015.
 */
public class FoodDetailAsyncLoader extends BaseAsyncLoader {

    public FoodDetailAsyncLoader(Activity activity, IOnTaskCompleted listener) {
        super(activity, listener);
    }

    @Override
    protected Object doInBackground(String... params) {
        try {
            String token = authFactory.getAccessToken().getValue();
            return factory.getFoodById(params[0], token);
        } catch (Exception e) {
            Log.e(getClass().getName(), "API call fail Dao fail " + e.getMessage());
            return null;
        }

    }
}
