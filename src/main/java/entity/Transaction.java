package entity;

import enumaration.TransactionTypes;
import sun.util.resources.LocaleData;

public class Transaction {

    private long id;

    private User user;

    private Product product;

    private TransactionTypes types;

    private int count;

    private LocaleData data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public LocaleData getData() {
        return data;
    }

    public void setData(LocaleData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", types=" + types +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
