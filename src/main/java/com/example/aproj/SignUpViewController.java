package com.example.aproj;


//import com.example.DatabaseLayer.DBConnection;

import com.example.aproj.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class SignUpViewController {



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
    public Text signupPrompt1;


    @FXML
    private Label cnexcep;
    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
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
    void SignUpButtonClicked(MouseEvent event) {

        if(NameField.getText().isEmpty())
        {
            signupPrompt1.setText("Name cannot be empty!");
        }
        else if(EmailField.getText().isEmpty())
        {
            signupPrompt1.setText("Email cannot be empty!");
        }
        else if(CnicField.getText().isEmpty())
        {
            signupPrompt1.setText("Cnic cannot be empty!");
        }


        String cnic = CnicField.getText();


        try {
            int cnicInt = parseInt(cnic);

            try {
                CheckCnic(cnicInt);
            }
            catch (Exception e)
            {
               cnexcep.setText(e.getMessage());
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
                    signupPrompt1.setText("Cnic Already Registered!");
                }

                else
                {

                    if(PhoneNoField.getText().isEmpty())
                    {
                        signupPrompt1.setText("Phone No Is Required!");
                    }
                    else{


                    if(PassField.getText().isEmpty())
                    {
                        signupPrompt1.setText("Password Cannot Be Empty!");
                    }
                    else
                    {
                        if (PassField.getText().equals(ConfirmPassField.getText())) {

                           /* try{
                                ConfirmPassField=CheckPassword(ConfirmPassField);
                            }
                            catch (Exception e)
                            {
                                System.out.println("Passwords are not matching "+e);
                            }
                            */
                            signupPrompt1.setText("You account has been registered");
                            dbConnection.insertUser(NameField.getText(),EmailField.getText(),Integer.parseInt(CnicField.getText()),PhoneNoField.getText(),PassField.getText());

                        }
                        else
                        {

                            signupPrompt1.setText("Passwords are not matching!");

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
