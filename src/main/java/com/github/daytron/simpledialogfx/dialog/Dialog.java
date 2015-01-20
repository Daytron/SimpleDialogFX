/*
 * The MIT License
 *
 * Copyright 2014-2015 Ryan Gilera.
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
import com.github.daytron.simpledialogfx.data.DialogStyle;
import com.github.daytron.simpledialogfx.data.DialogText;
import com.github.daytron.simpledialogfx.data.DialogType;
import com.github.daytron.simpledialogfx.data.HeaderColorStyle;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * The controller class for building any derivatives of dialogs
 *
 * @author Ryan Gilera
 */
public class Dialog extends Stage implements Initializable {

    @FXML
    private Label headerLabel;
    @FXML
    private Label detailsLabel;
    @FXML
    private HBox okParent;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    @FXML
    private TextArea exceptionArea;
    @FXML
    private TextField inputTextField;
    @FXML
    private Button sendButton;

    // Top head label
    private final String header;
    // Details label
    private final String details;
    // Response chosen by the user
    private DialogResponse response;

    private Scene scene;

    private FXMLLoader fxmlLoader;

    private final DialogType dialogType;

    private final Exception exception;

    private String textEntry;

    private HeaderColorStyle headerColorStyle;
    private boolean isLoadingError;

    /**
     * Construct a dialog using the default "native" dialog style. The type of
     * dialog to be created is determine by the dialogType parameter. The
     * default title is set to empty;
     *
     * @param dialogType The dialog type to be created
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, String header, String details) {
        this(dialogType, DialogStyle.NATIVE, "", header, details, null);
    }
    
    /**
     * Construct a dialog using the default "native" dialog style with custom 
     * header background style color. The type of dialog to be created is 
     * determine by the dialogType parameter. The default title is set to empty;
     *
     * @param dialogType The dialog type to be created
     * @param headerColorStyle
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, HeaderColorStyle headerColorStyle, 
            String header, String details) {
        this(dialogType, DialogStyle.NATIVE, "", header, headerColorStyle, 
                details, null);
    }

    /**
     * Construct a dialog with optional dialog style. The type of dialog to be
     * created is determine by the dialogType parameter. The default title is
     * set to empty;
     *
     * @param dialogType The dialog type to be created
     * @param dialogStyle The dialog style to be created
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, DialogStyle dialogStyle,
            String header, String details) {
        this(dialogType, dialogStyle, "", header, details, null);
    }

    /**
     * Construct a dialog with optional dialog style. The type of dialog to be
     * created is determine by the dialogType parameter.
     *
     * @param dialogType The dialog type to be created
     * @param dialogStyle The dialog style to be created
     * @param title The window title of the dialog
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, DialogStyle dialogStyle, String title,
            String header, String details) {
        this(dialogType, dialogStyle, title, header, details, null);
    }

    /**
     * Construct a dialog using the default "native" dialog style. The type of
     * dialog to be created is determine by the dialogType parameter.
     *
     * @param dialogType The dialog type to be created
     * @param title The window title of the dialog
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, String title, String header,
            String details) {
        this(dialogType, DialogStyle.NATIVE, title, header, details, null);
    }

    /**
     * Construct an exception dialog using the default "native" dialog style.
     * The header is automatically set to the default exception header label
     * text with the title empty.
     *
     * @param exception An exception object to be displayed
     */
    public Dialog(Exception exception) {
        this(DialogStyle.NATIVE, exception);
    }

    /**
     * Construct an exception dialog using the default "native" dialog style.
     * The header is automatically set to the default exception header label
     * text with the title given.
     *
     * @param title The window title of the dialog
     * @param exception An exception object to be displayed
     */
    public Dialog(String title, Exception exception) {
        this(DialogStyle.NATIVE, title, exception);
    }

    /**
     * Construct an exception dialog with optional dialog style. The header is
     * automatically set to the default exception header label text with the
     * title empty. The details label is set to the class name of the exception
     * object.
     *
     * @param dialogStyle The dialog style to be created
     * @param exception An exception object to be displayed
     */
    public Dialog(DialogStyle dialogStyle, Exception exception) {
        this(dialogStyle, "", exception);
    }

    /**
     * Construct an exception dialog with optional dialog style. The header is
     * automatically set to the default exception header label text with the
     * title given. The details label is set to the class name of the exception
     * object.
     *
     * @param dialogStyle The dialog style to be created
     * @param title The window title of the dialog
     * @param exception An exception object to be displayed
     */
    public Dialog(DialogStyle dialogStyle, String title, Exception exception) {
        this(DialogType.EXCEPTION, dialogStyle, title,
                DialogText.EXCEPTION_HEADER.getText(),
                exception.getClass().getName(),
                exception);
    }

    /**
     * Construct a dialog with default color style for the header label.
     * <p>
     * Note: Using exception dialog will overwrite the details message with the
     * exception's name and null exception parameter will result to pre-built 
     * error text in exception dialog's header, details and trace texts.
     *
     * @param dialogType The type of dialog to build
     * @param dialogStyle The dialog style to be created
     * @param title The dialog window title
     * @param header The text for the colored header label
     * @param details The text for the message details label
     * @param exception An exception object to be displayed
     */
    public Dialog(DialogType dialogType, DialogStyle dialogStyle,
            String title, String header, String details, Exception exception) {
        this(dialogType, dialogStyle, title, header, HeaderColorStyle.DEFAULT,
                details, exception);
    }

    /**
     * Construct a dialog with all parameters given. Allows full explicit
     * customization for dialog building.
     * <p>
     * Note: Using exception dialog will overwrite the details message with the
     * exception's name and null exception parameter will result to pre-built 
     * error text in exception dialog's header, details and trace texts.
     *
     * @param dialogType The type of dialog to build
     * @param dialogStyle The dialog style to be created
     * @param title The dialog window title
     * @param header The text for the colored header label
     * @param headerColorStyle The chosen color style for the header
     * @param details The text for the message details label
     * @param exception An exception object to be displayed
     */
    public Dialog(DialogType dialogType, DialogStyle dialogStyle,
            String title, String header, HeaderColorStyle headerColorStyle,
            String details, Exception exception) {
        this.isLoadingError = false;
        setTitle(title);
        
        this.headerColorStyle = headerColorStyle;
        this.dialogType = dialogType;
        this.exception = exception;

        // Filter behaviour for exception dialog
        if (dialogType == DialogType.EXCEPTION) {
            if (this.exception != null) {
                this.header = header;
                this.details = this.exception.getClass().getName();
            } else {
                this.header = DialogText.NO_EXCEPTION_HEADER.getText();
                this.details = DialogText.NO_EXCEPTION_DETAILS.getText();
            }
        } else {
            this.header = header;
            this.details = details;
        }

        // Default value for the text field
        this.textEntry = "";

        // Default dialog action response
        this.response = DialogResponse.NO_RESPONSE;

        switch (dialogType) {
            case INFORMATION:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.INFO_DIALOG.getPath()));

                break;

            case CONFIRMATION:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.CONFIRMATION_DIALOG.getPath()));
                break;

            case WARNING:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.WARNING_DIALOG.getPath()));
                break;

            case ERROR:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.ERROR_DIALOG.getPath()));
                break;

            case EXCEPTION:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.EXCEPTION_DIALOG.getPath()));
                break;

            case INPUT_TEXT:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.INPUT_TEXT_DIALOG.getPath()));
                break;

            case GENERIC_OK:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.GENERIC_OK_DIALOG.getPath()));
                break;

            case GENERIC_OK_CANCEL:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.GENERIC_OK_CANCEL_DIALOG.getPath()));
                break;

            case GENERIC_YES_NO:
                fxmlLoader = new FXMLLoader(getClass()
                        .getResource(Fxml.GENERIC_YES_NO_DIALOG.getPath()));
                break;
        }

        fxmlLoader.setController(this);

        try {
            this.scene = new Scene((Parent) fxmlLoader.load());
            setScene(scene);
            centerOnScreen();

            if (dialogStyle == DialogStyle.UNDECORATED) {
                getScene().setFill(Color.TRANSPARENT);
                initStyle(StageStyle.TRANSPARENT);
            }

            setResizable(false);

            // Apply CLOSE action upon pressing x button
            setOnCloseRequest(new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent event) {
                    response = DialogResponse.CLOSE;
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Dialog.class.getName()).log(Level.SEVERE, null, ex);
            this.isLoadingError = true;
            
            
        }

    }

    /**
     * Initializes the dialog. Set default focus to OK button. Wrap the text for
     * details message label and apply the user-defined header and details.
     *
     * @param location The location used to resolve relative paths for the root
     * object, or null if the location is not known
     * @param resources The resources used to localize the root object, or null
     * if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.isLoadingError) {
            close();
            return;
        }
        
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

                    case EXCEPTION:
                        okButton.requestFocus();
                        break;

                    case INPUT_TEXT:
                        sendButton.requestFocus();
                        break;

                    case GENERIC_OK:
                        okButton.requestFocus();
                        break;

                    case GENERIC_OK_CANCEL:
                        okButton.requestFocus();
                        break;

                    case GENERIC_YES_NO:
                        yesButton.requestFocus();
                        break;
                }

            }
        });

        this.detailsLabel.setWrapText(true);

        this.headerLabel.setText(getHeader());
        this.detailsLabel.setText(getDetails());

        // Filter behaviour for exception dialog
        if (dialogType == DialogType.EXCEPTION) {
            this.exceptionArea.clear();
            
            if (this.exception != null) {
                this.exceptionArea.appendText(
                        Arrays.toString(this.exception.getStackTrace()));
            } else {
                this.exceptionArea.appendText(
                        DialogText.NO_EXCEPTION_TRACE.getText());
            }

            this.exceptionArea.setWrapText(true);
            this.exceptionArea.setEditable(false);
        }

        // Apply Header CSS style color
        this.applyHeaderColorStyle(this.headerColorStyle);
    }

    private void applyHeaderColorStyle(HeaderColorStyle headerColorStyle) {
        if (!headerColorStyle.getColorStyle().isEmpty()) {
            this.getHeaderLabel().setStyle(headerColorStyle.getColorStyle());
        }
        
    }

    /**
     * Sets the response to the given response parameter.
     *
     * @param response A <code>DialogResponse</code> object pass as an argument
     */
    private void setResponse(DialogResponse response) {
        this.response = response;

    }

    /**
     * Retrieve a response.
     *
     * @return A DialogResponse object pass as an argument
     */
    public final DialogResponse getResponse() {
        return this.response;
    }

    /**
     * Retrieve the message details text.
     *
     * @return A <code>String</code> object pertaining to the message details
     */
    public final String getDetails() {
        return this.details;
    }

    /**
     * Retrieve the header text.
     *
     * @return A <code>String</code> object pertaining to the header
     */
    public final String getHeader() {
        return this.header;
    }

    /**
     * Retrieve the header's JavaFX CSS background color style
     *
     * @return A <code>HeaderColorStyle</code> option containing a color scheme.
     */
    public final HeaderColorStyle getHeaderColorStyle() {
        return this.headerColorStyle;
    }

    /**
     * Apply different JavaFX CSS background color style for the header label
     *
     * @param headerColorStyle A <code>HeaderColorStyle</code> option containing
     * a color scheme.
     */
    public final void setHeaderColorStyle(HeaderColorStyle headerColorStyle) {
        this.headerColorStyle = headerColorStyle;
        this.applyHeaderColorStyle(headerColorStyle);
    }

    /**
     * Apply custom JavaFX CSS background color style on header label. Improper
     * JavaFX CSS declaration will result to nothing.
     *
     * @param colorStyle A JavaFX CSS style declaration in <code>String</code>
     * form.
     */
    public final void setCustomHeaderColorStyle(String colorStyle) {
        this.headerColorStyle = HeaderColorStyle.GLOSS_CUSTOM;
        this.getHeaderLabel().setStyle(colorStyle);
    }

    /**
     * Allows to change both font sizes for the header and the details label
     * with a single font size <code>integer</code> parameter given.
     *
     * @param font_size Font size in pixels for both header and details labels
     * in pixels
     */
    public void setFontSize(int font_size) {
        setFontSize(font_size, font_size);
    }

    /**
     * Allows to change both font sizes for the header and the details label
     * with two font sizes <code>integer</code> parameters given.
     *
     * @param header_font_size The header font size in pixels
     * @param details_font_size The details font size in pixels
     */
    public void setFontSize(int header_font_size, int details_font_size) {
        this.headerLabel
                .setStyle("-fx-font-size:" + Integer.toString(header_font_size) + "px;");
        this.detailsLabel
                .setStyle("-fx-font-size:" + Integer.toString(details_font_size) + "px;");
    }

    /**
     * Allows to change both font families for the header and the details label
     * with a single font family <code>String</code> parameter given.
     *
     * @param font_family Font family for both header and details labels in
     * <code>Strings</code>
     */
    public void setFontFamily(String font_family) {
        setFontFamily(font_family, font_family);
    }

    /**
     * Allows to change both font families for the header and the details label
     * with two font families <code>String</code> parameters given.
     *
     * @param header_font_family The header font family in <code>Strings</code>
     * @param details_font_family The details font family in
     * <code>Strings</code>
     */
    public void setFontFamily(String header_font_family, String details_font_family) {
        this.headerLabel
                .setStyle("-fx-font-family: \"" + header_font_family + "\";");
        this.detailsLabel
                .setStyle("-fx-font-family: \"" + details_font_family + "\";");
    }

    /**
     * Allows to change the font sizes and the font families for the header and
     * details label with a single font family and a single font size.
     *
     * @param font_family The font family for header and details labels in
     * <code>Strings</code>
     * @param font_size The font size for header and details labels in
     * <code>Strings</code>
     */
    public void setFont(String font_family, int font_size) {
        setFont(font_family, font_size, font_family, font_size);
    }

    /**
     * Allows to change the font sizes and the font families for the header and
     * details label.
     *
     * @param header_font_family The header font family in <code>Strings</code>
     * @param header_font_size The header font size in pixels
     * @param details_font_family The details font family in
     * <code>Strings</code>
     * @param details_font_size The details font size in pixels
     */
    public void setFont(String header_font_family, int header_font_size,
            String details_font_family, int details_font_size) {
        this.headerLabel
                .setStyle("-fx-font-family: \"" + header_font_family + "\";"
                        + "-fx-font-size:" + Integer.toString(header_font_size) + "px;");
        this.detailsLabel
                .setStyle("-fx-font-family: \"" + details_font_family + "\";"
                        + "-fx-font-size:" + Integer.toString(details_font_size) + "px;");

    }

    /**
     * Retrieve the header label object. Allows user to customize FX label
     * object.
     *
     * @return HeaderLabel object
     */
    public final Label getHeaderLabel() {
        return headerLabel;
    }

    /**
     * Retrieve the details label object. Allows user to customize FX label
     * object.
     *
     * @return DetailsLabel object
     */
    public final Label getDetailsLabel() {
        return detailsLabel;
    }

    /**
     * Retrieve the <code>TextArea</code> object for the exception area. Allows
     * user to customize FX <code>TextArea</code> object.
     *
     * @return TextArea object
     */
    public final TextArea getExceptionArea() {
        return exceptionArea;
    }

    /**
     * Retrieve the exception object, if the dialog does not hold an exception,
     * return null.
     *
     * @return The <code>Exception</code> object
     */
    public final Exception getException() {
        return exception;
    }

    /**
     * Retrieve user input text from the Input Text Dialog, if no text is given
     * or a different dialog is used, then return string value is empty as the
     * default value. Return value is null if the created is not an input
     * dialog.
     *
     * @return The string input text entered from the Input Text Dialog
     */
    public final String getTextEntry() {
        return textEntry;
    }

    /**
     * Retrieve the <code>TextField</code> object. Allows user to customize FX
     * <code>TextField</code> object. This is only for input's text field
     * dialog. Returns null if the dialog created is not an input dialog.
     *
     * @return The <code>TextField</code> object
     */
    public final TextField getTextField() {
        return inputTextField;
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

    /**
     * Event handler when cancelButton is pressed. Sets response to CANCEl and
     * closes the dialog window.
     *
     * @param event Action event object
     */
    @FXML
    private void cancel_btn_on_click(ActionEvent event) {
        setResponse(DialogResponse.CANCEL);
        close();
    }

    /**
     * Event handler when sendButton is pressed. Sets response to SEND and
     * closes the dialog window.
     *
     * @param event Action event object
     */
    @FXML
    private void send_btn_on_click(ActionEvent event) {
        // Future proof for other uses of send event handler
        if (this.dialogType == DialogType.INPUT_TEXT) {
            this.textEntry = this.inputTextField.getText();
        }

        setResponse(DialogResponse.SEND);
        close();
    }
}
