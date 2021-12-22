package com.example.aproj.Controllers;

import com.example.aproj.Classes.User;
import com.example.aproj.FileHandlers.FeedbackWriter;
import com.example.aproj.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackViewController {

    @FXML
    private Button BackButton;

    @FXML
    private TextArea FeedbackTextArea;

    @FXML
    private Button SubmitButton;

    @FXML
    private Text promptText;

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FXMLFiles/profiles-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Node node = (Node) event.getSource();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SubmitButtonPressed(MouseEvent event) {
        if(FeedbackTextArea.getText().isEmpty())
        {
            promptText.setText("Please Write Your Feedback First!");
        }
        else
        {
            String _feedback = User.getUser().getCnic() + " : Feedback ( " + FeedbackTextArea.getText() + " )";
            FeedbackWriter feedbackWriter = new FeedbackWriter();
            feedbackWriter.feedback = _feedback;

            feedbackWriter.run();

            FeedbackTextArea.setText("");
            promptText.setText("FeedBack Submitted, Thank you for letting us know!");
        }
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
    void onSubmitButtonMouseMoved(MouseEvent event) {
        SubmitButton.setStyle("-fx-background-color: #F44336");
        SubmitButton.setTextFill(Paint.valueOf("#FFFFFF"));
    }

    @FXML
    void onSubmitButtonMouseRemoved(MouseEvent event) {
        SubmitButton.setStyle("-fx-background-color: #ff725e");
        SubmitButton.setTextFill(Paint.valueOf("#000000"));
    }

}
