package dao.impl;

import connector.MySqlConnection;
import dao.TransactionDao;
import entity.Transaction;
import enumaration.TransactionTypes;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    private MySqlConnection databaseConnection;

    public Transaction getById(long id) {

        String sql = "select * from transactions where id = ?";
        Connection connection = databaseConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getLong("id"));
                transaction.setUserId(resultSet.getLong("user_id"));
                transaction.setProductId(resultSet.getLong("product_id"));
                transaction.setTypes(TransactionTypes.valueOf(resultSet.getString("transaction_type")));
                transaction.setCount(resultSet.getInt("count"));
                transaction.setLocalDate(resultSet.getTimestamp("create_time"));

                return transaction;
            }
        } catch (SQLException e) {
            System.out.println("Transaction by id : +" + id + "not found");
        }
        return null;
    }


    public List<Transaction> getAll() {

        String sql = "select * from transactions";
        List<Transaction> transactions = new ArrayList<>();
        Connection connection = databaseConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = getById(resultSet.getLong("id"));

                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            System.out.println("Transactions not found");
        }
        return null;
    }

    public boolean save(Transaction transaction) {

        String sql = "insert into transactions values (default, ?, ?, ?, ?, ?)";
        Connection connection = databaseConnection.getConnection();

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement(sql);

            // Parameters start with 1
            preparedStatement.setLong(1, transaction.getUserId());
            preparedStatement.setLong(2, transaction.getProductId());
            preparedStatement.setInt(3, transaction.getTypes().getId());
            preparedStatement.setInt(4, transaction.getCount());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("Transaction not save");
        }
        return false;
    }

    public boolean update(Transaction transaction) {
        String sql = "UPDATE transactions SET user_id=?, product_id=?, transaction_type=?," +
                " count=?, create_time=? WHERE id=?";
        Connection connection = databaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(sql);

            // Parameters start with 1
            preparedStatement.setLong(1, transaction.getUserId());
            preparedStatement.setLong(2, transaction.getProductId());
            preparedStatement.setObject(3, transaction.getTypes());
            preparedStatement.setInt(4, transaction.getCount());
            preparedStatement.setTimestamp(5, transaction.getLocalDate());
            preparedStatement.setLong(6, transaction.getId());
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("Transaction not update");
        }
        return false;

    }

    public boolean delete(long id) {

        final String sql = "DELETE FROM transactions  WHERE id=?";
        Connection connection = databaseConnection.getConnection();
        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement(sql);
            preparedStatement.setLong(1, id);

            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("Transaction not delete");
        }
        return false;

    }
}
