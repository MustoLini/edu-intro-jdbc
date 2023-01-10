package se.iths;

public class Games {
    private final int id;
    private String Games;
    private String Country;
    private String BanCategory;

    public Games(int id, String games, String country, String banCategory) {
        this.id = id;
        Games = games;
        Country = country;
        BanCategory = banCategory;
    }

    public String getGames() {
        return Games;
    }

    public void setGames(String games) {
        Games = games;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getBanCategory() {
        return BanCategory;
    }

    public void setBanCategory(String banCategory) {
        BanCategory = banCategory;
    }

    @Override
    public String toString() {
        return id + " | " + Games + " | " + Country + " | " + BanCategory + " | ";
    }
}
