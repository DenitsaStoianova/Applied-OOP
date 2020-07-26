package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblYearsAt;

    @FXML
    private ComboBox<Person> cboSelectPerson;

    @FXML
    void initialize(){
        ObservableList<Person> observableList = FXCollections.observableArrayList(
                new Person("George", "Georgiev", LocalDate.of(2014, 8, 4)),
                new Person("Pavel", "Ivanov", LocalDate.of(2012, 1, 14)),
                new Person("Ivan", "Petrov", LocalDate.of(2019, 5, 12)),
                new Person("Stoyan", "Pavlov", LocalDate.of(2018, 3, 24)),
                new Person("Kiril", "Simeonov", LocalDate.of(2020, 7, 4)),
                new Person("Jordan", "Angelov", LocalDate.of(2017, 2, 6))
        );

        cboSelectPerson.setItems(observableList);

        cboSelectPerson.setConverter(new StringConverter<Person>() {
            @Override
            public String toString(Person person) {
                return String.format("%s, %s", person.getLastName(), person.getFirstName());
            }

            @Override
            public Person fromString(String s) { // ako ComboBox e editable
                return null;
            }
        });

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd YYYY");

        cboSelectPerson.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            if(cboSelectPerson.getSelectionModel().getSelectedIndex() >= 0){
                Person person = newValue;
                lblFirstName.setText(person.getFirstName());
                lblLastName.setText(person.getLastName());
                lblHiredAt.setText(dateTimeFormatter.format(person.getHireDate()));
                lblYearsAt.setText(String.valueOf(LocalDate.now().getYear() - person.getHireDate().getYear()));
            }
        });
    }
}
