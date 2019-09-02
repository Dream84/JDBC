package test;

import java.sql.*;

public class MySQLDemo0 {

    public void test() {
        String sql = "select * from student where name = ?";
        String name0 = "B";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name0);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                System.out.println("ID:"+ id + " Name:" + name + " sex:" + sex + " age:" + age);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn);
            DBUtil.close(pstmt);
            DBUtil.close(rs);
        }
    }
}
