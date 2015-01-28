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
package com.github.daytron.simpledialogfx.data;

/**
 * List of predefined texts for the library.
 *
 * @author Ryan Gilera
 */
public enum DialogText {

    /**
     * Confirmation Dialog window title
     */
    CONFIRMATION_TITLE("Confirmation Dialog"),
    /**
     * Confirmation Dialog header label
     */
    CONFIRMATION_HEADER("Confirmation"),
    /**
     * Error Dialog window title
     */
    ERROR_TITLE("Error Dialog"),
    /**
     * Error Dialog header label
     */
    ERROR_HEADER("Error"),
    /**
     * Information Dialog window title
     */
    INFO_TITLE("Information Dialog"),
    /**
     * Information Dialog header label
     */
    INFO_HEADER("Information"),
    /**
     * Warning Dialog window title
     */
    WARNING_TITLE("Warning Dialog"),
    /**
     * Warning Dialog header label
     */
    WARNING_HEADER("Warning"),
    /**
     * Exception Dialog window title
     */
    EXCEPTION_TITLE("Exception Dialog"),
    /**
     * Exception Dialog header label
     */
    EXCEPTION_HEADER("Exception Encountered"),
    /**
     * Input Text Dialog window title
     */
    INPUT_TEXT_TITLE("Input Text Dialog"),
    /**
     * Input Text Dialog header label
     */
    INPUT_TEXT_HEADER("Enter a text"),
    /**
     * No exception header message if the exception parameter in the constructor
     * is null
     */
    NO_EXCEPTION_HEADER("No Exception Found"),
    /**
     * No exception details message if the exception parameter in the
     * constructor is null
     */
    NO_EXCEPTION_DETAILS("Exception parameter given is null."),
    /**
     * No exception trace message if the exception parameter in the constructor
     * is null
     */
    NO_EXCEPTION_TRACE("No trace found."),
    /**
     * Log exception message printed on the console whenever an exception is
     * encountered
     */
    CAUGHT_EXCEPTION_LOG_MSG("Unable to build dialog. Exception encountered.");

    private final String text;

    private DialogText(String text) {
        this.text = text;
    }

    /**
     * Retrieve text value
     *
     * @return The <code>String</code> object as the text.
     */
    public String getText() {
        return text;
    }

}
