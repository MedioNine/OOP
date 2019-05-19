package com.hirnyk.police.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.hirnyk.police.util.LocalDateAdapter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<LocalDate> birthday;
    private final ObjectProperty<LocalDate> lastMurder;
    private final ObjectProperty<LocalDate> lastFree;
    private final StringProperty murders;

//    private final IntegerProperty postalCode;
    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.murders = new SimpleStringProperty("21.02.1999");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.lastMurder = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.lastFree = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getMurders() {
        return murders.get();
    }

    public void setMurders(String murders) {
        this.murders.set(murders);
    }

    public StringProperty murdersProperty() {
        return murders;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getlastMurder() {
        return lastMurder.get();
    }

    public void setlastMurder(LocalDate lastMurder) {
        this.lastMurder.set(lastMurder);
    }

    public ObjectProperty<LocalDate> lastMurderProperty() {
        return lastMurder;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getlastFree() {
        return lastFree.get();
    }

    public void setlastFree(LocalDate lastFree) {
        this.lastFree.set(lastFree);
    }

    public ObjectProperty<LocalDate> lastFreeProperty() {
        return lastFree;
    }
}