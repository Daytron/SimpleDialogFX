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

/**
 * List of dialog types and their corresponding Fxml file path
 *
 * @author Ryan Gilera
 */
public enum DialogType {

    /**
     * Confirmation dialog
     */
    CONFIRMATION("/fxml/YesNoDialog.fxml"),
    /**
     * Confirmation dialog
     */
    CONFIRMATION_ALT1("/fxml/OkCancelDialog.fxml"),
    /**
     * Confirmation dialog
     */
    CONFIRMATION_ALT2("/fxml/YesNoCancelDialog.fxml"),
    /**
     * Information dialog
     */
    INFORMATION("/fxml/OkDialog.fxml"),
    /**
     * Warning dialog
     */
    WARNING("/fxml/OkDialog.fxml"),
    /**
     * Error dialog
     */
    ERROR("/fxml/OkDialog.fxml"),
    /**
     * Exception dialog
     */
    EXCEPTION("/fxml/ExceptionDialog.fxml"),
    /**
     * Input text dialog
     */
    INPUT_TEXT("/fxml/InputTextDialog.fxml"),
    /**
     * Generic OK dialog
     */
    GENERIC_OK("/fxml/OkDialog.fxml"),
    /**
     * Generic OK and CANCEL dialog
     */
    GENERIC_OK_CANCEL("/fxml/OkCancelDialog.fxml"),
    /**
     * Generic YES and NO dialog
     */
    GENERIC_YES_NO("/fxml/YesNoDialog.fxml");
    
    private final String path;

    private DialogType(String msg) {
        this.path = msg;
    }

    /**
     * Retrieve the FXML file path
     *
     * @return The <code>String</code> object as file path
     */
    protected String getPath() {
        return path;
    }
}
