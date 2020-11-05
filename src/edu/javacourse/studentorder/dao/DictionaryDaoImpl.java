package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private static String url = Config.getProperty(Config.DB_URL);
    private static String user = Config.getProperty(Config.DB_LOGIN);
    private static String pwds = Config.getProperty(Config.DB_PASSWORD);

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.
                getConnection(url, user, pwds);
    }
    @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> streetList = new LinkedList<>();

        try(Connection connection = getConnection()) {
            String sqlQuery = "select * from jc where upper(street_name) like upper(?)";
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
