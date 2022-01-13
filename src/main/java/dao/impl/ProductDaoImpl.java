package dao.impl;

import connector.MySqlConnection;
import dao.ProductDao;
import entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private MySqlConnection getConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Product getById(long id) throws SQLException {
        String sql = "select * from products where id = ?";

        Product product = new Product();

        Connection connection = MySqlConnection.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setBarcode(resultSet.getString("code"));

            return product;
        } else return null;

    }

    public List<Product> getAll() throws SQLException {

        String sql = "select * from products";

        Product product = new Product();
        List<Product> products = new ArrayList<Product>();

        Connection connection = MySqlConnection.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setBarcode(resultSet.getString("barcode"));
            products.add(product);

        }
        return products;
    }

    public void save(Product product) throws SQLException {

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("insert into products values (default, ?, ?, ?, ?)");

        // Parameters start with 1
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getCount());
        preparedStatement.setString(4, product.getBarcode());


        preparedStatement.executeUpdate();
    }

    public void update(Product product) throws SQLException {

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement("UPDATE products SET name=?, price=?, count=?, barcode=? WHERE id=?");

        // Parameters start with 1
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getCount());
        preparedStatement.setString(4, product.getBarcode());
        preparedStatement.setLong(5, product.getId());

        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws SQLException {
        final String sql = "DELETE FROM products  WHERE id=?";

        statement = getConnection.getConnection().createStatement();

        preparedStatement = getConnection.getConnection()
                .prepareStatement(sql);
        preparedStatement.setLong(1,id);

        preparedStatement.executeUpdate();

    }
}
