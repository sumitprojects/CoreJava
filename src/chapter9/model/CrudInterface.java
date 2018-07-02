package chapter9.model;

import java.util.ArrayList;

public interface CrudInterface<T> {
    /**
     * @param t Java Model Bean will be used an a param
     * @return true or false
     */
    boolean insertData (T t);
    
    /**
     * @return true or false
     */
    ArrayList<T> selectData ();
    
    /**
     * @param t Java Model Bean will be used an a param
     * @return true or false
     */
    boolean deleteData (T t);
    
    /**
     * @param t Java Model Bean will be used an a param
     * @return true or false
     */
    boolean updateData (T t);
}
