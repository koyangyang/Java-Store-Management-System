package Based;

import imp.Good;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminerDao extends Basedao implements AdminDao{
    @Override
    public boolean login(String id,String pwd) throws Exception{
        String sql="select * from users";
        Connection conn=super.getConn();
        ResultSet rs=super.executeQuery(conn,sql);
        while (rs.next()) {
            if (rs.getString(1).equals(id) && rs.getString(2).equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Good> selectgoods() throws Exception{
        List<Good> list=new ArrayList<Good>();
        String sql="select * from goods";
        Connection conn=super.getConn();
        ResultSet rs=super.executeQuery(conn,sql);
        while (rs.next()){
            Good new_good=new Good();
            new_good.setId(rs.getString(1));
            new_good.setName(rs.getString(2));
            new_good.setPrice(rs.getDouble(3));
            new_good.setNum(rs.getInt(4));
            list.add(new_good);
        }
        return list;
    }

    @Override
    public int insertgood(Good good) throws Exception{
    	Connection conn=super.getConn();
    	String sql="insert into goods values(?,?,?,?)";
        return super.executeUpdate(conn, sql, new Object[] {good.getId(),good.getName(),good.getPrice(),good.getNum()});
    }
    
    
    @Override
    public int updategood(Good good) throws Exception {
    	// TODO Auto-generated method stub
    	Connection conn=super.getConn();
    	String sql="update goods set num=?,name=?,price=? where id=?";
        return super.executeUpdate(conn, sql, new Object[] {good.getNum(),good.getName(),good.getPrice(),good.getId()});
    }
    @Override
    public Good selectgood(String id) throws Exception {
    	// TODO Auto-generated method stub
         String sql="select * from goods where id=?";
         Connection conn=super.getConn();
         ResultSet rs=super.executeQuerygood(conn,sql,new Object[] {id});
         Good new_good=new Good();
         while (rs.next()){             
             new_good.setId(rs.getString(1));
             new_good.setName(rs.getString(2));
             new_good.setPrice(rs.getDouble(3));
             new_good.setNum(rs.getInt(4));
         }
    	return new_good;
    }
    @Override
    public ResultSet selectbianhao(int id) throws Exception {
    	// TODO Auto-generated method stub
    	Connection conn=super.getConn();
    	String sql="select content from bianhao where bh=?";
        return super.executeQuerygood(conn, sql,new Object[] {id});
    }
}