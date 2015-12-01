package vn.fpt.se0866.common.restclient;

/**
 * Created by DatHT on 11/28/2015.
 */
public class JsonParserException extends RuntimeException {

    public JsonParserException(String message, Throwable e) {
        super(message, e);
    }

    public JsonParserException(String messsage) {
        super(messsage);
    }
}
