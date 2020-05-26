package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MakeUserDAO {
    // データベース接続に使用する情報
        final String jdbcId = "root";
        final String jdbcPass = "admin";
        final String jdbcUrl = "jdbc:mysql://localhost:8080/GuruSibu?serverTimezone=UTC";


    public  MakeUserDAO(UserBeans ub) {

        try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

            String sql = "INSERT INTO account (id, name, password, email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setInt(1, ub.getId());
            ps.setString(2, ub.getName());
            ps.setString(3, ub.getPassword());
            ps.setString(4, ub.getEmail());


            int r = ps.executeUpdate();

            if(r != 0) {
                System.out.println("ユーザーを新規登録しました");
            } else {
                System.out.println("ユーザーの新規登録に失敗しました");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}