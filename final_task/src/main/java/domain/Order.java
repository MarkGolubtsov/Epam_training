package domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Order extends Entity {


    private  TypePay type_pay;
    private  Date date;
    private BigDecimal total_price;

    private  User user;
    private  TypeDelivery delivery;

    public TypeDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(TypeDelivery delivery) {
        this.delivery = delivery;
    }

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

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
