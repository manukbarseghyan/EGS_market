package service.impl;

import dao.ProductDao;
import dao.TransactionDao;
import dao.impl.ProductDaoImpl;
import dao.impl.TransactionDaoImpl;
import entity.Product;
import entity.Transaction;
import enumaration.TransactionTypes;
import service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {


    @Override
    public Transaction getById(long id) {
        TransactionDao transactionDao = new TransactionDaoImpl();
        Transaction transaction = transactionDao.getById(id);
        return transaction;
    }

    @Override
    public List<Transaction> getAll() {
        TransactionDao transactionDao = new TransactionDaoImpl();
        List<Transaction> transactionList = transactionDao.getAll();
        return transactionList;
    }

    @Override
    public boolean save(Transaction transaction) {
        TransactionDao transactionDao = new TransactionDaoImpl();
        ProductDao productDao = new ProductDaoImpl();

        if (transaction.getTypes() == TransactionTypes.ADD) {

            Product product = productDao.getById(transaction.getProductId());

            product.setCount(product.getCount() + transaction.getCount());

            productDao.update(product);

            transactionDao.save(transaction);

        } else if (transaction.getTypes() == TransactionTypes.SALE) {

            Product product = productDao.getById(transaction.getProductId());

            if (product.getCount() >= transaction.getCount()) {
                product.setCount(product.getCount() - transaction.getCount());
                productDao.update(product);
                transactionDao.save(transaction);
                return true;
            } else {
                System.out.println("product not found, Transaction dont save");
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean update(Transaction transaction) {
        return true;
    }

    @Override
    public boolean delete(long id) {
        return true;

    }
}
