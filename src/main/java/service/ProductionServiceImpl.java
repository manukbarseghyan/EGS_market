package service;

import dao.impl.ProductDaoImpl;
import entity.Product;
import exception.BadRequestException;
import exception.NotFoundException;
import service.services.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductionServiceImpl implements ProductService {

    private ProductDaoImpl productDao;

    public ProductionServiceImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getById(long id) throws NotFoundException , BadRequestException , SQLException {

        if (id <= 0) {
            throw new BadRequestException("Invalid Id ! ");
        }
        Product product = productDao.getById(id);

        if (product == null){
            throw new NotFoundException(" Product not found ! ");
        }
         return product ;



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
