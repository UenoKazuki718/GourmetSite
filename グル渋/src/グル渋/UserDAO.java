package グル渋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // データベース接続に使用する情報
    final String jdbcId = "root";
    final String jdbcPass = "admin";
    final String jdbcUrl = "jdbc:mysql://localhost:8080/GuruSibu?serverTimezone=UTC";

    // ログインアカウントを探す
    public UserBeans findAccount(UserBeans ub) {

        // 戻り値の用意
        UserBeans returnUb = new UserBeans();

        // データベースへ接続
        try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

            String sql = "SELECT id, password, name, mail FROM user WHERE mail = ? AND password = ?";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, ub.getEmail());
            ps.setString(2, ub.getPassword());

            ResultSet rs = ps.executeQuery();


            if (rs.next()) {
                // 見つかったアカウント情報を戻り値にセット
                returnUb.setId(rs.getInt("id"));
                returnUb.setName(rs.getString("name"));
                returnUb.setPassword(rs.getString("password"));
                returnUb.setEmail(rs.getString("email"));

            } else {
                // アカウントがなければnullを返す
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return returnUb;
    }
}