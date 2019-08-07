package dao.mysql;

import dao.OrderedProductDao;
import domain.ChoseProduct;
import exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedProductDaoImpl extends BaseMysql<ChoseProduct> implements OrderedProductDao {
    private static final  String READ_BY_ORDER_ID = "SELECT `order_id`,`chose_product_id` FROM `product_ordered` where `order_id`=?";
    private static final String CREATE = "INSERT INTO `product_ordered` (`order_id`,`chose_product_id`) VALUES (?,?)";
   // private static  final String DELETE = "DELETE FROM `product_ordered` where `order_id`=? AND`chose_product_id`=?";
    private  int order_id;
    @Override
    public List<ChoseProduct> readOrderProducts(int order_id) throws DBException {
        return readByInt(connection, READ_BY_ORDER_ID, new int[]{order_id});
    }

    @Override
    public void addToOrder(int order_id, ChoseProduct choseProduct) throws DBException {
        this.order_id=order_id;
         defultCreate(CREATE,connection,choseProduct);
    }

    @Override
    ChoseProduct fillFieldsObject(ResultSet resultSet) throws SQLException {
        ChoseProduct obj= new ChoseProduct();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    void setFieldStatement(PreparedStatement statement, ChoseProduct entity) throws SQLException {
        statement.setInt(1,order_id);
        statement.setInt(2,entity.getId());
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
        obj.setId(resultSet.getInt("chose_product_id"));
    }

    @Override
    void setPrimary(PreparedStatement statement, ChoseProduct entity) throws SQLException {

    }
}
