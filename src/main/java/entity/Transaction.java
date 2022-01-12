package entity;

import enumaration.TransactionTypes;

import java.sql.Timestamp;

public class Transaction {

    private long id;

    private long userId;

    private long productId;

    private TransactionTypes types;

    private int count;

    private Timestamp localDate;

    public Transaction() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public TransactionTypes getTypes() {
        return types;
    }

    public void setTypes(TransactionTypes types) {
        this.types = types;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timestamp getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Timestamp localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", types=" + types +
                ", count=" + count +
                ", localDate=" + localDate +
                '}';
    }
}
