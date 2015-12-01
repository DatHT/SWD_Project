package vn.fpt.se0866.factory;

import android.content.Context;

import java.util.List;

import vn.fpt.se0866.common.restclient.RequestMethod;
import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/28/2015.
 */
public class FoodFactory extends AbstractFactory {

    public FoodFactory(Context context) {
        super(context, "/iCookAPI");
    }



    public List<Food> getFoods(String keys, String start, String limit) throws Exception {
        restClient.addRoute("search").addRoute(keys).addRoute(start).addRoute(limit);
        restClient.execute(RequestMethod.GET);
        return responseList(restClient, Food.class);
    }

    public Food getFoodById(String id) throws Exception {
        restClient.addRoute("food").addRoute(id);
        restClient.execute(RequestMethod.GET);
        return response(restClient, Food.class);
    }
}
