/*
 * The MIT License
 *
 * Copyright 2015 Ryan Gilera.
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
 * List of predefined CSS style.
 *
 * @author Ryan Gilera
 */
enum PreDefinedStyle {

    INPUT_DIALOG_HEADLESS_PADDING("-fx-padding: 20 10 15 10;"),
    
    EXCEPTION_DIALOG_HEADLESS_PADDING("-fx-padding: 20 10 20 10;"),
    
    HEADLESS_PADDING("-fx-padding: 20 10 15 25;");

    private final String style;

    private PreDefinedStyle(String style) {
        this.style = style;
    }

    /**
     * Retrieve the FXML file style
     *
     * @return The <code>String</code> object as file style
     */
    protected String getStyle() {
        return style;
    }
}
