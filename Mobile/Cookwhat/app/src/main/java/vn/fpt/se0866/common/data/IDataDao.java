package vn.fpt.se0866.common.data;

import java.util.List;

/**
 * Created by DatHT on 12/2/2015.
 */
public interface IDataDao<Model, Id> {
    Model getById(Id id);
    List<Model> getAll();
    boolean deleteById(Id id);
}
