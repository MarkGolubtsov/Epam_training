package dao.mysql;

import dao.OrderDao;
import domain.*;
import exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseMysql<Order> implements OrderDao {
    private static final String DELETE_BY_ID="DELETE FROM `order` WHERE `id` = ?";

    private  static final String CREATE="INSERT INTO `order` (`id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price`) VALUES (null, ?,?,?,?,?)";

    private static final String UPDATE="UPDATE `order` SET  `user_id`=?, `type_pay`=?, `date_ord`=?, `delivery_type`=? `total_price`=? WHERE `id` = ?";

    private static final String  READ_ALL="SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` ORDER BY `date_ord`";
    private static final String READ_BY_DELIVERY_TYPE="SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `delivery_type`=? ORDER BY `date_ord`";

    private static final String READ_BY_ID="SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `id`=?` ORDER BY `date_ord`";
    private static final String READ_BY_USER_ID = "SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `user_id`=?` ORDER BY `date_ord`";
    private static final String DELETE_BY_USER_ID="DELETE FROM `order` WHERE `user_id` = ?";

    private static final String READ_BY_TYPE_PAY="SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `type_pay`=? ORDER BY `date_ord`";

    @Override
    public Order readById(int id) throws DBException {
        return  readByInt(connection,READ_BY_ID,new int[]{id}).get(0);
    }

    @Override
    public void deleteByUserId(int user_id) throws DBException {
        deleteByInt(DELETE_BY_USER_ID, new int[]{user_id}, connection);
    }

    @Override
    public List<Order> readByUserId(int user_id) throws DBException {
        return  readByInt(connection,READ_BY_USER_ID,new int[]{user_id});
    }

    @Override
    public List<Order> readByDeliveryType(TypeDelivery delivery_type) throws DBException {
        return readByString(READ_BY_DELIVERY_TYPE,delivery_type.toString(),connection);
    }

    @Override
    public List<Order> readByPayType(TypePay pay_type) throws DBException {
        return  readByString(READ_BY_TYPE_PAY,pay_type.toString(),connection);
    }

    @Override
    public void create(Order entity) throws DBException {
       defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(Order entity) throws DBException {
        deleteByInt(DELETE_BY_ID, new int[]{entity.getId()}, connection);
    }

    @Override
    public void update(Order entity) throws DBException {
    updateDefault(UPDATE,connection,entity);
    }

    @Override
    public List<Order> read() throws DBException {
        return  defaultRead(READ_ALL,connection);
    }

    @Override
    public void setFieldStatement(PreparedStatement statement, Order entity) throws SQLException {
        statement.setInt(1,entity.getUser().getId());
        statement.setString(2, entity.getType_pay().toString());
        statement.setDate(3, entity.getDate());
        statement.setString(4, entity.getDelivery().toString());
        statement.setBigDecimal(5,entity.getTotal_price());
    }

    @Override
    public Order fillFieldsObject(ResultSet resultSet) throws SQLException {
        Order obj= new Order();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    public void setParam(Order product, ResultSet resultSet) throws SQLException {
        product.setId(resultSet.getInt("id"));

        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        product.setUser(user);
        product.setType_pay(TypePay.valueOf(resultSet.getString("type_pay")));
        product.setDate(resultSet.getDate("date_ord"));
        product.setDelivery(TypeDelivery.valueOf(resultSet.getString("delivery_type")));
        product.setTotal_price(resultSet.getBigDecimal("total_price"));
    }

    @Override
    public void setPrimary(PreparedStatement statement, Order entity) throws SQLException {
        statement.setInt(6,entity.getId());
    }

    public List<Order> fillList(ResultSet resultSet) throws SQLException, SQLException {
        List<Order> orders =new ArrayList<>();
        while(resultSet.next()) {
            orders.add(fillFieldsObject(resultSet));
        }
        return orders;
    }
}
