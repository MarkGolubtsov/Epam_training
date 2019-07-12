package dao.mysql;

import domain.Product;
import domain.RoleUser;
import exception.FitalException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends BaseMysql implements dao.ProductDao {
    @Override
    public Product readById(int id) {
        return null;
    }

    @Override
    public List<Product> readByType(String type) {
        return null;
    }

    @Override
    public List<Product> readByName(String name) throws FitalException {
        String sql = "SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `name` = ?";
        return  readBy(sql,name);
    }

    @Override
    public void create(Object entity) throws FitalException {

    }

    @Override
    public void delete(Object entity) throws FitalException {

    }

    @Override
    public void update(Object entity) throws FitalException {

    }

    @Override
    public List read() throws FitalException {
        return null;
    }

    private void setParam(Product product, ResultSet resultSet) throws SQLException {
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setType(resultSet.getString("type"));
        product.setCost(resultSet.getDouble("cost"));
        product.setImg_path(resultSet.getString("img"));
    }

    private List<Product> readBy(String sql, String pole ) throws FitalException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, pole);
            resultSet = statement.executeQuery();
            return fillProducts(resultSet);
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    private List<Product> fillProducts(ResultSet resultSet) throws SQLException, SQLException {
        List<Product> users =new ArrayList<>();
        Product product = null;
        while(resultSet.next()) {
            product = new Product();
            setParam(product,resultSet);
            users.add(product);
        }
        return users;
    }
}
