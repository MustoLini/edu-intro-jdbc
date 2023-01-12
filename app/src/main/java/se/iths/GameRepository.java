package se.iths;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameRepository {
    private final Connection connection;


    public GameRepository(String JDBC_CONNECTION,
                          String JDBC_USER,
                          String JDBC_PASSWORD) throws SQLException {
        this.connection = DriverManager.getConnection(JDBC_CONNECTION, JDBC_USER, JDBC_PASSWORD);
    }

    public List<Games> getGames() {
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from GamesDB");
            ResultSet set = stmt.executeQuery();
            List<Games> games = new ArrayList<>();
            while (set.next()) {
                games.add(new Games(set.getInt("Id"),
                        set.getString("Games"),
                        set.getString("Country"),
                        set.getString("BanCategory")));
            }
            return games;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(int id, String columnName, String newValue) throws SQLException {
        PreparedStatement statement = null;
        switch (columnName) {
            case "Games" -> {
                statement = connection.prepareStatement("update GamesDB set Games = ? where Id = ?");
            }
            case "Country" -> {
                statement = connection.prepareStatement("update GamesDB set Country = ? where Id = ?");
            }
            case "BanCategory" -> {
                statement = connection.prepareStatement("update GamesDB set BanCategory = ? where Id = ?");
            }

        }
        if (Objects.nonNull(statement)) {
            statement.setString(1, newValue);
            statement.setLong(2, id);
            statement.execute();
        }
    }

    public void removeById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from GamesDB where Id = ?");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
