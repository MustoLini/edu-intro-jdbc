package se.iths;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/iths";
    private static final String JDBC_USER = "iths";
    private static final String JDBC_PASSWORD = "iths";
    static Scanner in = new Scanner(System.in);

    static GameRepository gameRepository;

    public static void main(String[] args) throws SQLException {
        menu();
    }

    public static void menu() throws SQLException {
        gameRepository = new GameRepository(JDBC_CONNECTION, JDBC_USER, JDBC_PASSWORD);
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
        printGames(gameRepository.getGames());

        System.out.println();
        System.out.println("What index do you want to change?");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("What Column do you want to change?");
        String columnName = in.nextLine();
        System.out.println("What do you want to change it to?");
        String newValue = in.nextLine();
        gameRepository.update(id, columnName, newValue);
        printGames(gameRepository.getGames());
    }

    private static void removeGameFromDB() {
        selectAndPrintDB();
        System.out.println("What index do you want to remove?");
        int id = in.nextInt();
        gameRepository.removeById(id);
        printGames(gameRepository.getGames());
    }

    private static void selectAndPrintDB() {
        printGames(gameRepository.getGames());
    }

    private static void printGames(List<Games> games) {
        games.forEach(System.out::println);
    }
}