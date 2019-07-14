package dao.mysql;

import dao.OrderDao;
import domain.*;
import exception.FitalException;

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
    private static final String READ_BY_DELIVERY_TYPE="SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `delivery_type=?`";

    private static final String READ_BY_ID="SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `id`=?`";
    private static final String READ_BY_USER_ID = "SELECT `id`, `user_id`, `type_pay`, `date_ord`,`delivery_type`,`total_price` FROM `order` WHERE `user_id`=?`";

    @Override
    public Order readById(int id) throws FitalException {
        return  readByInt(connection,READ_BY_ID,new int[]{id}).get(0);
    }

    @Override
    public List<Order> readByUserId(int user_id) throws FitalException {
        return  readByInt(connection,READ_BY_USER_ID,new int[]{user_id});
    }

    @Override
    public List<Order> readByDeliveryType(TypeDelivery delivery_type) throws FitalException {
        return readByString(READ_BY_DELIVERY_TYPE,delivery_type.toString(),connection);
    }

    @Override
    public void create(Order entity) throws FitalException {
       defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(Order entity) throws FitalException {
        deleteByInt(DELETE_BY_ID, new int[]{entity.getId()}, connection);
    }

    @Override
    public void update(Order entity) throws FitalException {
    updateDefault(UPDATE,connection,entity);
    }

    @Override
    public List<Order> read() throws FitalException {
        return  defaultRead(READ_ALL,connection);
    }

    @Override
    public void setFieldStatement(PreparedStatement statement, Order entity) throws SQLException {
        statement.setInt(1,entity.getUser().getId());
        statement.setString(2, entity.getType_pay().toString());
        statement.setDate(3, entity.getDate());
        statement.setBigDecimal(4,entity.getTotal_price());
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
