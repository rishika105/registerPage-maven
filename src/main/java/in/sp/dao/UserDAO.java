package in.sp.dao;

import in.sp.model.UserModel;
import java.sql.SQLException;

public interface UserDAO {
    UserModel getUserByEmailAndPassword(String email, String password) throws SQLException;
    boolean registerUser(UserModel user) throws SQLException;
}
