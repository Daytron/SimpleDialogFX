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
import com.github.daytron.simpledialogfx.data.DialogType;
import com.github.daytron.simpledialogfx.data.Fxml;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

/**
 * The master controller class for building any derivatives of dialogs
 *
 * @author Ryan Gilera
 */
public final class Dialog extends Stage implements Initializable {

    @FXML
    private Label messageLabel;
    @FXML
    private Label detailsLabel;
    @FXML
    private HBox okParent;
    @FXML
    private Button okButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    
    // Top head label
    private final String header;
    // Details label
    private final String details;
    // Response chosen by the user
    private DialogResponse response;
    
    private Scene scene;

    private FXMLLoader fxmlLoader;
    
    private DialogType dialogType;

    /**
     * Accepts two <code>String</code> parameters for the constructor.
     *
     * @param dialogType The type of dialog to build
     * @param header The text inside the colored header
     * @param details The text for message details
     */
    public Dialog(DialogType dialogType, String header, String details) {
        this.dialogType = dialogType;
        this.header = header;
        this.details = details;

        // Default response
        this.response = DialogResponse.NO_RESPONSE;

        switch (dialogType) {
            case INFORMATION:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.INFO_DIALOG.getPath()));
                setTitle(DialogText.INFO_HEAD_TITLE.getText());
                break;
            
            case CONFIRMATION:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.CONFIRMATION_DIALOG.getPath()));
                setTitle(DialogText.CONFIRMATION_HEAD_TITLE.getText());
                break;
                
            case WARNING:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.WARNING_DIALOG.getPath()));
                setTitle(DialogText.WARNING_HEAD_TITLE.getText());
                break;

            case ERROR:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.ERROR_DIALOG.getPath()));
                setTitle(DialogText.ERROR_HEAD_TITLE.getText());
                break;
                
            case GENERIC_OK:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.GENERIC_OK_DIALOG.getPath()));
                break;
        }
        
        fxmlLoader.setController(this);
        try {
            this.scene = new Scene((Parent) fxmlLoader.load());
            setScene(scene);
            centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(Dialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    /**
     * Sets the response to the given response parameter.
     *
     * @param response A <code>DialogResponse</code> object pass as an argument
     */
    protected void setResponse(DialogResponse response) {
        this.response = response;
        
    }

    /**
     * Retrieve a response.
     *
     * @return A DialogResponse object pass as an argument
     */
    public DialogResponse getResponse() {
        return response;
    }

    /**
     * Retrieve the message details text.
     *
     * @return A <code>String</code> object pertaining to the message details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Retrieve the header text.
     *
     * @return A <code>String</code> object pertaining to the header
     */
    public String getHeader() {
        return header;
    }
    
    public void setFont(String font) {
        
    }

    /**
     * Initializes the dialog. Set default focus to OK button. Wrap the text for
     * details message label and apply the user-defined header and details.
     *
     * @param location The location used to resolve relative paths for the root
     * object, or null if the location is not known
     * @param resources The resources used to localize the root object, or null if the
     * root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set default focus to the appropriate button
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (dialogType) {
            case INFORMATION:
                okButton.requestFocus();
                break;
            
            case CONFIRMATION:
                yesButton.requestFocus();
                break;
                
            case WARNING:
                okButton.requestFocus();
                break;

            case ERROR:
                okButton.requestFocus();
                break;
                
            case GENERIC_OK:
                okButton.requestFocus();
                break;
        }
                
            }
        });
        
        this.detailsLabel.setWrapText(true);
      
        this.messageLabel.setText(getHeader());
        this.detailsLabel.setText(getDetails());
    }

    /**
     * Event handler when yesButton is pressed. Sets response to YES and closes
     * the dialog window.
     *
     * @param event Action event object
     */
    @FXML
    private void yes_btn_on_click(ActionEvent event) {
        setResponse(DialogResponse.YES);
        close();
    }
    
    /**
     * Event handler when noButton is pressed. Sets response to NO and closes
     * the dialog window.
     *
     * @param event Action event object
     */
    @FXML
    private void no_btn_on_click(ActionEvent event) {
        setResponse(DialogResponse.NO);
        close();
    }
    
    /**
     * Event handler when okButton is pressed. Sets response to OK and closes
     * the dialog window.
     *
     * @param event Action event object
     */
    @FXML
    private void ok_btn_on_click(ActionEvent event) {
        setResponse(DialogResponse.OK);
        close();
    }
}
