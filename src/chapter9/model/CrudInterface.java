package chapter9.model;

import java.util.ArrayList;

public interface CrudInterface<T> {
    boolean insertData (T t);
    ArrayList<T> selectData ();
    
    boolean deleteData (T t);
    
    boolean updateData (T t);
}
