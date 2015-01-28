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
import com.github.daytron.simpledialogfx.data.HeaderColorStyle;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * The controller class for building any derivatives of dialogs.
 *
 * @author Ryan Gilera
 */
public class Dialog extends Stage implements Initializable {

    @FXML
    private VBox topBoxContainer;
    @FXML
    private StackPane headContainer;
    @FXML
    private StackPane bodyContainer;
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
    private final DialogStyle dialogStyle;
    private final Exception exception;

    private String textEntry;
    private HeaderColorStyle headerColorStyle;
    private boolean isLoadingError;

    /**
     * Constructs a dialog with specified DialogType, header text and details
     * text.
     * <p>
     * Note: Using an exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. Since there is no exception given (will yield to
     * null), it will result to pre-built error texts in exception dialog's
     * header, details and trace messages.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogStyle is set to NATIVE</li>
     * <li>Title is set to an empty <code>String</code></li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * <li>Exception object is set to NULL</li>
     * </ul>
     *
     * @param dialogType The dialog type to be created
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, String header, String details) {
        this(dialogType, DialogStyle.NATIVE, "", header, details, null);
    }

    /**
     * Constructs a dialog with specified DialogType, HeaderColorStyle, header
     * text and details text.
     * <p>
     * Note: Using an exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. Since there is no exception given (will yield to
     * null), it will result to pre-built error texts in exception dialog's
     * header, details and trace messages.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogStyle is set to NATIVE</li>
     * <li>Title is set to an empty <code>String</code></li>
     * <li>Exception object is set to NULL</li>
     * </ul>
     *
     * @param dialogType The dialog type to be created
     * @param headerColorStyle The chosen color style for the header
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, HeaderColorStyle headerColorStyle,
            String header, String details) {
        this(dialogType, DialogStyle.NATIVE, "", header, headerColorStyle,
                details, null);
    }

    /**
     * Constructs a dialog with specified DialogType, HeaderColorStyle, title,
     * header text and details text.
     * <p>
     * Note: Using an exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. Since there is no exception given (will yield to
     * null), it will result to pre-built error texts in exception dialog's
     * header, details and trace messages.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogStyle is set to NATIVE</li>
     * <li>Exception object is set to NULL</li>
     * </ul>
     *
     * @param dialogType The dialog type to be created
     * @param headerColorStyle The chosen color style for the header
     * @param title The window title of the dialog
     * @param header The text for the colored header label
     * @param details The text for the message details label
     */
    public Dialog(DialogType dialogType, HeaderColorStyle headerColorStyle,
            String title, String header, String details) {
        this(dialogType, DialogStyle.NATIVE, title, header, headerColorStyle,
                details, null);
    }

    /**
     * Constructs a dialog with specified DialogType, DialogStyle, header text
     * and details text.
     * <p>
     * Note: Using an exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. Since there is no exception given (will yield to
     * null), it will result to pre-built error texts in exception dialog's
     * header, details and trace messages.
     * <p>
     * Default values:
     * <ul>
     * <li>Title is set to an empty <code>String</code></li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * <li>Exception object is set to NULL</li>
     * </ul>
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
     * Constructs a dialog with specified DialogType, DialogStyle, title, header
     * text and details text.
     * <p>
     * Note: Using an exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. Since there is no exception given (will yield to
     * null), it will result to pre-built error texts in exception dialog's
     * header, details and trace messages.
     * <p>
     * Default values:
     * <ul>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * <li>Exception object is set to NULL</li>
     * </ul>
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
     * Constructs a dialog with specified DialogType, title, header text and
     * details text.
     * <p>
     * Note: Using an exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. Since there is no exception given (will yield to
     * null), it will result to pre-built error texts in exception dialog's
     * header, details and trace messages.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogStyle is set to NATIVE</li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * <li>Exception object is set to NULL</li>
     * </ul>
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
     * Constructs an exception dialog with a specified Exception object.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogType is set to EXCEPTION</li>
     * <li>DialogStyle is set to NATIVE</li>
     * <li>Title is set to an empty <code>String</code></li>
     * <li>Header text is set to a pre-built exception message from
     * <code>DialogText.EXCEPTION_HEADER</code></li>
     * <li>Details text is set to the Exception object's class name</li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * </ul>
     *
     * @param exception An exception object to be displayed
     */
    public Dialog(Exception exception) {
        this(DialogStyle.NATIVE, exception);
    }

    /**
     * Constructs an exception dialog with specified title and an Exception
     * object.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogType is set to EXCEPTION</li>
     * <li>DialogStyle is set to NATIVE</li>
     * <li>Header text is set to a pre-built exception message from
     * <code>DialogText.EXCEPTION_HEADER</code></li>
     * <li>Details text is set to the Exception object's class name</li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * </ul>
     *
     * @param title The window title of the dialog
     * @param exception An exception object to be displayed
     */
    public Dialog(String title, Exception exception) {
        this(DialogStyle.NATIVE, title, exception);
    }

    /**
     * Constructs an exception dialog with specified DialogStyle and an
     * Exception object.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogType is set to EXCEPTION</li>
     * <li>Title is set to an empty <code>String</code></li>
     * <li>Header text is set to a pre-built exception message from
     * <code>DialogText.EXCEPTION_HEADER</code></li>
     * <li>Details text is set to the Exception object's class name</li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * </ul>
     *
     * @param dialogStyle The dialog style to be created
     * @param exception An exception object to be displayed
     */
    public Dialog(DialogStyle dialogStyle, Exception exception) {
        this(dialogStyle, "", exception);
    }

    /**
     * Constructs an exception dialog with specified DialogStyle, title and an
     * Exception object.
     * <p>
     * Default values:
     * <ul>
     * <li>DialogType is set to EXCEPTION</li>
     * <li>Header text is set to a pre-built exception message from
     * <code>DialogText.EXCEPTION_HEADER</code></li>
     * <li>Details text is set to the Exception object's class name</li>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * </ul>
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
     * Constructs a dialog with specified DialogType, DialogStyle, title, header
     * text, details text and exception object.
     * <p>
     * Note: Using exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. If the given exception object is
     * <code>NULL</code> , it will result to pre-built error texts in exception
     * dialog's header, details and trace texts.
     * <p>
     * Exception object is ignored, using any other dialog types other than
     * Exception dialog with a non-null exception object given.
     * <p>
     * Default values:
     * <ul>
     * <li>HeaderColorStyle is set to DEFAULT</li>
     * </ul>
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
     * Constructs a dialog using all possible parameters. Allows full explicit
     * customization for dialog building with specified DialogType, DialogStyle,
     * title, header text, HeaderColorStyle, details text and exception object.
     * <p>
     * Note: Using exception dialog will overwrite the header's and details'
     * texts with predefined exception header message and Exception object's
     * class name respectively. If the given exception object is
     * <code>NULL</code> , it will result to pre-built error texts in exception
     * dialog's header, details and trace texts.
     * <p>
     * Exception object is ignored, using any other dialog types other than
     * Exception dialog with a non-null exception object given.
     * <p>
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
        this.dialogStyle = dialogStyle;

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

        try {
            this.fxmlLoader = new FXMLLoader(getClass()
                    .getResource(dialogType.getPath()));
            this.fxmlLoader.setController(this);

            this.scene = new Scene((Parent) fxmlLoader.load());
            setScene(scene);
            centerOnScreen();

            if (dialogStyle == DialogStyle.UNDECORATED) {
                //getScene().setFill(Color.TRANSPARENT);
                //initStyle(StageStyle.TRANSPARENT);
                initStyle(StageStyle.UNDECORATED);
            }

            setResizable(false);

            // Apply CLOSE action upon pressing x button
            setOnCloseRequest(new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent event) {
                    response = DialogResponse.CLOSE;
                }
            });
        } catch (Exception ex) {
            this.isLoadingError = true;
            Logger.getLogger(Dialog.class.getName()).log(Level.SEVERE,
                    DialogText.CAUGHT_EXCEPTION_LOG_MSG.getText(), ex);
        }

    }

    /**
     * Initializes the dialog. Sets default focus to OK button. Wraps the text
     * for details message label and apply the user-defined header and details.
     * Filter the behavior for the exception dialog for a null and non-null
     * exception object given. Applies corresponding header background css
     * style.
     *
     * @param location The location used to resolve relative paths for the root
     * object, or null if the location is not known
     * @param resources The resources used to localize the root object, or null
     * if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add an event handler to automatically close the stage in the event of 
        // any exception encountered.
        addEventHandler(WindowEvent.ANY, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent window) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (isLoadingError) {
                            close();
                        }
                    }
                });
            }
        });

        // Set default focus to the appropriate UI component
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        switch (dialogType) {
                            case INFORMATION:
                                okButton.requestFocus();
                                break;

                            case CONFIRMATION:
                                yesButton.requestFocus();
                                break;

                            case CONFIRMATION_ALT1:
                                okButton.requestFocus();
                                break;

                            case CONFIRMATION_ALT2:
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
                                inputTextField.requestFocus();
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

                            case GENERIC_YES_NO_CANCEL:
                                yesButton.requestFocus();
                                break;
                        }

                    }
                }
        );

        this.detailsLabel.setWrapText(
                true);

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

        // Filter whether it headless or not
        if (this.dialogStyle == DialogStyle.HEADLESS) {
            this.topBoxContainer.getChildren().remove(this.headContainer);
            this.setHeadlessPadding();
        }

            // Apply Header CSS style color
        this.setHeaderColorStyle(
                this.headerColorStyle);
    }

    /**
     * Sets the padding for a headless dialog
     */
    private void setHeadlessPadding() {
        if (dialogType == DialogType.INPUT_TEXT) {
            bodyContainer.setStyle(
                    PreDefinedStyle.INPUT_DIALOG_HEADLESS_PADDING.getStyle());

        } else if (dialogType == DialogType.EXCEPTION) {
            bodyContainer.setStyle(
                    PreDefinedStyle.EXCEPTION_DIALOG_HEADLESS_PADDING.getStyle());
        } else {
            bodyContainer.setStyle(
                    PreDefinedStyle.HEADLESS_PADDING.getStyle());
        }
    }

    /**
     * Applies a predefined JavaFX CSS background color style for the header
     * label
     *
     * @param headerColorStyle A <code>HeaderColorStyle</code> option containing
     * a color scheme.
     */
    public final void setHeaderColorStyle(HeaderColorStyle headerColorStyle) {
        this.headerColorStyle = headerColorStyle;

        if (!headerColorStyle.getColorStyle().isEmpty()) {
            this.getHeaderLabel().setStyle(headerColorStyle.getColorStyle());

            // It's either DEFAULT or CUSTOM value (all empty values)
            // If it is DEFAULT, it sets the default style color
            // Otherwise if it is CUSTOM, by default no style is applied 
            // (default css "generic" color is in play), user has
            // to manually set it via setCustomHeaderColorStyle(String colorStyle)
        } else {
            if (headerColorStyle == HeaderColorStyle.DEFAULT) {
                switch (this.dialogType) {
                    case INFORMATION:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_INFO);
                        break;
                    case ERROR:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_ERROR);
                        break;
                    case WARNING:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_WARNING);
                        break;
                    case CONFIRMATION:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_CONFIRM);
                        break;
                    case CONFIRMATION_ALT1:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_CONFIRM);
                        break;
                    case CONFIRMATION_ALT2:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_CONFIRM);
                        break;
                    case EXCEPTION:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_EXCEPTION);
                        break;
                    case INPUT_TEXT:
                        this.updateHeaderColorStyle(HeaderColorStyle.GLOSS_INPUT);
                        break;
                    default:
                        this.updateHeaderColorStyle(HeaderColorStyle.GENERIC);
                        break;
                }
            }
        }

    }

    private void updateHeaderColorStyle(HeaderColorStyle headerColorStyle) {
        this.headerColorStyle = headerColorStyle;
        this.getHeaderLabel().setStyle(headerColorStyle.getColorStyle());
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
     * Retrieves the dialog's response.
     *
     * @return A DialogResponse object pass as an argument
     */
    public final DialogResponse getResponse() {
        return this.response;
    }

    /**
     * Retrieves the message details text.
     *
     * @return A <code>String</code> object pertaining to the message details
     */
    public final String getDetails() {
        return this.details;
    }

    /**
     * Retrieves the header text.
     *
     * @return A <code>String</code> object pertaining to the header
     */
    public final String getHeader() {
        return this.header;
    }

    /**
     * Retrieves the header's JavaFX CSS background color style
     *
     * @return A <code>HeaderColorStyle</code> option containing a color scheme.
     */
    public final HeaderColorStyle getHeaderColorStyle() {
        return this.headerColorStyle;
    }

    /**
     * Applies custom JavaFX CSS background color style on header label.
     * Improper JavaFX CSS declaration will result to nothing.
     *
     * @param colorStyle A JavaFX CSS style declaration in <code>String</code>
     * format.
     */
    public final void setCustomHeaderColorStyle(String colorStyle) {
        this.headerColorStyle = HeaderColorStyle.CUSTOM;
        this.getHeaderLabel().setStyle(colorStyle);
    }

    /**
     * Sets both font sizes in pixels for the header and the details label with
     * a single font size <code>integer</code> parameter given.
     *
     * @param font_size Font size in pixels for both header and details labels
     * in pixels
     */
    public void setFontSize(int font_size) {
        setFontSize(font_size, font_size);
    }

    /**
     * Sets both font sizes in pixels for the header and the details label with
     * two font sizes <code>integer</code> parameters given.
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
     * Sets header label's font size in pixels
     *
     * @param font_size Header label font size
     */
    public void setHeaderFontSize(int font_size) {
        this.headerLabel
                .setStyle("-fx-font-size:" + Integer.toString(font_size) + "px;");
    }

    /**
     * Sets details label's font size in pixels
     *
     * @param font_size Details label font size
     */
    public void setDetailsFontSize(int font_size) {
        this.detailsLabel
                .setStyle("-fx-font-size:" + Integer.toString(font_size) + "px;");
    }

    /**
     * Sets both font families for the header and the details label with a
     * single font family <code>String</code> parameter given.
     *
     * @param font_family Font family for both header and details labels in
     * <code>Strings</code>
     */
    public void setFontFamily(String font_family) {
        setFontFamily(font_family, font_family);
    }

    /**
     * Sets both font families for the header and the details label with two
     * font families <code>String</code> parameters given.
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
     * Sets header label's font family using local machine fonts.
     *
     * @param font_family Font family in <code>Strings</code>
     */
    public void setHeaderFontFamily(String font_family) {
        this.headerLabel
                .setStyle("-fx-font-family: \"" + font_family + "\";");
    }

    /**
     * Sets details label's font family using local machine fonts.
     *
     * @param font_family Font family in <code>Strings</code>
     */
    public void setDetailsFontFamily(String font_family) {
        this.detailsLabel
                .setStyle("-fx-font-family: \"" + font_family + "\";");
    }

    /**
     * Sets the font sizes and the font families for the header and details
     * label with a single font family and a single font size.
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
     * Sets the font sizes and the font families for the header and details
     * label.
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
     * Sets both header label's font family and size.
     *
     * @param font_family Font family in <code>Strings</code>
     * @param font_size Font size in <code>integer</code> (pixels)
     */
    public void setHeaderFont(String font_family, int font_size) {
        this.headerLabel
                .setStyle("-fx-font-family: \"" + font_family + "\";"
                        + "-fx-font-size:" + Integer.toString(font_size) + "px;");
    }

    /**
     * Sets both details label's font family and size.
     *
     * @param font_family Font family in <code>Strings</code>
     * @param font_size Font size in <code>integer</code> (pixels)
     */
    public void setDetailsFont(String font_family, int font_size) {
        this.detailsLabel
                .setStyle("-fx-font-family: \"" + font_family + "\";"
                        + "-fx-font-size:" + Integer.toString(font_size) + "px;");
    }

    /**
     * Retrieves the header label object. Allows user to customize FX label
     * object.
     *
     * @return HeaderLabel object
     */
    public final Label getHeaderLabel() {
        return headerLabel;
    }

    /**
     * Retrieves the details label object. Allows user to customize FX label
     * object.
     *
     * @return DetailsLabel object
     */
    public final Label getDetailsLabel() {
        return detailsLabel;
    }

    /**
     * Retrieves the <code>TextArea</code> object for the exception area. Allows
     * user to customize FX <code>TextArea</code> object.
     *
     * @return TextArea object
     */
    public final TextArea getExceptionArea() {
        return exceptionArea;
    }

    /**
     * Retrieves the exception object, if the dialog does not hold an exception,
     * return null.
     *
     * @return The <code>Exception</code> object
     */
    public final Exception getException() {
        return exception;
    }

    /**
     * Retrieves user input text from the Input Text Dialog, if no text is given
     * or a different dialog is used, then return string value is empty as the
     * default value. Returns an empty <code>String</code> if the dialog created
     * is not an input dialog.
     *
     * @return The string input text entered from the Input Text Dialog
     */
    public final String getTextEntry() {
        return textEntry;
    }

    /**
     * Retrieves the <code>TextField</code> object. Allows user to customize FX
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
