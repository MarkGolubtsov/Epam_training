package dao.pool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class PooledConnection implements Connection,Comparable<PooledConnection> {

    private Connection connection;

    public PooledConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        return connection.isWrapperFor(arg0);
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        return connection.unwrap(arg0);
    }

    @Override
    public void abort(Executor arg0) throws SQLException {
        connection.abort(arg0);
    }

    @Override
    public void clearWarnings() throws SQLException {
        connection.clearWarnings();
    }

    @Override
    public void close() throws SQLException {
        ConnectionPool.INSTANCE.freeConnection(this);
    }

    @Override
    public void commit() throws SQLException {
        connection.commit();
    }

    @Override
    public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
        return connection.createArrayOf(arg0, arg1);
    }

    @Override
    public Blob createBlob() throws SQLException {
        return connection.createBlob();
    }

    @Override
    public Clob createClob() throws SQLException {
        return connection.createClob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return connection.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return connection.createSQLXML();
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    @Override
    public Statement createStatement(int arg0, int arg1) throws SQLException {
        return connection.createStatement(arg0, arg1);
    }

    @Override
    public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
        return connection.createStatement(arg0, arg1, arg2);
    }

    @Override
    public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
        return connection.createStruct(arg0, arg1);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    @Override
    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return connection.getClientInfo();
    }

    @Override
    public String getClientInfo(String arg0) throws SQLException {
        return connection.getClientInfo(arg0);
    }

    @Override
    public int getHoldability() throws SQLException {
        return connection.getHoldability();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return connection.getNetworkTimeout();
    }

    @Override
    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return connection.getTypeMap();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return connection.getWarnings();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return connection.isReadOnly();
    }

    @Override
    public boolean isValid(int arg0) throws SQLException {
        return connection.isValid(arg0);
    }

    @Override
    public String nativeSQL(String arg0) throws SQLException {
        return connection.nativeSQL(arg0);
    }

    @Override
    public CallableStatement prepareCall(String arg0) throws SQLException {
        return connection.prepareCall(arg0);
    }

    @Override
    public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
        return connection.prepareCall(arg0, arg1, arg2);
    }

    @Override
    public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
        return connection.prepareCall(arg0, arg1, arg2, arg3);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0) throws SQLException {
        return connection.prepareStatement(arg0);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
        return connection.prepareStatement(arg0, arg1);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
        return connection.prepareStatement(arg0, arg1);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
        return connection.prepareStatement(arg0, arg1);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
        return connection.prepareStatement(arg0, arg1, arg2);
    }

    @Override
    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
        return connection.prepareStatement(arg0, arg1, arg2, arg3);
    }

    @Override
    public void releaseSavepoint(Savepoint arg0) throws SQLException {
        connection.releaseSavepoint(arg0);
    }

    @Override
    public void rollback() throws SQLException {
        connection.rollback();
    }

    @Override
    public void rollback(Savepoint arg0) throws SQLException {
        connection.rollback(arg0);
    }

    @Override
    public void setAutoCommit(boolean arg0) throws SQLException {
        connection.setAutoCommit(arg0);
    }

    @Override
    public void setCatalog(String arg0) throws SQLException {
        connection.setCatalog(arg0);
    }

    @Override
    public void setClientInfo(Properties arg0) throws SQLClientInfoException {
        connection.setClientInfo(arg0);
    }

    @Override
    public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
        connection.setClientInfo(arg0, arg1);
    }

    @Override
    public void setHoldability(int arg0) throws SQLException {
        connection.setHoldability(arg0);
    }

    @Override
    public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
        connection.setNetworkTimeout(arg0, arg1);
    }

    @Override
    public void setReadOnly(boolean arg0) throws SQLException {
        connection.setReadOnly(arg0);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return connection.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String arg0) throws SQLException {
        return connection.setSavepoint(arg0);
    }

    @Override
    public void setSchema(String arg0) throws SQLException {
        connection.setSchema(arg0);
    }

    @Override
    public void setTransactionIsolation(int arg0) throws SQLException {
        connection.setTransactionIsolation(arg0);
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
        connection.setTypeMap(arg0);
    }

    @Override
    public int compareTo(PooledConnection connection) {
        return hashCode() - connection.hashCode();
    }
}
