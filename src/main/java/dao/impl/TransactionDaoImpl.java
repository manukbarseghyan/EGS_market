package dao.impl;

import connector.MySqlConnection;
import dao.TransactionDao;
import entity.Product;
import entity.Transaction;
import entity.User;
import enumaration.TransactionTypes;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    private MySqlConnection getConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private User user = new User();
    private Product product = new Product();


    public Transaction getById(long id) throws SQLException {

        String sql = "select * from transactions where id = ?";

        Transaction transaction = new Transaction();


        Connection connection = MySqlConnection.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        resultSet = preparedStatement.executeQuery();
        connection.commit();

        if (resultSet.next()) {

            transaction.setId(resultSet.getLong("id"));
            transaction.setUserId(resultSet.getLong("user_id"));
            transaction.setProductId(resultSet.getLong("product_id"));
            String transactionType = resultSet.getString("transaction_type");
            TransactionTypes type;

            if (transactionType.equals("id: 1, type: add")) {
                type = TransactionTypes.ADD;
            } else if (transactionType.equals("id: 2, type: sale")) {
                type = TransactionTypes.SALE;
            } else if (transactionType.equals("id: 3, type: update")) {
                type = TransactionTypes.UPDATE;
            } else {
                type = TransactionTypes.DELETE;
            }
            transaction.setTypes(type);
            transaction.setCount(resultSet.getInt("count"));
            transaction.setLocalDate(resultSet.getTimestamp("create_time"));

            return transaction;
        } else return null;
    }


    public List<Transaction> getAll() throws SQLException {

        String sql = "select * from transactions";

        Transaction transaction = new Transaction();
        List<Transaction> transactions = new ArrayList<>();
        Connection connection = MySqlConnection.getConnection();
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
            return transactions;
        }

        return transactions;
    }

    public void save(Transaction transaction) throws SQLException {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("insert into transactions values (default, ?, ?, ?, ?, ?)");

        // Parameters start with 1
        preparedStatement.setLong(1, transaction.getUserId());
        preparedStatement.setLong(2, transaction.getProductId());
        preparedStatement.setInt(3, transaction.getTypes().getId());
        preparedStatement.setInt(4, transaction.getCount());
        preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.executeUpdate();
    }

    public void update(Transaction transaction) throws SQLException {

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("UPDATE transactions SET user_id=?, product_id=?, transaction_type=?," +
                        " count=?, create_time=? WHERE id=?");

        // Parameters start with 1
        preparedStatement.setLong(1, transaction.getUserId());
        preparedStatement.setLong(2, transaction.getProductId());
        preparedStatement.setObject(3, transaction.getTypes());
        preparedStatement.setInt(4, transaction.getCount());
        preparedStatement.setTimestamp(5, transaction.getLocalDate());
        preparedStatement.setLong(6, transaction.getId());
        preparedStatement.executeUpdate();

    }

    public void delete(long id) throws SQLException {

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("delete transactions WHERE id=?");
        preparedStatement.executeUpdate();

    }
}
