package domain;

import java.sql.Date;
import java.util.List;

public class Order extends Entity {

    private TypePay type_pay;
    private  Date date;
    private  double total_price;

    private List<ChoseProduct> choseProducts;

    public TypePay getType_pay() {
        return type_pay;
    }

    public void setType_pay(TypePay type_pay) {
        this.type_pay = type_pay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public List<ChoseProduct> getChoseProducts() {
        return choseProducts;
    }

    public void setChoseProducts(List<ChoseProduct> choseProducts) {
        this.choseProducts = choseProducts;
    }
}
