package vn.fpt.se0866.factory;

import android.content.Context;

import java.util.List;

import vn.fpt.se0866.common.restclient.RequestMethod;
import vn.fpt.se0866.model.Food;
import vn.fpt.se0866.model.FoodDetail;

/**
 * Created by DatHT on 11/28/2015.
 */
public class FoodFactory extends AbstractFactory {

    public FoodFactory(Context context) {
        super(context, "/iCookAPI");
    }


//
//    public List<Food> getFoods(String keys, String start, String limit, String token) throws Exception {
//        restClient.addRoute("search").addRoute(keys)
//                .addRoute(start)
//                .addRoute(limit)
//        .addParam("access_token", token);
//        restClient.execute(RequestMethod.GET);
//        return responseList(restClient, Food.class);
//    }

    public List<Food> getFoods(String keys, String start, String limit, String token) throws Exception {
        restClient.addRoute("search")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", AuthorizationFactory.AUTH_TYPE + " " + token)
                .addRawJson("materials", keys)
                .addRawJson("start", start)
                .addRawJson("limit", limit);
        restClient.execute(RequestMethod.POST);
        return responseList(restClient, Food.class);
    }

    public FoodDetail getFoodById(String id, String token) throws Exception {
        restClient.addRoute("search")
                .addRoute(id)
                .addParam("access_token", token);
        restClient.execute(RequestMethod.GET);
        return response(restClient, FoodDetail.class);
    }
}
