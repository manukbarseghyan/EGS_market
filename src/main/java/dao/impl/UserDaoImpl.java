package dao.impl;

import connector.MySqlConnection;
import dao.UserDao;
import entity.User;
import enumaration.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private MySqlConnection getConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public User getById(long id) throws SQLException {

        String sql = "select * from users where id = ?";

        User user = new User();

        Connection connection = MySqlConnection.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(Role.valueOf(resultSet.getString("role").toUpperCase()));
            return user;
        } else return null;

    }

    public List<User> getAll() throws SQLException {

        String sql = "select * from users";

        User user = new User();

        List<User> users = new ArrayList<User>();

        statement = getConnection.getConnection().createStatement();

        resultSet = statement
                .executeQuery(sql);

        while (resultSet.next()) {

            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(Role.getById(resultSet.getInt("role")));
            users.add(user);

        }

        return users;
    }

    public void save(User user) throws SQLException {


        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("insert into  users values (default, ?, ?, ?, ? , ?)");

        // Parameters start with 1
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setInt(5, user.getRole().getId());
        preparedStatement.executeUpdate();

    }

    public void update(User user) throws SQLException {

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("UPDATE users SET first_name=?,last_name=?," +
                        "email=?,password=?,role=? WHERE id=?");

        // Parameters start with 1
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setInt(5, user.getRole().getId());
        preparedStatement.setLong(6, user.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws SQLException {

        final String sql = "DELETE FROM passengers  WHERE id=?";

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement(sql);
        preparedStatement.setLong(1,id);

        preparedStatement.executeUpdate();

    }
}
