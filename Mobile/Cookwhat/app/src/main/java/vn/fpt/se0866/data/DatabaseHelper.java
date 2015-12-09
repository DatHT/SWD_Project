package vn.fpt.se0866.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import vn.fpt.se0866.model.Food;

/**
 * Created by DatHT on 11/29/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private final String TAG = getClass().getSimpleName();
    private static final String DATABASE_NAME = "Food.sqlite";
    private static final int DATABASE_VERSION = 2;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Food.class);
        } catch (SQLException e) {
            Log.e(TAG, "can't create table", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Food.class, true);
        } catch (SQLException e) {
            Log.e(TAG, "can't not drop table", e);
        }
    }

    public void clearDatabase() {
        try {
            TableUtils.clearTable(connectionSource, Food.class);
        } catch (SQLException e) {
            Log.e(TAG, "can't clear database", e);
        }
    }
}
