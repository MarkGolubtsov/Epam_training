package dao.mysql;

import dao.ChoseProductDao;
import domain.ChoseProduct;
import domain.Product;
import exception.DBException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoseProductDaoImpl extends BaseMysql<ChoseProduct> implements ChoseProductDao {

    private static final String UPDATE ="UPDATE `chose_product` SET  `product_id` = ?, `count`=? WHERE `id`=? ";
    private static  final String DELETE = "DELETE FROM `chose_product` where `id`=?";

    private static final String DELETE_BY_PRODUCT = "DELETE FROM `chose_product` where  `product_id`=?";
    private static final String CREATE = "INSERT INTO `chose_product` (`id`,`product_id`,`count`) VALUES (null,?,?)";

    private static final  String READ_ALL = "SELECT `id`,`product_id`,`count` FROM `chose_product`";

    private static final String READ_BY_PRODUCT_ID="SELECT `id` ,`product_id`,`count` FROM `chose_product` WHERE `product_id`=?";

    private static final String READ_BY_ID="SELECT `id`,`product_id`,`count` FROM `chose_product` WHERE `id`=?";

    @Override
    ChoseProduct fillFieldsObject(ResultSet resultSet) throws SQLException {
        ChoseProduct obj= new ChoseProduct();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    void setFieldStatement(PreparedStatement statement, ChoseProduct entity) throws SQLException {
        statement.setInt(1, entity.getProduct().getId());
        statement.setInt(2, entity.getCount());
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
        obj.setId(resultSet.getInt("id"));
        obj.setCount(resultSet.getInt("count"));
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        obj.setProduct(product);
    }

    @Override
    void setPrimary(PreparedStatement statement, ChoseProduct entity) throws SQLException {
        statement.setInt(3,entity.getId());
    }


    @Override
    public List<ChoseProduct> readByProductId(int product_id) throws DBException {
        return readByInt(connection,READ_BY_PRODUCT_ID,new int[]{product_id});
    }


    @Override
    public Integer create(ChoseProduct entity) throws DBException {
       return defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(ChoseProduct entity) throws DBException {
        deleteByInt(DELETE,new int[] {entity.getId()},connection);
    }

    @Override
    public void update(ChoseProduct entity) throws DBException {
        updateDefault(UPDATE,connection, entity);
    }

    @Override
    public List<ChoseProduct> read() throws DBException {
        return  defaultRead(READ_ALL,connection);
    }

    @Override
    public void deleteByProductId(int product_id) throws DBException {
    deleteByInt(DELETE_BY_PRODUCT, new int[]{product_id}, connection);
    }

    @Override
    public ChoseProduct readById(int id) throws DBException {
        return  readByInt(connection,READ_BY_ID,new int[]{id}).get(0);
    }

}
