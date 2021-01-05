package Based;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {


    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/market";
    private final String USERNAME = "root";
    private final String PASSWORD = "123456";


	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "select * from administrator where adminPwd = ?";
		BaseDao bd = new BaseDao();
		Connection conn = bd.getConn();
		ResultSet rs = bd.executeQuery(conn, sql, new String[] {"111111"});


		System.out.println(rs.next());

		bd.closeAll(conn, ps, rs);
	}*/

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //1. ��ȡ����
    public Connection getConn() throws ClassNotFoundException, SQLException {
        //��������
        Class.forName(DRIVER);
        //2.��ȡ����
        conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        return conn;
    }

    //2. ��ѯȫ��
    public ResultSet executeQuery(Connection conn, String sql, Object...param) throws SQLException{
        ps = conn.prepareStatement(sql);
        rs =  ps.executeQuery();

        return rs;

    }
    //3.����id��ѯ��Ʒ
    public ResultSet executeQuerygood(Connection conn, String sql, Object...param) throws SQLException{
        ps = conn.prepareStatement(sql);

        if(param != null){
            //��ռλ�����и�ֵ
            for(int i=0; i<param.length; i++){
                ps.setObject((i+1), param[i]);
            }
        }

        rs =  ps.executeQuery();

        return rs;

    }

    //��ɾ�Ĳ���
    public int executeUpdate(Connection conn, String sql, Object...param) throws SQLException{
        ps = conn.prepareStatement(sql);

        if(param != null){
            //��ռλ�����и�ֵ
            for(int i=0; i<param.length; i++){
                ps.setObject((i+1), param[i]);
            }
        }

        int num =  ps.executeUpdate();

        closeAll(conn, ps, null);

        return num;

    }

    //4. �ر���Դ
    public void closeAll(Connection conn,PreparedStatement ps, ResultSet rs ){


        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
