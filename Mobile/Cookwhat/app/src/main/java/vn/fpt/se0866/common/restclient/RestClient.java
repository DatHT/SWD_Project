package vn.fpt.se0866.common.restclient;

import android.net.Uri;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by DatHT on 11/24/2015.
 */
public class RestClient {
    ArrayList<NameValuePair> params;
    ArrayList<NameValuePair> headers;
    private JSONObject object;
    private String jsonMessage = "";
    private String url;
    private int responseCode;
    private String message;

    private String response;

    public String getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public RestClient(String url) {
        this.url = url;
        params = new ArrayList<NameValuePair>();
        headers = new ArrayList<NameValuePair>();
        object = new JSONObject();
    }

    public RestClient addRoute(String route) {
        this.url += "/" + Uri.encode(route);
        return this;
    }

    public RestClient addRawJson(String key, String value) {
        try {
            object.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RestClient addParam(String name, String value) {
        params.add(new BasicNameValuePair(name, value));
        return this;
    }

    public RestClient addHeader(String name, String value) {
        headers.add(new BasicNameValuePair(name, value));
        return this;
    }

    public void execute(RequestMethod method) throws Exception {
        switch (method) {
            case GET:
            {
                //add params
                String combinedParams = "";
                if (!params.isEmpty()) {
                    combinedParams += "?";
                    for (NameValuePair p : params) {
                        String paramString = p.getName() + "=" + URLEncoder.encode(p.getValue(), "UTF-8");
                        if (combinedParams.length() > 1) {
                            combinedParams += "&" + paramString;
                        }else combinedParams += paramString;
                    }
                }
                HttpGet request = new HttpGet(url + combinedParams);

                //add header
                for (NameValuePair p : headers) {
                    request.addHeader(p.getName(), p.getValue());
                }
                executeRequest(request, url);
            }
            case POST:
            {
                HttpPost request = new HttpPost(url);
                //add header
                request.setHeader("Content-Type", "application/json; charset=UTF-8");
                for (NameValuePair p : headers) {
                    request.addHeader(p.getName(), p.getValue());
                }
                if (!params.isEmpty()) {
                    request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                }

                if (object != null) {
                    jsonMessage = object.toString();
                    request.setEntity(new StringEntity(jsonMessage, HTTP.UTF_8));
                }
                executeRequest(request, url);
                break;
            }
        }
    }

    private void executeRequest(HttpUriRequest request, String url) {
        HttpClient client = new DefaultHttpClient();
        HttpResponse httpResponse;

        try {
            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                response = convertStreamToString(inputStream);
                inputStream.close();
            }
        } catch (ClientProtocolException e) {
            client.getConnectionManager().shutdown();
        } catch (IOException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
    }

    private static String convertStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private String encodeUrl(String url) throws MalformedURLException, URISyntaxException {
        URL newUrl = new URL(url);
        URI uri = new URI(newUrl.getProtocol(), newUrl.getUserInfo(), newUrl.getHost(), newUrl.getPort(),
                newUrl.getPath(), newUrl.getQuery(), newUrl.getRef());

        return uri.toASCIIString();
    }
}
