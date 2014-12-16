/*
 * The MIT License
 *
 * Copyright 2014 Ryan Gilera.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.daytron.simpledialogfx.dialog;

import com.github.daytron.simpledialogfx.data.DialogResponse;
import com.github.daytron.simpledialogfx.data.DialogText;
import com.github.daytron.simpledialogfx.data.Fxml;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Ryan Gilera
 */
public final class WarningDialog extends Dialog implements Initializable {
    @FXML
    private Label messageLabel;
    @FXML
    private Label detailsLabel;
    @FXML
    private HBox okParent;
    @FXML
    private Button okButton;


    private DialogResponse response;
    
    public WarningDialog(String header, String details) {
        super(header, details);
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource(Fxml.WARNING_DIALOG.getFxml()));
        fxmlLoader.setController(this);
        
        centerOnScreen();
        setTitle(DialogText.WARNING_HEAD_TITLE.getText());
        
        try {
            setScene(new Scene((Parent) fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set default focus to OK button
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                okButton.requestFocus();
            }
        });

        this.detailsLabel.setWrapText(true);

        this.messageLabel.setText(getHeader());
        this.detailsLabel.setText(getDetails());
    }    

    @FXML
    private void ok_btn_on_click(ActionEvent event) {
        this.response = DialogResponse.OK;
        close();
    }
    
}
