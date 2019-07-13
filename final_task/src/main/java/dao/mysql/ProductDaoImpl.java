package dao.mysql;

import dao.ProductDao;
import domain.Product;

import exception.FitalException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseMysql implements ProductDao,DeleteByID {
    private  static final String CREATE="INSERT INTO `product` (`id`, `name`, `type`, `cost`,`img`) VALUES (null, ?,?,?, ?)";
    private static final String READ_BY_ID="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `id` = ?";
    private static final String READ_BY_TYPE="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `type` LIKE ?";
    private static final String READ_ALL="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` ORDER BY `name`";
    private static final String DELETE_BY_ID="DELETE FROM `product` WHERE `id` = ?";
    private static final String UPDATE="UPDATE `product` SET  `name`=?, `type`=?, `cost`=?, `img`=? WHERE `id` = ?";
    private static final String READ_BY_NAME="SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `name` LIKE ?";
    private static final String GET_TYPES="SELECT DISTINCT shop.product.type FROM product";

    @Override
    public List<String> getTypes() throws FitalException {
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
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public Product readById(int id) throws FitalException {
        //String sql = "SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `id` = ?";
        String sql=READ_BY_ID;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                setParam(product, resultSet);
            }
            return product;
        } catch (SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public List<Product> readByType(String type) throws FitalException {
        //String sql = "SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `type` LIKE ?";
        return  readBy(READ_BY_TYPE,type);
    }

    @Override
    public List<Product> readByName(String name) throws FitalException {
        //String sql = "SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` WHERE `name` LIKE ?";
        return  readBy(READ_BY_NAME,name);
    }

    @Override
    public void create(Product entity) throws FitalException {
        String sql=CREATE;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            setFourFieldStatement(statement,entity);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void delete(Product product) throws FitalException {
        deleteById(DELETE_BY_ID,product,connection);
    }

    @Override
    public void update(Product entity) throws FitalException {
        String sql = UPDATE;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            setFourFieldStatement(statement,entity);
            statement.setInt(5,entity.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List read() throws FitalException {
        //String sql = "SELECT `id`, `name`, `type`, `cost`,`img` FROM `product` ORDER BY `name`";
        String sql = READ_ALL;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            return fillProducts(resultSet);
        } catch (SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    private void setParam(Product product, ResultSet resultSet) throws SQLException {
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setType(resultSet.getString("type"));
        product.setCost(resultSet.getDouble("cost"));
        product.setImg_path(resultSet.getString("img"));
    }

    private List<Product> readBy(String sql, String field ) throws FitalException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, field);
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

    private void setFourFieldStatement(PreparedStatement statement, Product entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getType());
        statement.setDouble(3, entity.getCost());
        statement.setString(4,entity.getImg_path());
    }
}
