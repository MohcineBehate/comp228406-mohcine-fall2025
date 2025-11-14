package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextField nameField = new TextField();
        TextField addressField = new TextField();
        TextField cityField = new TextField();
        TextField provinceField = new TextField();
        TextField postalField = new TextField();
        TextField phoneField = new TextField();
        TextField emailField = new TextField();

        RadioButton csRadio = new RadioButton("Computer Science");
        RadioButton busRadio = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csRadio.setToggleGroup(majorGroup);
        busRadio.setToggleGroup(majorGroup);

        ComboBox<String> courseBox = new ComboBox<>();
        String[] csCourses = {"Java", "Python", "AI Fundamentals", "Databases"};
        String[] busCourses = {"Marketing", "Finance", "Economics", "Accounting"};

        csRadio.setOnAction(e -> courseBox.getItems().setAll(csCourses));
        busRadio.setOnAction(e -> courseBox.getItems().setAll(busCourses));

        ListView<String> selectedCourses = new ListView<>();

        courseBox.setOnAction(e -> {
            String selected = courseBox.getValue();
            if (selected != null && !selectedCourses.getItems().contains(selected)) {
                selectedCourses.getItems().add(selected);
            }
        });

        CheckBox sports = new CheckBox("Sports");
        CheckBox club = new CheckBox("Clubs");
        CheckBox volunteer = new CheckBox("Volunteering");

        TextArea output = new TextArea();

        Button displayBtn = new Button("Display Information");
        displayBtn.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Student Information\n-------------------------\n");
            sb.append("Name: ").append(nameField.getText()).append("\n");
            sb.append("Address: ").append(addressField.getText()).append("\n");
            sb.append("City: ").append(cityField.getText()).append("\n");
            sb.append("Province: ").append(provinceField.getText()).append("\n");
            sb.append("Postal Code: ").append(postalField.getText()).append("\n");
            sb.append("Phone: ").append(phoneField.getText()).append("\n");
            sb.append("Email: ").append(emailField.getText()).append("\n\n");

            sb.append("Major: ");
            sb.append(csRadio.isSelected() ? "Computer Science" :
                     busRadio.isSelected() ? "Business" : "Not selected");
            sb.append("\n\n");

            sb.append("Courses:\n");
            selectedCourses.getItems().forEach(c -> sb.append("- ").append(c).append("\n"));

            sb.append("\nActivities:\n");
            if (sports.isSelected()) sb.append("- Sports\n");
            if (club.isSelected()) sb.append("- Clubs\n");
            if (volunteer.isSelected()) sb.append("- Volunteering\n");

            output.setText(sb.toString());
        });

        GridPane form = new GridPane();
        form.setVgap(8);
        form.setHgap(10);
        form.setPadding(new Insets(10));

        form.add(new Label("Full Name:"), 0, 0);
        form.add(nameField, 1, 0);
        form.add(new Label("Address:"), 0, 1);
        form.add(addressField, 1, 1);
        form.add(new Label("City:"), 0, 2);
        form.add(cityField, 1, 2);
        form.add(new Label("Province:"), 0, 3);
        form.add(provinceField, 1, 3);
        form.add(new Label("Postal Code:"), 0, 4);
        form.add(postalField, 1, 4);
        form.add(new Label("Phone:"), 0, 5);
        form.add(phoneField, 1, 5);
        form.add(new Label("Email:"), 0, 6);
        form.add(emailField, 1, 6);

        VBox majorsBox = new VBox(10, csRadio, busRadio);
        VBox activitiesBox = new VBox(10, sports, club, volunteer);

        BorderPane root = new BorderPane();
        root.setTop(form);
        root.setLeft(new VBox(10, new Label("Major"), majorsBox, new Label("Courses"), courseBox));
        root.setCenter(new VBox(10, new Label("Selected Courses"), selectedCourses));
        root.setRight(new VBox(10, new Label("Activities"), activitiesBox));
        root.setBottom(new VBox(10, displayBtn, output));
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Student Information App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
