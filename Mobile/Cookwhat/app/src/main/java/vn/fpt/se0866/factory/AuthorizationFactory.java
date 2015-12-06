package vn.fpt.se0866.factory;

import android.content.Context;

import vn.fpt.se0866.common.restclient.RequestMethod;
import vn.fpt.se0866.model.TokenObject;

/**
 * Created by DatHT on 12/6/2015.
 */
public class AuthorizationFactory extends AbstractFactory {
    public static final String AUTH_TYPE = "Bearer";

    public AuthorizationFactory(Context context) {
        super(context, "/iCookAPI/oauth/token?grant_type=password&client_id=mobileapp&client_secret=mobileapp&username=datht&password=datht@cathl");
    }

    public TokenObject getAccessToken() throws Exception  {
        restClient.execute(RequestMethod.GET);
        return response(restClient, TokenObject.class);
    }
}
