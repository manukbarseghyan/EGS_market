package service;

import dao.ProductDao;
import dao.TransactionDao;
import dao.impl.ProductDaoImpl;
import dao.impl.TransactionDaoImpl;
import entity.Product;
import entity.Transaction;
import enumaration.TransactionTypes;
import service.services.TransactionService;

import java.sql.SQLException;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction getById(long id) throws SQLException {
        TransactionDao transactionDao = new TransactionDaoImpl();
        Transaction transaction = transactionDao.getById(id);
        return transaction;
    }

    @Override
    public List<Transaction> getAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Transaction transaction) throws SQLException {

        Product product = new Product();

        ProductDao productDao = new ProductDaoImpl();


        if (transaction.getTypes() == TransactionTypes.ADD){

            product = productDao.getById(transaction.getProductId());

            product.setCount(product.getCount()+transaction.getCount());

            productDao.update(product);

            TransactionDao transactionDao = new TransactionDaoImpl();
            transactionDao.save(transaction);
        }else if (transaction.getTypes() == TransactionTypes.SALE){

            product = productDao.getById(transaction.getProductId());

            if (product.getCount()>=transaction.getCount()) {
                product.setCount(product.getCount() - transaction.getCount());
            }else {
                System.out.println("Product caunt ");
            }
            productDao.update(product);

            TransactionDao transactionDao = new TransactionDaoImpl();
            transactionDao.save(transaction);
        }else if (transaction.getTypes() == TransactionTypes.DELETE){

        }

    }

    @Override
    public void update(Transaction transaction) throws SQLException {

    }

    @Override
    public void delete(long id) throws SQLException {

    }
}
