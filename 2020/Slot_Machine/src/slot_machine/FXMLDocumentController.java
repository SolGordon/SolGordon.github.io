/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot_machine;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author solan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lblMessage;
    @FXML
    private Button btnPlay;
    @FXML
    private TextField txtSlot1;
    @FXML
    private TextField txtSlot2;
    @FXML
    private TextField txtSlot3;

    int num1;
    int num2;
    int num3;

    private void playClick() {
        Random r = new Random();
        num1 = r.nextInt(7 - 1 + 1) + 1;
        num2 = r.nextInt(7 - 1 + 1) + 1;
        num3 = r.nextInt(7 - 1 + 1) + 1;
        txtSlot1.setText(Integer.toString(num1));
        txtSlot2.setText(Integer.toString(num2));
        txtSlot3.setText(Integer.toString(num3));

        if ("7".equals(txtSlot1.getText()) && "7".equals(txtSlot2.getText()) && "7".equals(txtSlot3.getText())) {
            lblMessage.setText("Jackpot!");
        } else {
            lblMessage.setText("Your genitals are useless and you fuckin suck!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnPlay.setOnAction(e -> playClick());
    }

}
