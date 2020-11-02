package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private static String url = "jdbc:h2:file:~/testdb";
    private static String user = "sa";
    private static String pwds = "123";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.
                getConnection(url, user, pwds);
    }
    @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> streetList = new LinkedList<>();

        try(Connection connection = getConnection()) {
            String sqlQuery = "select * from street where upper(street_name) like upper(?)";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, pattern);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                streetList.add(new Street(resultSet.getLong("STREET_NUM"), resultSet.getString("STREET_NAME")));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException(e);
        }
        return streetList;

    }
}
