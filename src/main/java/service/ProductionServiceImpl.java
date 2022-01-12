package service;

import dao.ProductDao;
import entity.Product;
import service.services.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductionServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductionServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getById(long id) throws SQLException {
     return productDao.getById(id);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        return productDao.getAll();
    }

    @Override
    public void save(Product product) throws SQLException {
        productDao.save(product);

    }

    @Override
    public void update(Product product) throws SQLException {
        productDao.update(product);

    }

    @Override
    public void delete(long id) throws SQLException {
        productDao.delete(id);

    }
}
