package vn.fpt.se0866.activity;

import android.test.AndroidTestCase;
import android.util.Log;

import vn.fpt.se0866.common.restclient.RequestMethod;
import vn.fpt.se0866.common.restclient.RestClient;
import vn.fpt.se0866.factory.FoodFactory;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/27/2015.
 */

public class APITest extends AndroidTestCase {
    FoodFactory factory;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        factory = new FoodFactory(getContext());
    }


//    public void getAPI() {
//        try {
//            Food food = factory.getFoodById(String.valueOf(3411));
//            assertNotNull(food);
//            assertEquals(3411, food.getFoodId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
