package dao.impl;

import connector.MySqlConnection;
import dao.UserDao;
import entity.User;
import enumaration.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private MySqlConnection getConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public User getById(long id) {

        String sql = "select * from users where id = ?";
        User user = new User();

        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));

                byte[] decodedPass = Base64.getDecoder().decode(resultSet.getString("password"));
                String password = new String(decodedPass);
                user.setPassword(password);
                user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("User not found");
        }
        return null;
    }

    public List<User> getAll() {

        String sql = "select * from users";

        User user = new User();

        List<User> users = new ArrayList<>();

        try (Connection connection = MySqlConnection.getConnection()) {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery(sql);
            while (resultSet.next()) {

                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                byte[] decodedPass = Base64.getDecoder().decode(resultSet.getString("password"));
                String password = new String(decodedPass);
                user.setPassword(password);
                user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
                users.add(user);

            }
        } catch (SQLException e) {
            System.out.println("Users not found");
        }

        return null;
    }

    public boolean save(User user) {

        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection
                    .prepareStatement("insert into  users values (default, ?, ?, ?, ? , ?)");
            // Parameters start with 1
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
            preparedStatement.setInt(5, user.getRole().getId());
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("User not saved");
        }
        return false;
    }

    public boolean update(User user) {

        String sql = "UPDATE users SET first_name=?,last_name=?," +
                "email=?,password=?,role=? WHERE id=?";

        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection
                    .prepareStatement(sql);
            // Parameters start with 1
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
            preparedStatement.setInt(5, user.getRole().getId());
            preparedStatement.setLong(6, user.getId());
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("User not update");
        }
        return false;
    }

    public boolean delete(long id){

        final String sql = "DELETE FROM passengers  WHERE id=?";

        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection
                    .prepareStatement(sql);
            preparedStatement.setLong(1, id);

            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("User not delete");
        }
        return false;
    }
}

