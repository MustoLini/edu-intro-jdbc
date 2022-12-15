package se.iths;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/iths";
    private static final String JDBC_USER = "iths";
    private static final String JDBC_PASSWORD = "iths";
    static Connection con = null;
    static ArrayList<Games> games = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        menu();
    }

    public static void menu() throws SQLException {
        con = startProgram();
        System.out.println("""
                1: Select and Print All Games In DataBase:
                2: Remove Game from Database: 
                3: Update Game in DataBase: 
                """);
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> selectAndPrintDB();
            case 2 -> removeGameFromDB();

        }
    }

    private static void removeGameFromDB() {
        PreparedStatement statement = removeGameFromDB(con, 1);
        games = addIntoGamesObject(statement);
        printGames(games);
    }

    private static void selectAndPrintDB() throws SQLException {
        PreparedStatement stmt = selectAllGames(con);
        games = addIntoGamesObject(stmt);
        printGames(games);
    }

    private static Connection startProgram() throws SQLException {
        con = DriverManager.getConnection(JDBC_CONNECTION, JDBC_USER, JDBC_PASSWORD);
        return con;
    }

    private static PreparedStatement selectAllGames(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from GamesDB");
        return stmt;
    }

    private static ArrayList<Games> addIntoGamesObject(PreparedStatement statement) {
        try {
            int i = 0;
            ResultSet set = statement.executeQuery();
            if (games.isEmpty()) {
                while (set.next()) {
                    i++;
                    games.add(new Games(i, set.getString("Games"), set.getString("Country"), set.getString("BanCategory")));
                }
            } else {
                games.clear();

                while (set.next()) {
                    i++;
                    games.add(new Games(i, set.getString("Games"), set.getString("Country"), set.getString("BanCategory")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return games;
    }

    private static void printGames(ArrayList<Games> games) {
        games.forEach(System.out::println);
    }

    private static PreparedStatement removeGameFromDB(Connection con, int indexToRemove) {
        try {
            PreparedStatement statement = con.prepareStatement("delete from GamesDB where Id = " + indexToRemove);
            statement.execute();
            PreparedStatement stmt = con.prepareStatement("select * from GamesDB");
            return stmt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}