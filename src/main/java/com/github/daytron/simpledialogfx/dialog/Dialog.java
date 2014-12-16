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
import javafx.stage.Stage;

/**
 * The parent class for any derivatives of Dialog
 *
 * @author Ryan Gilera
 */
class Dialog extends Stage {

    // Top head label

    private final String header;
    // Details label
    private final String details;
    // Response chosen by the user
    private DialogResponse response;

    /**
     * Accepts two <code>String</code> parameters for the constructor.
     *
     * @param header The text inside the colored header
     * @param details The text for message details
     */
    protected Dialog(String header, String details) {
        this.header = header;
        this.details = details;

        // Default response
        this.response = DialogResponse.NO_RESPONSE;
    }

    /**
     * Sets the response to the given response parameter.
     *
     * @param response A DialogResponse object pass as an argument
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

}
