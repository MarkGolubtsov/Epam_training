package dao.mysql;

import dao.ChoseProductDao;
import domain.Address;
import domain.ChoseProduct;
import domain.Order;
import domain.Product;
import exception.FitalException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoseProductDaoImpl extends BaseMysql<ChoseProduct> implements ChoseProductDao {

    private static final String UPDATE ="UPDATE `address` SET `order_id`=? ,`product_id` = ?, `count`=? WHERE `order_id`=? AND `product_id` =?";
    private static  final String DELETE = "DELETE FROM `address` where `order_id`=? AND `product_id`=?";

    private static final String CREATE = "INSERT INTO `address` (`order_id`,`product_id`,`count`) VALUSES(?,?,?)";

    private static final  String READ_ALL = "SELECT `order_id`,`product_id`,`count` FROM `address`";

    private static final String READ_BY_PRODUCT_ID="SELECT `order_id`,`product_id`,`count` FROM `address` WHERE `product_id`=?";
    private static final String READ_BY_ORDER_ID="SELECT `order_id`,`product_id`,`count` FROM `address` WHERE `product_id`=?";
    @Override
    ChoseProduct fillFieldsObject(ResultSet resultSet) throws SQLException {
        ChoseProduct obj= new ChoseProduct();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    void setFieldStatement(PreparedStatement statement, ChoseProduct entity) throws SQLException {
        statement.setInt(1,entity.getOrder().getId());
        statement.setInt(2, entity.getProduct().getId());
        statement.setInt(3, entity.getCount());
    }

    @Override
    List<ChoseProduct> fillList(ResultSet resultSet) throws SQLException {
        List<ChoseProduct> choseProducts =new ArrayList<>();
        while(resultSet.next()) {
            choseProducts.add(fillFieldsObject(resultSet));
        }
        return choseProducts;
    }

    @Override
    void setParam(ChoseProduct obj, ResultSet resultSet) throws SQLException {
        obj= new ChoseProduct();
        obj.setCount(resultSet.getInt("count"));
        Order order = new Order();
        order.setId(resultSet.getInt("order_id"));
        obj.setOrder(order);
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        obj.setProduct(product);
    }

    @Override
    void setPrimary(PreparedStatement statement, ChoseProduct entity) throws SQLException {
        statement.setInt(4,entity.getOrder().getId());
        statement.setInt(5,entity.getProduct().getId());
    }

    @Override
    public List<ChoseProduct> readByOrderId(int order_id) throws FitalException {
        return readByInt(connection,READ_BY_ORDER_ID,new int[]{order_id});
    }

    @Override
    public List<ChoseProduct> readByProductId(int product_id) throws FitalException {
        return readByInt(connection,READ_BY_PRODUCT_ID,new int[]{product_id});
    }

    @Override
    public void create(ChoseProduct entity) throws FitalException {
        defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(ChoseProduct entity) throws FitalException {
        deleteByInt(DELETE,new int[] {entity.getOrder().getId(),entity.getProduct().getId()},connection);
    }

    @Override
    public void update(ChoseProduct entity) throws FitalException {
        updateDefault(UPDATE,connection, entity);
    }

    @Override
    public List<ChoseProduct> read() throws FitalException {
        return  defaultRead(READ_ALL,connection);
    }
}
