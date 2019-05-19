package com.hirnyk.police.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.hirnyk.police.model.Person;
import com.hirnyk.police.util.DateUtil;

/**
 * Dialog to edit details of a person.
 */
public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField murdersField;
    @FXML
    private TextField lastMurderField;
    @FXML
    private TextField lastFreeField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        murdersField.setText(person.getMurders());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
        lastMurderField.setText(DateUtil.format(person.getlastMurder()));
        lastMurderField.setPromptText("dd.mm.yyyy");
        lastFreeField.setText(DateUtil.format(person.getlastFree()));
        lastFreeField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setMurders(murdersField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));
            person.setlastMurder(DateUtil.parse(lastMurderField.getText()));
            person.setlastFree(DateUtil.parse(lastFreeField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "Неправильно введене ім'я!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "Неправильно введене прізвище!\n";
        }
        if (murdersField.getText() == null || murdersField.getText().length() == 0) {
            errorMessage += "Неправильно введені судимості!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "Неправильно введена дата народження!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "Неправильно введена дата народження.Використовуйте формати дд.мм.рррр!\n";
            }
        }

        if (lastMurderField.getText() == null || lastMurderField.getText().length() == 0) {
            errorMessage += "Неправильно введена дата останньої судимості!\n";
        } else {
            if (!DateUtil.validDate(lastMurderField.getText())) {
                errorMessage += "Неправильно введена дата останньої судимості. Використовуйте формати дд.мм.рррр!\n";
            }
        }

        if (lastFreeField.getText() == null || lastFreeField.getText().length() == 0) {
            errorMessage += "Неправильно введена дата останнього звільнення!\n";
        } else {
            if (!DateUtil.validDate(lastFreeField.getText())) {
                errorMessage += "Неправильно введена дата останнього звільнення. Використовуйте формати дд.мм.рррр!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Неправильно заповнені поля");
            alert.setHeaderText("Будь ласка заповніть правильно");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}