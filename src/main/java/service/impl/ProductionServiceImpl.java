package service.impl;

import dao.ProductDao;
import entity.Product;
import exception.BadRequestException;
import exception.NotFoundException;
import service.ProductService;

import java.util.List;

public class ProductionServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductionServiceImpl(ProductDao productDao) {

        this.productDao = productDao;
    }

    @Override
    public Product getById(long id) {

        if (id <= 0) {
            try {
                throw new BadRequestException("Invalid Id ! ");
            } catch (BadRequestException e) {
                e.printStackTrace();
            }
        }
        Product product = productDao.getById(id);

        if (product == null) {
            try {
                throw new NotFoundException(" Product not found ! ");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return product;


    }

    @Override
    public List<Product> getAll() {
        if (productDao.getAll()!=null)
        return productDao.getAll();
        else try {
            throw new NotFoundException("Products not found");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    return null;}

    @Override
    public boolean save(Product product) {

        return productDao.save(product);

    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);

    }

    @Override
    public boolean delete(long id) {
        return productDao.delete(id);

    }
}
