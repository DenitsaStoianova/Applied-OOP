package test;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import user.User;

public class Test {
    public static void main(String[] args) {
        StringProperty lname = new SimpleStringProperty("");

        User user = new User("Bond", "007");

        StringProperty userLastNameProperty = user.lastNameProperty();

        lname.bindBidirectional(userLastNameProperty);

        userLastNameProperty.set("007");

        lname.set("New agent");

        System.out.println(userLastNameProperty.get());
        System.out.println(lname.get());
    }
}
