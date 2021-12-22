package com.example.aproj.Controllers;


import com.example.aproj.DBHandlers.DBConnection;
import com.example.aproj.Exceptions.CnicException;
import com.example.aproj.HelloApplication;
import com.example.aproj.SoundThreads.TaskErrorSound;
import com.example.aproj.SoundThreads.TaskSuccessSound;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class SignUpViewController {

    TaskSuccessSound ts = new TaskSuccessSound();
    TaskErrorSound te = new TaskErrorSound();

    @FXML
    private TextField CnicField;

    @FXML
    private PasswordField ConfirmPassField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField PassField;

    @FXML
    private TextField PhoneNoField;

    @FXML
    private Button SignUpButton;

    @FXML
    private Button BackButton;

    @FXML
    private Text signupPrompt;


    @FXML
    private Text cnicexcep;


    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBackButtonMouseMoved(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #F44336");
        BackButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onBackButtonMouseRemoved(MouseEvent event) {
        BackButton.setStyle("-fx-background-color: #ff725e");
        BackButton.setTextFill(Paint.valueOf("#000000"));
    }


    @FXML
    void onSignUpButtonMouseMoved(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #F44336");
        SignUpButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onSignUpButtonMouseRemoved(MouseEvent event) {
        SignUpButton.setStyle("-fx-background-color: #ff725e");
        SignUpButton.setTextFill(Paint.valueOf("#000000"));
    }
    @FXML
    void SignUpButtonClicked(MouseEvent event) throws CnicException {

        if(NameField.getText().isEmpty())
        {
            //sound
            te.run();

            signupPrompt.setText("Name cannot be empty!");
        }
        else if(EmailField.getText().isEmpty())
        {
            //sound
            te.run();

            signupPrompt.setText("Email cannot be empty!");
        }
        else if(CnicField.getText().isEmpty())
        {
            //sound
            te.run();

            signupPrompt.setText("Cnic cannot be empty!");
        }

        String cnic = CnicField.getText();


        try {
            int cnicInt = parseInt(cnic);

            try {
                CheckCnic(cnicInt);
            }
            catch (Exception e)
            {
                cnicexcep.setText(e.getMessage());
            }

            if(cnicInt < 100000000 || cnicInt > 199999999)
            {
                CheckCnic(cnicInt);
            }



                else
            {
                DBConnection dbConnection = DBConnection.getDBConnection();

                if(dbConnection.searchUser(cnic) == true)
                {
                    //sound
                    te.run();

                    signupPrompt.setText("Cnic Already Registered!");
                }
                else
                {

                    if(PhoneNoField.getText().isEmpty())
                    {
                        //sound
                        te.run();

                        signupPrompt.setText("Phone No Is Required!");
                    }
                    else{


                    if(PassField.getText().isEmpty())
                    {
                        //sound
                        te.run();

                        signupPrompt.setText("Password Cannot Be Empty!");
                    }
                    else
                    {
                        if (PassField.getText().equals(ConfirmPassField.getText())) {

                            //sound
                            ts.run();

                            dbConnection.insertUser(NameField.getText(),EmailField.getText(),Integer.parseInt(CnicField.getText()),PhoneNoField.getText(),PassField.getText());
                            signupPrompt.setText("You account has been registered");
                        }
                        else
                        {
                            //sound
                            te.run();

                            signupPrompt.setText("Passwords are not matching!");

                            System.out.println(PassField.getText());

                            System.out.println(ConfirmPassField.getText());
                        }
                    }



                }}

            }

        }
        catch(Exception e)
        {
            System.out.println(e.getCause());
        }

    }

    static int CheckCnic(int cnic) throws CnicException
    {
        if (cnic < 100000000 || cnic > 199999999)
        {
            throw new CnicException("Invalid CNIC");
        }
        else {
            System.out.println("");
        }
        return cnic;
    }

}
