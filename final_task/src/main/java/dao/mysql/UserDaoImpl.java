package dao.mysql;

import dao.UserDao;
import domain.RoleUser;
import domain.User;
import exception.FitalException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseMysql implements UserDao {
    @Override
    public User read(String name, String password) throws FitalException {
        String sql = "SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `name` = ? AND `password` = md5(?)";
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
    public List<User> readByRole(RoleUser roleUser) throws FitalException {
        String sql = "SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `role` = ?";
        return readBy(sql, roleUser.toString());
    }

    @Override
    public List<User> readByTelephone(String telephone) throws FitalException {
        String sql = "SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` WHERE `telephone_number` = ?";
        return readBy(sql, telephone);
    }

    @Override
    public void create(User entity) throws FitalException {
        String sql = "INSERT INTO `user` (`id`,`name`, `password`, `role`,`telephone_number`,`img`) VALUES (null, ?,?,?, ?, ?)";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRoleUser().toString());
            statement.setString(4,entity.getTelephone());
            statement.setBlob(5, entity.getImg());
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
    public void delete(User entity) throws FitalException {
        String sql = "DELETE FROM `user` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getId());
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
    public void update(User entity) throws FitalException {
        String sql = "UPDATE `user` SET  `name`=?, `password`=?, `role`=?, `telephone_number`=?,`img`=? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRoleUser().toString());
            statement.setString(4,entity.getTelephone());
            statement.setBlob(5, entity.getImg());
            statement.setInt(6,entity.getId());
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
    public List<User> read() throws FitalException {
        String sql = "SELECT `id`, `name`, `password`, `role`, `telephone_number`,`img` FROM `user` ORDER BY `name`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            return fillUsers(resultSet);
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

    private void setParam(User user,ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setRoleUser(RoleUser.valueOf(resultSet.getString("role")));
        user.setTelephone(resultSet.getString("telephone_number"));
        user.setImg(resultSet.getBlob("img"));
    }

    private List<User> readBy(String sql, String pole ) throws FitalException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, pole);
            resultSet = statement.executeQuery();
            return fillUsers(resultSet);
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

    private List<User> fillUsers(ResultSet resultSet) throws SQLException {
        List<User> users =new ArrayList<>();
        User user = null;
        while(resultSet.next()) {
            user = new User();
            setParam(user,resultSet);
            users.add(user);
        }
        return users;
    }


}
