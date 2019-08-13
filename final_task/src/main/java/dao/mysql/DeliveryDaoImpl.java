package dao.mysql;

import dao.DeliveryDao;
import domain.Delivery;
import domain.Order;
import domain.User;
import exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final  class DeliveryDaoImpl extends BaseMysql<Delivery> implements DeliveryDao {

    private  static  final String CREATE = "INSERT INTO `delivery`(`order_id`,`courier_id`, `user_id`,`cost`) VALUES(?,?,?,?)";
    private static final  String UPDATE ="UPDATE `delivery` SET `order_id` = ?,`courier_id`=?,`user_id`=? , `cost`=? WHERE `order_id`=? AND `courier_id`=?";

    private static final String DELETE_BY_PRIMARY_KEYS="DELETE FROM `delivery` WHERE `order_id`=? AND `courier_id`=?";

    private static final String READ_ALL ="SELECT `order_id`,`courier_id`, `user_id`,`cost` FROM `delivery` ORDER BY `cost`";

    private static final String READ_BY_PRIMARY_KEYS ="SELECT `order_id`,`courier_id`, `user_id`,`cost` FROM `delivery` WHERE `order_id`=? AND `courier_id`=? ORDER BY `cost`";

    private static final String READ_BY_USER_ID ="SELECT `order_id`,`courier_id`, `user_id`,`cost` FROM `delivery` WHERE `user_id`=? ORDER BY `cost`";

    private static final String READ_BY_ORDER_ID ="SELECT `order_id`,`courier_id`, `user_id`,`cost` FROM `delivery` WHERE `order_id`=? ORDER BY `cost`";

    private static final String READ_BY_COURIER_ID ="SELECT `order_id`,`courier_id`, `user_id`,`cost` FROM `delivery` WHERE `order_id`=? ORDER BY `cost`";


    @Override
    public List<Delivery> readByOrderId(int order_id) throws DBException {
        return readByInt(connection,READ_BY_ORDER_ID,new int[]{order_id});
    }

    @Override
    public List<Delivery> readByCourierId(int courier_id) throws DBException {
        return readByInt(connection,READ_BY_COURIER_ID,new int[]{courier_id});
    }

    @Override
    public Delivery read(int order_id, int courier_id) throws DBException {
        return readByInt(connection,READ_BY_PRIMARY_KEYS,new int[]{order_id,courier_id}).get(0);
    }

    @Override
    public List<Delivery> readByUserId(int user_id) throws DBException {
        return readByInt(connection,READ_BY_USER_ID,new int[]{user_id});
    }

    @Override
    public Integer create(Delivery entity) throws DBException {
    return  defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(Delivery entity) throws DBException {
        deleteByInt(DELETE_BY_PRIMARY_KEYS,new int[]{entity.getOrder().getId(),entity.getCourier().getId()},connection);
    }

    @Override
    public void update(Delivery entity) throws DBException {
    updateDefault(UPDATE,connection,entity);
    }

    @Override
    public List<Delivery> read() throws DBException {
        return defaultRead(READ_ALL,connection);
    }

    @Override
    Delivery fillFieldsObject(ResultSet resultSet) throws SQLException {
        Delivery obj= new Delivery();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    protected void setFieldStatement(PreparedStatement statement, Delivery entity) throws SQLException {
        statement.setInt(1,entity.getOrder().getId());
        statement.setInt(2,entity.getCourier().getId());
        statement.setInt(3,entity.getUser().getId());
        statement.setBigDecimal(4,entity.getCost());
    }

    @Override
     protected List<Delivery> fillList(ResultSet resultSet) throws SQLException {
        List<Delivery> deliveries =new ArrayList<>();
        Delivery delivery = null;
        while(resultSet.next()) {
            delivery= new Delivery();
            setParam(delivery,resultSet);
            deliveries.add(delivery);
        }
        return deliveries;
    }

    @Override
    protected void setParam(Delivery obj, ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("order_id"));
        obj.setOrder(order);
        User courier = new User();
        courier.setId(resultSet.getInt("courier_id"));
        obj.setCourier(courier);
        User user= new User();
        courier.setId(resultSet.getInt("user_id"));
        obj.setUser(user);
        obj.setCost(resultSet.getBigDecimal("cost"));
    }

    @Override
    protected void setPrimary(PreparedStatement statement, Delivery entity) throws SQLException {
    statement.setInt(5,entity.getOrder().getId());
    statement.setInt(6,entity.getUser().getId());
    }
}
