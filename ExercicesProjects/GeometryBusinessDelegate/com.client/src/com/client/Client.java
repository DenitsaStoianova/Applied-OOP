package com.client;

import com.delegate.BusinessDelegate;
import com.geometry.types.Circle;
import com.geometry.types.Cylinder;
import com.geometry.types.Point;
import com.geometry.utils.SelectionSort;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

public class Client extends Application {

    private TextField txtServiceType;
    private TextArea txaOutput;
    private BusinessDelegate businessDelegate = new BusinessDelegate();

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root = new AnchorPane();

        GridPane pane = new GridPane();

        Label lblService = new Label("Service Type:");
        txtServiceType = new TextField("");
        txtServiceType.setPrefColumnCount(30);

        txaOutput = new TextArea("");
        txaOutput.setWrapText(true);
        txaOutput.setEditable(false);

        Button btnSort = new Button("Sort");
        btnSort.setOnAction(actionEvent -> btnSortOnAction());

        pane.add(lblService, 0, 0);
        pane.add(txtServiceType, 1, 0);
        pane.add(btnSort, 2, 0);
        pane.add(txaOutput, 0, 1, 3, 1);

        pane.setVgap(8.0);
        pane.setHgap(8.0);

        AnchorPane.setTopAnchor(pane, 8.0);
        AnchorPane.setBottomAnchor(pane, 8.0);
        AnchorPane.setRightAnchor(pane, 8.0);
        AnchorPane.setLeftAnchor(pane, 8.0);

        root.getChildren().add(pane);

        stage.setTitle("Business Delegate");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void btnSortOnAction(){
        String serviceType = txtServiceType.getText();
        businessDelegate.setServiceType(serviceType);
        Comparable[] arr = generateArray();

        businessDelegate.doTask(arr);

        txaOutput.setText(Arrays.toString(arr));
    }

    private Comparable[] generateArray(){
        Comparable[] arrComparable = new Comparable[9];
        Random generator = new Random();

        for(int i = 0; i < 3; i++){
            int x = generator.nextInt(41) + 10;
            int y = generator.nextInt(41) + 10;

            arrComparable[i] = new Point(x,y);
        }

        for(int i = 3; i < 6; i++){
            int radius = generator.nextInt(21) + 10;

            Point point = ((Point)arrComparable[i-3]);
            arrComparable[i] = new Circle(point.getX(),point.getY(), radius);
        }

        for(int i = 6; i < 9; i++){
            int height = generator.nextInt(51) + 10;

            Circle circle = ((Circle)arrComparable[i - 3]);
            arrComparable[i] = new Cylinder(circle.getX(), circle.getY(), circle.getRadius(), height);
        }

        for(int i = 0; i < arrComparable.length; i++){
            System.out.println(arrComparable[i]);
        }

        SelectionSort.sortArray(arrComparable);

        System.out.println("\nSorted");
        for(int i = 0; i < arrComparable.length; i++){
            System.out.println(arrComparable[i]);
        }

        return arrComparable;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
