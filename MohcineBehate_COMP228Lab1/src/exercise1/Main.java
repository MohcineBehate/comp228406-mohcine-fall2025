package exercise1;

public class Main {
    public static void main(String[] args) {
        // Création de l'objet singer1 avec constructeur sans argument
        Singers singer1 = new Singers();

        // Affichage des valeurs par défaut
        System.out.println("Valeurs par défaut :");
        System.out.println("ID : " + singer1.getSingerId());
        System.out.println("Name : " + singer1.getSingerName());
        System.out.println("Address : " + singer1.getSingerAddress());
        System.out.println("Date of Birth : " + singer1.getDateOfBirth());
        System.out.println("Number of Albums : " + singer1.getNumberOfAlbums());

        // Utilisation du setter qui modifie toutes les valeurs
        singer1.setAllDetails(1, "Adele", "London, UK", "1988-05-05", 4);
        System.out.println("\nAprès setAllDetails :");
        System.out.println("ID : " + singer1.getSingerId());
        System.out.println("Name : " + singer1.getSingerName());
        System.out.println("Address : " + singer1.getSingerAddress());
        System.out.println("Date of Birth : " + singer1.getDateOfBirth());
        System.out.println("Number of Albums : " + singer1.getNumberOfAlbums());

        // Modification individuelle avec setters
        singer1.setSingerId(2);
        singer1.setSingerName("Ed Sheeran");
        singer1.setSingerAddress("Halifax, UK");
        singer1.setDateOfBirth("1991-02-17");
        singer1.setNumberOfAlbums(5);

        System.out.println("\nAprès modifications individuelles :");
        System.out.println("ID : " + singer1.getSingerId());
        System.out.println("Name : " + singer1.getSingerName());
        System.out.println("Address : " + singer1.getSingerAddress());
        System.out.println("Date of Birth : " + singer1.getDateOfBirth());
        System.out.println("Number of Albums : " + singer1.getNumberOfAlbums());
    }
}
