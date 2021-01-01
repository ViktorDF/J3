package l2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

    }

    static User doAuth(String email, String password) {

        Objects.requireNonNull(email, "Email cannot be null");
        Objects.requireNonNull(password, "Password cannot be null");

        if (email.isBlank())
            throw new IllegalArgumentException("email cannot be empty");
        if (password.isBlank())
            throw new IllegalArgumentException("Password cannot be empty");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:3386/test");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
            
            return null;
        } catch (Exception e) {
            throw  new RuntimeException("SWW", e);
        }
    }
}
