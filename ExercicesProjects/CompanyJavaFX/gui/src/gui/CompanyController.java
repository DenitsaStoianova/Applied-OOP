package gui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import model.Department;
import model.Manager;
import model.Staff;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class CompanyController {

    @FXML
    private ComboBox<Staff> cboSelection;

    @FXML
    private Label lblNameLabel;

    @FXML
    private Label lblName;

    @FXML
    private Label lblWorksText;

    @FXML
    private Label lblWorksAt;

    @FXML
    private Label lblHiredText;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblSalaryText;

    @FXML
    private Label lblSalary;

    @FXML
    private Slider sldSlider;

    @FXML
    private Label lblIncrText;

    @FXML
    private Label lblIncrease;

    @FXML
    void initialize(){
        Staff[] candidates = new Staff[]{
                new Staff("Ken", 0, null, null),
                new Staff("Donna", 0, null, null),
                new Staff("Russell", 0, null, null),
                new Staff("Daemon", 0, null, null),
                new Staff("Stefan", 0, null, null),
                new Staff("Barrie", 0, null, null),
                new Staff("Jimmy", 0, null, null),
        };

        Manager manager = new Manager("John", 0, null);
        Department department = new Department(manager, "IT");

        manager.setAppointRule(department.appointmentHandler);

        Random rand = new Random();

        //  [1000, 2000]
        double salary;
        for(int i = 0; i < candidates.length; i++){
            salary = rand.nextInt(1001) + 1000;
            manager.onStaffAppointment(candidates[i], salary);
        }

        ObservableList<Staff> observableList = FXCollections.observableList(Arrays.asList(candidates));

        cboSelection.setItems(observableList);

        cboSelection.setConverter(new StringConverter<Staff>() {
            @Override
            public String toString(Staff staff) {
                return String.format("%s: %s", staff.ID, staff.getName());
            }

            @Override
            public Staff fromString(String s) {
                return null;
            }
        });

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM YYYY");
        DoubleProperty salaryProperty = new SimpleDoubleProperty(0.0);

        cboSelection.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            if(cboSelection.getSelectionModel().getSelectedIndex() >= 0){
                lblName.setText(newValue.getName());
                lblWorksAt.setText(newValue.getWorkAt());
                lblHiredAt.setText(String.format("%s", dateTimeFormatter.format(newValue.getHiredAt())));
                salaryProperty.setValue(newValue.getSalary());
            }
        });

        lblIncrease.textProperty().bind(Bindings.format("%.2f%s", sldSlider.valueProperty(), "%"));

        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance();

        StringBinding stringBinding = new StringBinding() {
            {
                super.bind(salaryProperty, sldSlider.valueProperty());
            }
            @Override
            protected String computeValue() {
                double salary = salaryProperty.get();
                double percent = sldSlider.valueProperty().intValue()/100.;
                double newSalary = salary + (salary * percent);
                return String.format("%s", numberFormatCurrency.format(newSalary));
            }
        };

        lblSalary.textProperty().bind(stringBinding);
    }
}
