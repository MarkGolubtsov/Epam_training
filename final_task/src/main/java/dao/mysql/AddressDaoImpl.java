package dao.mysql;

import dao.AddressDao;
import domain.Address;
import domain.User;
import exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl extends BaseMysql<Address> implements AddressDao {
    private static final String READ_BY_STREET="SELECT `user_id`, `street`, `house` FROM `address` WHERE `street` LIKE ?`";
    private static final String UPDATE="UPDATE `address` SET  `user_id`=?, `street`=?, `house`=? WHERE `id` = ?";
    private static final String READ_ALL = "SELECT `user_id` ,`street`,`house`From `address`ORDER BY `date_ord`";

    private static final String READ_BY_HOUSE="SELECT `user_id`, `street`, `house` FROM `address` WHERE `house`=?`";

    private static final String CREATE = "INSERT INTO `address` (`user_id`,`street`,`house`) VALUES (?,?,?)";
    private static final String DELETE= "DELETE FROM `address` WHERE `user_id`=?";

    @Override
    public List<Address> readByStreet(String street) throws DBException {
        return readByString(READ_BY_STREET,street,connection);
    }

    @Override
    public List<Address> readByHouse(int house) throws DBException {
        return readByInt(connection,READ_BY_HOUSE,new int[]{house});
    }


    @Override
    public void create(Address entity) throws DBException {
        defultCreate(CREATE,connection,entity);
    }

    @Override
    public void delete(Address entity) throws DBException {
        deleteByInt(DELETE, new int[]{entity.getUser().getId()},connection);
    }


    @Override
    public void update(Address entity) throws DBException {
        updateDefault(UPDATE,connection,entity);
    }

    @Override
    public List<Address> read() throws DBException {
       return  defaultRead(READ_ALL,connection);
    }

    @Override
    Address fillFieldsObject(ResultSet resultSet) throws SQLException {
        Address obj= new Address();
        setParam(obj, resultSet);
        return obj;
    }

    @Override
    void setFieldStatement(PreparedStatement statement, Address entity) throws SQLException {
        statement.setInt(1,entity.getUser().getId());
        statement.setString(2, entity.getStreet());
        statement.setInt(3, entity.getHouse());
    }

    @Override
    List<Address> fillList(ResultSet resultSet) throws SQLException {
        List<Address> addresses =new ArrayList<>();
        while(resultSet.next()) {
            addresses.add(fillFieldsObject(resultSet));
        }
        return addresses;
    }

    @Override
    void setParam(Address address, ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        address.setUser(user);
        address.setHouse(resultSet.getInt("house"));
    }

    @Override
    void setPrimary(PreparedStatement statement, Address entity) throws SQLException {
        statement.setInt(4,entity.getUser().getId());
    }
}
