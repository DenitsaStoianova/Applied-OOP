package user;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private String _lastName;
    private StringProperty lastName;
    private StringProperty password;

    public User(String lastName, String password) {
       setLastName(lastName);
       this.password = new SimpleStringProperty(this, "password", password == null ? "" : password);
    }

    public User(){
        this("James", "007");
    }

    public final String getLastName() {
        if(lastName == null){
            return _lastName;
        } else {
            return lastName.get();
        }
    }

    public final StringProperty lastNameProperty() {
        if(lastName == null){
            lastName = new SimpleStringProperty(this, "lastName", _lastName);
        }
        return lastName;
    }

    public final void setLastName(String lastName) {
        lastName = lastName == null ? "unknown" : lastName;
        if(this.lastName == null){
            _lastName = lastName;
        } else {
            this.lastName.set(lastName);
        }
    }

    public final String getPassword() {
        return password.get();
    }

    public final StringProperty passwordProperty() {
        return password;
    }

    public final void setPassword(String password) {
        password = password == null ? "" : password;
        this.password.set(password);
    }
}
