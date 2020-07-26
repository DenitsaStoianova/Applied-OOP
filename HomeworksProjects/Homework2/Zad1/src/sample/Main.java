package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Main extends Application {

    // text input dialog to get information from user
    public static int textInputDialog(String contentText, String title, String headerText) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);

        return Integer.parseInt(dialog.showAndWait().get());
    }

    // warning message dialog to show the user some warning
    public static void warningMessageDialog(String contentText, String title, String headerText){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    // set style, text and font of text and add it to text flow
    public static void setTextProperties(Text text, TextFlow textFlow, String strToAdd){

        text.setStyle("-fx-font-family: monospace");
        text.setText(strToAdd);
        text.setFont(Font.font(strToAdd, FontWeight.BOLD, 15));
        textFlow.getChildren().add(text);
    }

    // add names of days of week and calculated spaces to text
    public static void addDaysNamesAndSpacesToTextFlow(TextFlow textFlow, int spacesCount){

        String textNamesAndSpaces = String.format("%s%n", "MON TUE WED THR FRI SAT SUN");

        for (int i = 0; i < spacesCount; i++){
            textNamesAndSpaces += "    ";
        }

        Text namesOfDaysAndSpacesText = new Text();
        setTextProperties(namesOfDaysAndSpacesText, textFlow, textNamesAndSpaces);
    }

    // find all days of month and add them to text flow
    public static void addDaysOfMonthToTextFlow(TextFlow textFlow, int year, int numberOfMonth, int spacesCount){

        // get number of days of month, entered by user
        int daysInMonth =
                LocalDate.of(year, numberOfMonth, 1)
                        .with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

        for(int i = 1; i <= daysInMonth; i++){

            // check if date is equal to current date
            if(LocalDate.of(year, numberOfMonth, i).equals(LocalDate.now())){

                String todayDayStr = String.format("%-4d", i);
                Text todayText = new Text();
                todayText.setFill(Color.RED);
                setTextProperties(todayText, textFlow, todayDayStr);
            }
            else {

                String dayStr = String.format("%-4d", i);
                Text daysOfMonthText = new Text();
                setTextProperties(daysOfMonthText, textFlow, dayStr);
            }

            // calculate where to add new line
            if((i + spacesCount) % 7 == 0){

                Text newLineText = new Text(String.format("%n"));
                textFlow.getChildren().add(newLineText);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // get entered month by user
        int numberOfMonth = textInputDialog("Enter number of month:", "Enter month", "Enter number of month which calendar you want to see");

        // check if entered month is in right range
        if(numberOfMonth < 1 || numberOfMonth > 12){
            warningMessageDialog("Number of month should be from 1 to 12.", "Warning", "Wrong input!");
            System.exit(0);
        }

        // get entered year by user
        int year = textInputDialog("Enter year:", "Enter year", "Enter year to see the calendar of given month");

        // get number of day of first day of entered month
        int firstDayOfWeek =
                LocalDate.of(year, numberOfMonth, 1)
                        .with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();

        // text flow to add texts
        TextFlow textFlow = new TextFlow();

        // set x and y coordinates of text flow
        textFlow.setLayoutX(50);
        textFlow.setLayoutY(30);

        // calculate spaces before first day of month
        int spacesCount = firstDayOfWeek - 1;

        // methods to add generated texts to text flow
        addDaysNamesAndSpacesToTextFlow(textFlow, spacesCount);

        addDaysOfMonthToTextFlow(textFlow, year, numberOfMonth, spacesCount);

        // add text flow to scene
        Group group = new Group(textFlow);
        Scene scene = new Scene(group, 350, 200, Color.WHITE);

        // make title of scene
        String sceneTitle = String.format("Calendar for %s %d", Month.of(numberOfMonth).name(), year);

        primaryStage.setTitle(sceneTitle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
