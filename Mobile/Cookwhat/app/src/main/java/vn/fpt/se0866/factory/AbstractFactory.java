package vn.fpt.se0866.factory;

import android.app.Application;
import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import vn.fpt.se0866.activity.R;
import vn.fpt.se0866.common.core.JsonParser;
import vn.fpt.se0866.common.restclient.RestClient;

/**
 * Created by DatHT on 11/28/2015.
 */
public class AbstractFactory {
    protected static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    protected static final JsonParser PARSER = new JsonParser(JSON_MAPPER);
    protected RestClient restClient;
    protected Application context;

    public AbstractFactory(Context context) {
        this(context, "");
    }

    public AbstractFactory(Context context, String subpath) {
        String webApi = context.getString(R.string.api_url) + subpath;
        restClient = new RestClient(webApi);
    }

    protected <T> T response(RestClient rest, Class<T> clazz) throws IOException{
        if (rest.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return PARSER.toObject(rest.getResponse(), clazz);
        }
        return null;
    }

    protected <T> List<T> responseList(RestClient rest, Class<T> clazz) throws IOException {
        if (rest.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return PARSER.toList(rest.getResponse(), clazz);
        }
        return null;
    }
}
