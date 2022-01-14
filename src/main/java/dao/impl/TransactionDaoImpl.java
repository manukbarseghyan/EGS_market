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

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Transaction getById(long id){

        String sql = "select * from transactions where id = ?";

        Transaction transaction = new Transaction();


        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

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

        Transaction transaction = new Transaction();
        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = MySqlConnection.getConnection()) {

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                transaction.setId(resultSet.getLong("id"));
                transaction.setUserId(resultSet.getLong("user_id"));
                transaction.setProductId(resultSet.getLong("product_id"));
                transaction.setTypes((TransactionTypes) resultSet.getObject("transaction_type"));
                transaction.setCount(resultSet.getInt("count"));
                transaction.setLocalDate(resultSet.getTimestamp("create_time"));

                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException e) {
            System.out.println("Transactions not found");
        }
        return null;
    }

    public boolean save(Transaction transaction) {


        try (Connection connection = MySqlConnection.getConnection()) {

            preparedStatement = connection
                    .prepareStatement("insert into transactions values (default, ?, ?, ?, ?, ?)");

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

        try (Connection connection = MySqlConnection.getConnection()) {

            preparedStatement = connection
                    .prepareStatement("UPDATE transactions SET user_id=?, product_id=?, transaction_type=?," +
                            " count=?, create_time=? WHERE id=?");

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

        try (Connection connection = MySqlConnection.getConnection()) {

            preparedStatement = connection
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
