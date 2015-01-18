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
package com.github.daytron.simpledialogfx.data;

/**
 * List of pre-built CSS color styles for the dialog's header label
 *
 * @author Ryan Gilera
 */
public enum HeaderColorStyle {

    /**
     * If no color is selected, this will be the default value, default CSS
     * styles will be used instead
     */
    DEFAULT(""),
    /**
     * The default color style for Error dialog (red)
     */
    GLOSS_ERROR("-fx-background-color: linear-gradient(to bottom, #FFA3A5 0%, #FA9294 44%, #F37B7D 100% );"),
    /**
     * The default color style for information dialog (blue)
     */
    GLOSS_INFO("-fx-background-color: linear-gradient(to bottom, #A3FFCE 0%, #92FAC3 44%, #7BF3B3 100% );"),
    /**
     * The default color style for warning dialog (orange)
     */
    GLOSS_WARNING("-fx-background-color: linear-gradient(to bottom, #FFD1A3 0%, #FAC692 44%, #F3B77B 100% );"),
    /**
     * The default color style for confirmation dialog (green)
     */
    GLOSS_CONFIRM("-fx-background-color: linear-gradient(to bottom, #A3FFCE 0%, #92FAC3 44%, #7BF3B3 100% );"),
    /**
     * The default color style for input dialog (yellow)
     */
    GLOSS_INPUT("-fx-background-color: linear-gradient(to bottom, #F9FFA3 0%, #F3FA92 44%, #EBF37B 100% );"),
    /**
     * The default color style for exception dialog (pink)
     */
    GLOSS_EXCEPTION("-fx-background-color: linear-gradient(to bottom, #E2A3FF 0%, #D992FA 44%, #CD7BF3 100% );"),
    /**
     * The default color style for a generic dialog (gray)
     */
    GLOSS_GENERIC("-fx-background-color: rgb(216, 222, 227);"),
    /**
     * This value is selected whenever the user apply their own color style
     */
    GLOSS_CUSTOM("");

    private final String colorStyle;

    private HeaderColorStyle(String colorStyle) {
        this.colorStyle = colorStyle;
    }

    /**
     * Retrieve color style value
     *
     * @return The <code>String</code> object as the text.
     */
    public String getColorStyle() {
        return colorStyle;
    }

}
