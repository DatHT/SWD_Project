package vn.fpt.se0866.common.data;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import vn.fpt.se0866.data.DatabaseHelper;

/**
 * Created by DatHT on 12/2/2015.
 */
public abstract class DataDao<Model, Id> implements IDataDao<Model, Id> {
    protected Dao<Model, Id> dao;
    protected Class<Model> modelClass;

    public DataDao(Context context, Class<Model> modelClass) {
        this.modelClass = modelClass;

        try {
            dao = OpenHelperManager.getHelper(context, DatabaseHelper.class).getDao(modelClass);
        } catch (SQLException e) {
            Log.e(getClass().getName(), "Create Dao fail " + e.getMessage());
        }
    }

    public Dao<Model, Id> getDao() {
        return dao;
    }

    @Override
    public Model getById(Id id) {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            Log.e(getClass().getName(), "Get by Id failed " + e.getMessage());
            return  null;
        }
    }

    @Override
    public List<Model> getAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            Log.e(getClass().getName(), "Get All failed " + e.getMessage());
            return  null;
        }
    }

    @Override
    public boolean deleteById(Id id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (SQLException e) {
            Log.e(getClass().getName(), "Delete by Id failed " + e.getMessage());
            return  false;
        }
    }

    @Override
    public void insert(Model model) {
        try {
            dao.create(model);
        } catch (SQLException e) {
            Log.e(getClass().getName(), "Insert failed " + e.getMessage());
        }
    }
}
