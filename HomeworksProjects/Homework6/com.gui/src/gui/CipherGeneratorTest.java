package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CipherGeneratorTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // first way
        Parent root = FXMLLoader.load(getClass().getResource("CipherGeneratorFXML.fxml"));

        stage.setTitle("Generate random sequence");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
    // second way

package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;

public class CipherGeneratorTest extends Application {

    private TextField txtSeed;
    private TextField txtSize;
    private Button btnGenerateRandom;
    private Button btnRandomSubset;
    private Button btnQuit;

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root = new AnchorPane();

        GridPane pane = new GridPane();
        root.getChildren().add(pane);

        txtSeed = new TextField();
        txtSeed.setPromptText("Enter the seed");

        txtSize = new TextField();
        txtSize.setPromptText("Enter the size");

        btnGenerateRandom = new Button("Generate random A - Z");
        btnGenerateRandom.setPadding(new Insets(5,5,5,5));
        btnGenerateRandom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onAction(actionEvent);
            }
        });

        btnRandomSubset = new Button("Random subset of A - Z");
        btnRandomSubset.setPadding(new Insets(5,5,5,5));
        btnRandomSubset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onAction(actionEvent);
            }
        });

        btnQuit = new Button("Quit");
        btnQuit.setPadding(new Insets(5,60,5,60));
        btnQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onAction(actionEvent);
            }
        });

        pane.add(txtSeed,0,0, 2, 1);
        pane.add(txtSize,0,1, 2, 1);
        pane.add(btnGenerateRandom,0,2);
        pane.add(btnRandomSubset,1,2);
        pane.add(btnQuit, 0,3,2,1);

        pane.setHgap(15);
        pane.setVgap(15);

        GridPane.setMargin(txtSeed, new Insets(60,50,0,60));
        GridPane.setMargin(txtSize, new Insets(0,50,0,60));
        GridPane.setMargin(btnGenerateRandom, new Insets(0,0,0,20));
        GridPane.setMargin(btnQuit, new Insets(0,0,0,100));

        stage.setTitle("Generate random sequence");
        stage.setScene(new Scene(root, 330,270));
        stage.show();
    }

    public void onAction(ActionEvent event){

        if(event.getSource() == btnQuit){
            Platform.exit();
            return;
        }

        if(txtSize.getText().equals("") || txtSeed.getText().equals("")){
            messageBox("User info", "Invalid input!", "Fields cannot be empty");
            return;
        }

        int size = Integer.parseInt(txtSize.getText());
        int seed = Integer.parseInt(txtSeed.getText());
        Wrapper wrapper = new Wrapper(size);

        if(event.getSource() == btnGenerateRandom){
            Result result =  CipherGenerator.countDistinct(wrapper.makeFixedRandom(), seed);
            messageBox("Random subsequence of letters A - Z", "Count distinct characters out of " + size, result.toString());
        } else if(event.getSource() == btnRandomSubset){
            Result result =  CipherGenerator.countDistinct(wrapper.makeFixedSelection(), seed);
            messageBox("Generate random subset A - Z", "Count distinct characters out of " + size, result.toString());
        }
    }

    private void messageBox(String title, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

 */