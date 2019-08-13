package dao.mysql;

import dao.UserDao;
import domain.RoleUser;
import domain.User;
import exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseMysql<User> implements UserDao {
    private  static final String CREATE="INSERT INTO `user` (`id`,`name`, `password`, `role`,`telephone_number`,`img`) VALUES (null, ?,?,?, ?, ?)";
    private static final String READ_BY_TELEPHONE="SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `telephone_number` LIKE ?";
    private static final String READ_BY_NAME= "SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `name` LIKE ?";
    private static final String READ_BY_ID ="SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `id` = ?";
    private static final String READ_BY_NAME_AND_PASSWORD="SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `name` = ? AND `password` = ?";
    private static final String READ_BY_ROLE="SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `role` = ?";
    private static final String DELETE_BY_ID ="DELETE FROM `user` WHERE `id` = ?";
    private static final String READ_ALL="SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` ORDER BY `name`";
    private static final String UPDATE="UPDATE `user` SET  `name`=?, `password`=?, `role`=?, `telephone_number`=?,`img`=? WHERE `id` = ?";
    @Override
    public User read(String name, String password) throws DBException {
        String sql=READ_BY_NAME_AND_PASSWORD;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                setParam(user, resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new DBException(e);
        } finally {
            try {
                connection.close();
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
    public User readById(int id) throws DBException {
    return  readByInt(connection,READ_BY_ID,new int[]{id}).get(0);
    }

    @Override
    public List<User> readByRole(RoleUser roleUser) throws DBException {
        return readByString(READ_BY_ROLE, roleUser.toString(),connection);
    }
    @Override
    public List<User> readByName(String name) throws DBException {
        return readByString(READ_BY_NAME,name,connection);
    }

    @Override
    public List<User> readByTelephone(String telephone) throws DBException {
        return readByString(READ_BY_TELEPHONE, telephone,connection);
    }

    @Override
    public Integer create(User entity) throws DBException {
        return  defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(User entity) throws DBException {
        deleteByInt(DELETE_BY_ID,new int[]{entity.getId()},connection);
    }

    @Override
    public void update(User entity) throws DBException {
        updateDefault(UPDATE,connection,entity);
    }

    @Override
    public List<User> read() throws DBException {
        return defaultRead(READ_ALL,connection);
    }

    @Override
    public User fillFieldsObject(ResultSet resultSet) throws SQLException {
        User obj= new User();
        setParam(obj, resultSet);
        return obj;
    }

    public void setParam(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(RoleUser.valueOf(resultSet.getString("role")));
        user.setTelephone(resultSet.getString("telephone_number"));
        user.setImg(resultSet.getString("img"));
    }

    public List<User> fillList(ResultSet resultSet) throws SQLException {
        List<User> users =new ArrayList<>();
        User user = null;
        while(resultSet.next()) {
            user = new User();
            setParam(user,resultSet);
            users.add(user);
        }
        return users;
    }

   public void  setFieldStatement(PreparedStatement statement, User entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getRole().toString());
        statement.setString(4,entity.getTelephone());
        statement.setString(5, entity.getImg());
    }

    @Override
    public void setPrimary(PreparedStatement statement, User entity) throws SQLException {
        statement.setInt(6,entity.getId());
    }
}
