package vn.fpt.se0866.data;

import android.content.Context;
import android.content.Intent;

import vn.fpt.se0866.common.data.DataDao;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 12/2/2015.
 */
public class FoodDao extends DataDao<Food, Intent> {
    public FoodDao(Context context) {
        super(context, Food.class);
    }
}
