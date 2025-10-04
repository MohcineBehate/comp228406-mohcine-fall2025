package exercise1;

public class Singers {

    // Variables d'instance
    private int singerId;
    private String singerName;
    private String singerAddress;
    private String dateOfBirth; // simplification en String
    private int numberOfAlbums;

    // Constructeur sans argument
    public Singers() {
        this.singerId = 0;
        this.singerName = "Unknown";
        this.singerAddress = "Unknown";
        this.dateOfBirth = "Unknown";
        this.numberOfAlbums = 0;
    }

    // Constructeur avec 5 arguments
    public Singers(int singerId, String singerName, String singerAddress, String dateOfBirth, int numberOfAlbums) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    // Getters
    public int getSingerId() { return singerId; }
    public String getSingerName() { return singerName; }
    public String getSingerAddress() { return singerAddress; }
    public String getDateOfBirth() { return dateOfBirth; }
    public int getNumberOfAlbums() { return numberOfAlbums; }

    // Setters individuels
    public void setSingerId(int singerId) { this.singerId = singerId; }
    public void setSingerName(String singerName) { this.singerName = singerName; }
    public void setSingerAddress(String singerAddress) { this.singerAddress = singerAddress; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setNumberOfAlbums(int numberOfAlbums) { this.numberOfAlbums = numberOfAlbums; }

    // Setter pour toutes les variables d'un coup
    public void setAllDetails(int singerId, String singerName, String singerAddress, String dateOfBirth, int numberOfAlbums) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }
}
