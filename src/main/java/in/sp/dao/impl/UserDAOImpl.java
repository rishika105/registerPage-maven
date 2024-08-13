package in.sp.dao.impl;

import in.sp.dao.UserDAO;
import in.sp.model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/registerLogin_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "rishika12345##";

    public UserDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel getUserByEmailAndPassword(String email, String password) throws SQLException {
        UserModel user = null;
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM register WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setCity(rs.getString("city"));
            }
        }
        return user;
    }

    @Override
    public boolean registerUser(UserModel user) throws SQLException {
        boolean status = false;
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO register (name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getCity());
            int i = ps.executeUpdate();
            if (i > 0) {
                status = true;
            }
        }
        return status;
    }
}
