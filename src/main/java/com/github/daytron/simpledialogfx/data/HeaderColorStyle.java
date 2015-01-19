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
    GLOSS_CUSTOM(""),
    
    GLOSS_ROYALBLUE("-fx-background-color: linear-gradient(to bottom, rgba(123,149,255,1) 0%,rgba(94,125,250,1) 44%,rgba(59,96,243,1) 100%);"),
    GLOSS_ELECTRICVIOLET("-fx-background-color: linear-gradient(to bottom, rgba(191,123,255,1) 0%,rgba(175,94,250,1) 44%,rgba(154,59,243,1) 100%);"),
    GLOSS_BRILLIANTROSE("-fx-background-color: linear-gradient(to bottom, rgba(255,123,200,1) 0%,rgba(250,94,185,1) 44%,rgba(243,59,166,1) 100%);"),
    GLOSS_POMEGRANATE("-fx-background-color: linear-gradient(to bottom, rgba(255,125,123,1) 0%,rgba(250,96,94,1) 44%,rgba(243,62,59,1) 100%);"),
    GLOSS_PICTONBLUE("-fx-background-color: linear-gradient(to bottom, rgba(123,209,255,1) 0%,rgba(94,195,250,1) 44%,rgba(59,179,243,1) 100%);"),
    GLOSS_BRIGHTTURQUOISE("-fx-background-color: linear-gradient(to bottom, rgba(123,255,204,1) 0%,rgba(94,250,190,1) 44%,rgba(59,243,173,1) 100%);"),
    GLOSS_MALACHITE("-fx-background-color: linear-gradient(to bottom, rgba(123,255,130,1) 0%,rgba(94,250,102,1) 44%,rgba(59,243,68,1) 100%);"),
    GLOSS_GREEN("-fx-background-color: linear-gradient(to bottom, rgba(123,255,174,1) 0%,rgba(94,250,154,1) 44%,rgba(59,243,129,1) 100%);"),
    GLOSS_SCREAMINGGREEN("-fx-background-color: linear-gradient(to bottom, rgba(141,255,123,1) 0%,rgba(115,250,94,1) 44%,rgba(83,243,59,1) 100%);"),
    GLOSS_STARSHIP("-fx-background-color: linear-gradient(to bottom, rgba(255,255,123,1) 0%,rgba(250,250,94,1) 44%,rgba(243,243,59,1) 100%);"),
    GLOSS_JAFFA("-fx-background-color: linear-gradient(to bottom, rgba(255,189,123,1) 0%,rgba(250,172,94,1) 44%,rgba(243,151,59,1) 100%);"),
    
    LINEAR_FADE_LEFT_ROYALBLUE("-fx-background-color: linear-gradient(to right, rgba(190,226,240,1) 0%,rgba(61,137,223,1) 100%);"),
    LINEAR_FADE_LEFT_TURQUOISE("-fx-background-color: linear-gradient(to right, rgba(190,240,225,1) 0%,rgba(61,223,215,1) 100%);"),
    LINEAR_FADE_LEFT_EMERALD("-fx-background-color: linear-gradient(to right, rgba(191,240,190,1) 0%,rgba(61,223,99,1) 100%);"),
    LINEAR_FADE_LEFT_WATTLE("-fx-background-color: linear-gradient(to right, rgba(240,228,190,1) 0%,rgba(220,223,61,1) 100%);"),
    LINEAR_FADE_LEFT_ANZAC("-fx-background-color: linear-gradient(to right, rgba(240,204,190,1) 0%,rgba(223,147,61,1) 100%);"),
    LINEAR_FADE_LEFT_PUNCH("-fx-background-color: linear-gradient(to right, rgba(240,190,203,1) 0%,rgba(223,61,64,1) 100%);"),
    LINEAR_FADE_LEFT_CERISE("-fx-background-color: linear-gradient(to right, rgba(233,190,240,1) 0%,rgba(223,61,204,1) 100%); "),
    LINEAR_FADE_LEFT_MEDIUMPURPLE("-fx-background-color: linear-gradient(to right, rgba(212,190,240,1) 0%,rgba(174,61,223,1) 100%);"),
    LINEAR_FADE_LEFT_PURPLEHEART("-fx-background-color: linear-gradient(to right, rgba(202,190,240,1) 0%,rgba(139,61,223,1) 100%); "),
    LINEAR_FADE_LEFT_BLUERIBBON("-fx-background-color: linear-gradient(to right, rgba(190,212,240,1) 0%,rgba(36,79,255,1) 100%); "),
    LINEAR_FADE_LEFT_PICTONBLUE("-fx-background-color: linear-gradient(to right, rgba(190,231,240,1) 0%,rgba(61,153,223,1) 100%);"),
    
    LINEAR_FADE_RIGHT_ROYALBLUE("-fx-background-color: linear-gradient(to left, rgba(190,226,240,1) 0%,rgba(61,137,223,1) 100%);"),
    LINEAR_FADE_RIGHT_TURQUOISE("-fx-background-color: linear-gradient(to left, rgba(190,240,225,1) 0%,rgba(61,223,215,1) 100%);"),
    LINEAR_FADE_RIGHT_EMERALD("-fx-background-color: linear-gradient(to left, rgba(191,240,190,1) 0%,rgba(61,223,99,1) 100%);"),
    LINEAR_FADE_RIGHT_WATTLE("-fx-background-color: linear-gradient(to left, rgba(240,228,190,1) 0%,rgba(220,223,61,1) 100%);"),
    LINEAR_FADE_RIGHT_ANZAC("-fx-background-color: linear-gradient(to left, rgba(240,204,190,1) 0%,rgba(223,147,61,1) 100%);"),
    LINEAR_FADE_RIGHT_PUNCH("-fx-background-color: linear-gradient(to left, rgba(240,190,203,1) 0%,rgba(223,61,64,1) 100%);"),
    LINEAR_FADE_RIGHT_CERISE("-fx-background-color: linear-gradient(to left, rgba(233,190,240,1) 0%,rgba(223,61,204,1) 100%); "),
    LINEAR_FADE_RIGHT_MEDIUMPURPLE("-fx-background-color: linear-gradient(to left, rgba(212,190,240,1) 0%,rgba(174,61,223,1) 100%);"),
    LINEAR_FADE_RIGHT_PURPLEHEART("-fx-background-color: linear-gradient(to left, rgba(202,190,240,1) 0%,rgba(139,61,223,1) 100%); "),
    LINEAR_FADE_RIGHT_BLUERIBBON("-fx-background-color: linear-gradient(to left, rgba(190,212,240,1) 0%,rgba(36,79,255,1) 100%); "),
    LINEAR_FADE_RIGHT_PICTONBLUE("-fx-background-color: linear-gradient(to left, rgba(190,231,240,1) 0%,rgba(61,153,223,1) 100%); ");
    
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
