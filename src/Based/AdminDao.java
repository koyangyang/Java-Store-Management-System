package Based;

import imp.Good;

import java.sql.ResultSet;
import java.util.List;

public interface AdminDao {
    public boolean login(String id,String pwd) throws Exception;
    public List<Good> selectgoods() throws Exception;
    public int insertgood(Good good) throws Exception;
    public int updategood(Good good) throws Exception;
    public Good selectgood(String id)throws Exception;
    public ResultSet selectbianhao(int id)throws Exception;
}
