package people;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Based.Basedao;

public class Bianhao {
	Basedao bd=new Basedao();
    public int chilckbh() throws Exception {
    	int bh=0;
    	Connection conn=bd.getConn();
    	String sql="select count(bh) from bianhao";
    	ResultSet rs=bd.executeQuery(conn, sql);
    	while(rs.next()) {
    		bh=rs.getInt(1);
    	}
		return bh+1;
	}
    public String insetbh(int bh,String str) throws ClassNotFoundException, SQLException {
    	Connection conn=bd.getConn();
    	String sql="insert into bianhao values(?,?)";
    	int num=bd.executeUpdate(conn, sql, new Object[]{bh,str});
		if (num!=0) {
			return "订单号为"+bh+"\n欢迎下次光临";
		}
		return "Error";
	}
}
