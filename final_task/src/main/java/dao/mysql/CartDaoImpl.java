package dao.mysql;

import dao.CartDao;
import domain.ChoseProduct;
import domain.Product;
import exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl  extends BaseMysql<ChoseProduct> implements CartDao {
    private static final  String READ_BY_ISER_ID = "SELECT `user_id`,`chose_product_id` FROM `cart` where `user_id`=?";
    private static final String CREATE = "INSERT INTO `cart` (`user_id`,`chose_product_id`) VALUES (?,?)";
    private static  final String DELETE = "DELETE FROM `cart` where `user_id`=? AND`chose_product_id`=?";

    private int user_id;
    @Override
    ChoseProduct fillFieldsObject(ResultSet resultSet) throws SQLException {
        ChoseProduct obj= new ChoseProduct();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    void setFieldStatement(PreparedStatement statement, ChoseProduct entity) throws SQLException {
        statement.setInt(1,user_id);
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

    @Override
    public List<ChoseProduct> getUserCart(int user_id) throws DBException {
        return readByInt(connection,READ_BY_ISER_ID,new int[]{user_id});
    }

    @Override
    public void addToCart(int user_id, ChoseProduct choseProduct) throws DBException {
        this.user_id = user_id;
        defultCreate(CREATE,connection,choseProduct);
    }

    @Override
    public void deleteFromCart(int user_id, ChoseProduct choseProduct) throws DBException {
        deleteByInt(DELETE, new int[]{user_id,choseProduct.getId()}, connection);
    }
}
