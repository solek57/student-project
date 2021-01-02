package edu.javacourse.studentorder.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {
    public static void dbInit() throws SQLException, URISyntaxException, IOException {
        URL urlCreateTable = DictionaryDaoImplTest.class
                .getClassLoader()
                .getResource("student_project.sql");
        List<String> stringsCreateTable = Files.readAllLines(Paths.get(urlCreateTable.toURI()));
        String strFromSQLCreateTable = stringsCreateTable.stream().collect(Collectors.joining());
        // InsertData
        URL urlInsertData = DictionaryDaoImplTest.class
                .getClassLoader()
                .getResource("student_data.sql");
        List<String> stringsInsertData = Files.readAllLines(Paths.get(urlInsertData.toURI()));
        String strFromSQLInsertData = stringsInsertData.stream().collect(Collectors.joining());

        try (Connection connection = ConnectionBuilder.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(strFromSQLCreateTable);
            statement.executeUpdate(strFromSQLInsertData);
        }

    }
}
