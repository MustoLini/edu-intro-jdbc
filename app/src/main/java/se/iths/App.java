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
        in.nextLine();
        switch (choice) {
            case 1 -> selectAndPrintDB();
            case 2 -> removeGameFromDB();
            case 3 -> updateGameFromDB();
        }
    }

    private static void updateGameFromDB() throws SQLException {
        selectAndPrintDB();
        System.out.println();
        System.out.println("What index do you want to change?");
        int num = in.nextInt();
        in.nextLine();
        System.out.println("What Column do you want to change?");
        String columnChange= in.nextLine();
        System.out.println("What do you want to change it to?");
        String nameChange= in.nextLine();
        PreparedStatement statement = updateStatementTowardsUpdatingDb(columnChange,nameChange,num);
        statement.execute();
        statement= con.prepareStatement("select * from GamesDB");
        statement.execute();
        selectAndPrintDB();
    }

    private static PreparedStatement updateStatementTowardsUpdatingDb(String stringChange, String valueChange, int num) throws SQLException {

            switch (stringChange){
                case "Games" -> {
                    PreparedStatement games =con.prepareStatement("update from GamesDB set Games = " + valueChange + " where Id = " + num);
                    return games;
                }
                case "Country" -> {
                   PreparedStatement country = con.prepareStatement("update from GamesDB set Country = " + valueChange + " where Id = " + num);
                    return country;
                }
                case "BanCategory" -> {
                    PreparedStatement banCategory = con.prepareStatement("update from GamesDB set BanCategory = " + valueChange + " where Id = " + num);
                    return banCategory;
                }
                default -> {
                    PreparedStatement defstatement= con.prepareStatement("select * from GamesDB");
                    return defstatement;
                }
            }

    }

    private static void removeGameFromDB() throws SQLException {
        selectAndPrintDB();
        System.out.println("What index do you want to remove?");
        int value= in.nextInt();
        PreparedStatement statement = removeGameFromDBs(con, value);
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

    private static PreparedStatement removeGameFromDBs(Connection con, int indexToRemove) {
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