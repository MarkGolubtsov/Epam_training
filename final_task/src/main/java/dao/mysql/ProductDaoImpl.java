package dao.mysql;

import dao.ProductDao;
import domain.Product;
import exception.DBException;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public final class ProductDaoImpl extends BaseMysql<Product> implements ProductDao{
    private  static final String CREATE="INSERT INTO `product` (`id`, `name`, `type`, `cost`,`img`) VALUES (null, ?,?,?, ?)";
    private static final String READ_BY_ID="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `id` = ?";
    private static final String READ_BY_TYPE="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `type` LIKE ?";
    private static final String READ_ALL="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` ORDER BY `name`";
    private static final String DELETE_BY_ID="DELETE FROM `product` WHERE `id` = ?";

    private static final String UPDATE="UPDATE `product` SET  `name`=?, `type`=?, `cost`=?, `img`=? WHERE `id` = ?";
    private static final String READ_BY_NAME="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `name` LIKE ?";
    private static final String GET_TYPES="SELECT DISTINCT shop.product.type FROM product";

    @Override
    public List<String> readTypes() throws DBException {
        String sql = GET_TYPES;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<String> types=new ArrayList<>();

            while(resultSet.next()) {
                String t=resultSet.getString("type");
                types.add(t);
            }
            return types;
        } catch (SQLException e) {
            throw new DBException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
                connection.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public Product readById(int id) throws DBException {
        return  readByInt(connection,READ_BY_ID,new int[]{id}).get(0);
    }

    @Override
    public List<Product> readByType(String type) throws DBException {
        return  readByString(READ_BY_TYPE,type,connection);
    }

    @Override
    public List<Product> readByName(String name) throws DBException {
        return  readByString(READ_BY_NAME,name,connection);
    }

    @Override
    public Integer create(Product entity) throws DBException {
        return defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(Product product) throws DBException {
        deleteByInt(DELETE_BY_ID,new int[]{product.getId()},connection);
    }

    @Override
    public void update(Product entity) throws DBException {
        updateDefault(UPDATE,connection,entity);
    }

    @Override
    public List<Product> read() throws DBException {
        return  defaultRead(READ_ALL,connection);
    }


    @Override
    public Product fillFieldsObject(ResultSet resultSet) throws SQLException, IOException {
        Product product = null;
        if (resultSet.next()) {
            product = new Product();
            setParam(product, resultSet);
        }
        return product;
    }

    @Override
    public void setParam(Product product, ResultSet resultSet) throws SQLException, IOException {
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setType(resultSet.getString("type"));
        product.setCost(resultSet.getBigDecimal("cost"));
        byte[] blob = resultSet.getBytes("img");
        if (blob != null) {
            String encode = Base64.getEncoder().encodeToString(blob);
            product.setImg(encode);
        }
    }

    @Override
    protected void setPrimary(PreparedStatement statement, Product entity) throws SQLException {
        statement.setInt(5,entity.getId());
    }

    @Override
    protected List<Product> fillList(ResultSet resultSet) throws SQLException, SQLException, IOException {
        List<Product> products =new ArrayList<>();
        Product product = null;
        while(resultSet.next()) {
            product = new Product();
            setParam(product,resultSet);
            products.add(product);
        }
        return products;
    }

    @Override
    protected void setFieldStatement(PreparedStatement statement, Product entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getType());
        statement.setBigDecimal(3, entity.getCost());
        byte[] a = Base64.getDecoder().decode(entity.getImg());
        statement.setBytes(4,a);
    }
}
