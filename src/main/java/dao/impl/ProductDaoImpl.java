package dao.impl;

import connector.MySqlConnection;
import dao.ProductDao;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public Product getById(long id) {

        String sql = "select * from products where id = ?";

        Product product = new Product();


        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBarcode(resultSet.getString("code"));
                return product;
            }

        } catch (SQLException e) {
            System.out.println("Product by id: +"+ id + " not found");
        }
        return null;
    }

    public List<Product> getAll() {

        String sql = "select * from products";

        Product product = new Product();
        List<Product> products = new ArrayList<>();

        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setBarcode(resultSet.getString("barcode"));
                products.add(product);

            }
        } catch (SQLException e) {
            System.out.println("Products not found");
        }
        return products;
    }

    public boolean save(Product product) {

        String sql = "insert into products values (default, ?, ?, ?, ?)";
        try (Connection connection = MySqlConnection.getConnection()) {

            preparedStatement = connection
                    .prepareStatement(sql);

            // Parameters start with 1
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCount());
            preparedStatement.setString(4, product.getBarcode());
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("Product not save");
        }
        return false;
    }

    public boolean update(Product product) {

        final String sql = "UPDATE products SET name=?, price=?, count=?, barcode=? WHERE id=?";
        try (Connection connection = MySqlConnection.getConnection()) {
            preparedStatement = connection
                    .prepareStatement(sql);

            // Parameters start with 1
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCount());
            preparedStatement.setString(4, product.getBarcode());
            preparedStatement.setLong(5, product.getId());

            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("Product not update");
        }
        return false;


    }

    public boolean delete(long id){

        final String sql = "DELETE FROM products  WHERE id=?";

        try (Connection connection = MySqlConnection.getConnection()) {

        preparedStatement = connection
                .prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            System.out.println("Product not delete");
        }
        return false;

    }
}
