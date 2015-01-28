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
 * List of predefined CSS color styles for the dialog's header label.
 *
 * @author Ryan Gilera
 */
public enum HeaderColorStyle {

    /**
     * If no color is selected, this is the default value, corresponding style 
     * is applied on their selected dialog instead
     */
    DEFAULT(""),
    
    /**
     * This value is selected when the user wants apply their own color style
     */
    CUSTOM(""),
    
    /**
     * The default color style for a generic dialog (gray)
     */
    GENERIC("-fx-background-color: rgb(216, 222, 227);"),
    
    
    // GLOSS SERIES
    
    /**
     * The default color style for Error dialog (red)
     */
    GLOSS_ERROR("-fx-background-color: "
            + "linear-gradient(to bottom, #FFA3A5 0%, #FA9294 44%, #F37B7D 100% );"),
    
    /**
     * The default color style for information dialog (blue)
     */
    GLOSS_INFO("-fx-background-color: "
            + "linear-gradient(to bottom, #A3D1FF 0%, #92C6FA 44%, #7BB7F3 100% );"),
    
    /**
     * The default color style for warning dialog (orange)
     */
    GLOSS_WARNING("-fx-background-color: "
            + "linear-gradient(to bottom, #FFD1A3 0%, #FAC692 44%, #F3B77B 100% );"),
    
    /**
     * The default color style for confirmation dialog (green)
     */
    GLOSS_CONFIRM("-fx-background-color: "
            + "linear-gradient(to bottom, #A3FFCE 0%, #92FAC3 44%, #7BF3B3 100% );"),
    
    /**
     * The default color style for input dialog (yellow)
     */
    GLOSS_INPUT("-fx-background-color: "
            + "linear-gradient(to bottom, #F9FFA3 0%, #F3FA92 44%, #EBF37B 100% );"),
    
    /**
     * The default color style for exception dialog (pink)
     */
    GLOSS_EXCEPTION("-fx-background-color: "
            + "linear-gradient(to bottom, #E2A3FF 0%, #D992FA 44%, #CD7BF3 100% );"),
    
    
    GLOSS_ROYALBLUE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(123,149,255,1) "
            + "0%,rgba(94,125,250,1) 44%,rgba(59,96,243,1) 100%);"),
    
    GLOSS_ELECTRICVIOLET("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(191,123,255,1) "
            + "0%,rgba(175,94,250,1) 44%,rgba(154,59,243,1) 100%);"),
    
    GLOSS_BRILLIANTROSE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(255,123,200,1) "
            + "0%,rgba(250,94,185,1) 44%,rgba(243,59,166,1) 100%);"),
    
    GLOSS_POMEGRANATE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(255,125,123,1) "
            + "0%,rgba(250,96,94,1) 44%,rgba(243,62,59,1) 100%);"),
    
    GLOSS_PICTONBLUE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(123,209,255,1) "
            + "0%,rgba(94,195,250,1) 44%,rgba(59,179,243,1) 100%);"),
    
    GLOSS_BRIGHTTURQUOISE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(123,255,204,1) "
            + "0%,rgba(94,250,190,1) 44%,rgba(59,243,173,1) 100%);"),
    
    GLOSS_MALACHITE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(123,255,130,1) "
            + "0%,rgba(94,250,102,1) 44%,rgba(59,243,68,1) 100%);"),
    
    GLOSS_SANDSTORM("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(255,229,123,1) "
            + "0%,rgba(250,219,94,1) 44%,rgba(243,206,59,1) 100%);"),
    
    GLOSS_MEDIUMTURQUOISE("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(123,242,255,1) "
            + "0%,rgba(94,234,250,1) 44%,rgba(59,225,243,1) 100%);"),
    
    GLOSS_STARSHIP("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(255,255,123,1) "
            + "0%,rgba(250,250,94,1) 44%,rgba(243,243,59,1) 100%);"),
    
    GLOSS_JAFFA("-fx-background-color: "
            + "linear-gradient(to bottom, rgba(255,189,123,1) "
            + "0%,rgba(250,172,94,1) 44%,rgba(243,151,59,1) 100%);"),
    
    
    // LINEAR FADE LEFT SERIES 
    
    // Hue -180 or +180
    LINEAR_FADE_LEFT_TIGERSEYE("-fx-background-color: "
            + "linear-gradient(to right, rgba(240,204,190,1) "
            + "0%,rgba(223,147,61,1) 100%);"),
    
    // Hue -160
    LINEAR_FADE_LEFT_WATTLE("-fx-background-color: "
            + "linear-gradient(to right, rgba(240,221,190,1) "
            + "0%,rgba(223,201,61,1) 100%);"),
    
    // Hue -140
    LINEAR_FADE_LEFT_PEAR("-fx-background-color: "
            + "linear-gradient(to right, rgba(240,238,190,1) "
            + "0%,rgba(191,223,61,1) 100%);"),
    
    // Hue -120
    LINEAR_FADE_LEFT_YELLOWGREEN("-fx-background-color: "
            + "linear-gradient(to right, rgba(226,240,190,1) "
            + "0%,rgba(137,223,61,1) 100%);"),
    
    // Hue -100
    LINEAR_FADE_LEFT_LIMEGREEN("-fx-background-color: "
            + "linear-gradient(to right, rgba(209,240,190,1) "
            + "0%,rgba(83,223,61,1) 100%);"),
    
    // Hue -80
    LINEAR_FADE_LEFT_UFOGREEN("-fx-background-color: "
            + "linear-gradient(to right, rgba(192,240,190,1) "
            + "0%,rgba(61,223,93,1) 100%);"),
    
    // Hue -60
    LINEAR_FADE_LEFT_SHAMROCK("-fx-background-color: "
            + "linear-gradient(to right, rgba(190,240,204,1) "
            + "0%,rgba(61,223,147,1) 100%);"),
    
    // Hue -40
    LINEAR_FADE_LEFT_TURQUOISE("-fx-background-color: "
            + "linear-gradient(to right, rgba(190,240,221,1) "
            + "0%,rgba(61,223,201,1) 100%);"),
    
    // Hue -20
    LINEAR_FADE_LEFT_PICTONBLUE("-fx-background-color: "
            + "linear-gradient(to right, rgba(190,240,238,1) "
            + "0%,rgba(61,191,223,1) 100%);"),
    
    // Hue 0
    LINEAR_FADE_LEFT_BlEUDEFRANCE("-fx-background-color: "
            + "linear-gradient(to right, rgba(190,227,240,1) "
            + "0%,rgba(61,139,223,1) 100%);"),
    
    // Hue +20
    LINEAR_FADE_LEFT_ROYALBLUE("-fx-background-color: "
            + "linear-gradient(to right, rgba(190,209,240,1) "
            + "0%,rgba(61,83,223,1) 100%);"),
    
    // Hue +40
    LINEAR_FADE_LEFT_MAJORELLEBLUE("-fx-background-color: "
            + "linear-gradient(to right, rgba(190,192,240,1) "
            + "0%,rgba(93,61,223,1) 100%);"),
    
    // Hue +60
    LINEAR_FADE_LEFT_BLUEPURPLE("-fx-background-color: "
            + "linear-gradient(to right, rgba(204,190,240,1) "
            + "0%,rgba(147,61,223,1) 100%);"),
    
    // Hue +80
    LINEAR_FADE_LEFT_MEDIUMORCHID("-fx-background-color: "
            + "linear-gradient(to right, rgba(221,190,240,1) "
            + "0%,rgba(201,61,223,1) 100%);"),
    
    // Hue +100
    LINEAR_FADE_LEFT_RAZZLEROSE("-fx-background-color: "
            + "linear-gradient(to right, rgba(238,190,240,1) "
            + "0%,rgba(223,61,191,1) 100%);"),
    
     // Hue +120
    LINEAR_FADE_LEFT_CERISE("-fx-background-color: "
            + "linear-gradient(to right, rgba(240,190,226,1) "
            + "0%,rgba(223,61,137,1) 100%);"),
    
     // Hue +140
    LINEAR_FADE_LEFT_AMARANTH("-fx-background-color: "
            + "linear-gradient(to right, rgba(240,190,209,1) "
            + "0%,rgba(223,61,83,1) 100%);"),
    
     // Hue +160
    LINEAR_FADE_LEFT_FLAMEPEA("-fx-background-color: "
            + "linear-gradient(to right, rgba(240,190,192,1) "
            + "0%,rgba(223,93,61,1) 100%);"),
    
    
    // LINEAR FADE RIGHT SERIES
    
    // Hue -180 or +180
    LINEAR_FADE_RIGHT_TIGERSEYE("-fx-background-color: "
            + "linear-gradient(to left, rgba(240,204,190,1) "
            + "0%,rgba(223,147,61,1) 100%);"),
    
    // Hue -160
    LINEAR_FADE_RIGHT_WATTLE("-fx-background-color: "
            + "linear-gradient(to left, rgba(240,221,190,1) "
            + "0%,rgba(223,201,61,1) 100%);"),
    
    // Hue -140
    LINEAR_FADE_RIGHT_PEAR("-fx-background-color: "
            + "linear-gradient(to left, rgba(240,238,190,1) "
            + "0%,rgba(191,223,61,1) 100%);"),
    
    // Hue -120
    LINEAR_FADE_RIGHT_YELLOWGREEN("-fx-background-color: "
            + "linear-gradient(to left, rgba(226,240,190,1) "
            + "0%,rgba(137,223,61,1) 100%);"),
    
    // Hue -100
    LINEAR_FADE_RIGHT_LIMEGREEN("-fx-background-color: "
            + "linear-gradient(to left, rgba(209,240,190,1) "
            + "0%,rgba(83,223,61,1) 100%);"),
    
    // Hue -80
    LINEAR_FADE_RIGHT_UFOGREEN("-fx-background-color: "
            + "linear-gradient(to left, rgba(192,240,190,1) "
            + "0%,rgba(61,223,93,1) 100%);"),
    
    // Hue -60
    LINEAR_FADE_RIGHT_SHAMROCK("-fx-background-color: "
            + "linear-gradient(to left, rgba(190,240,204,1) "
            + "0%,rgba(61,223,147,1) 100%);"),
    
    // Hue -40
    LINEAR_FADE_RIGHT_TURQUOISE("-fx-background-color: "
            + "linear-gradient(to left, rgba(190,240,221,1) "
            + "0%,rgba(61,223,201,1) 100%);"),
    
    // Hue -20
    LINEAR_FADE_RIGHT_PICTONBLUE("-fx-background-color: "
            + "linear-gradient(to left, rgba(190,240,238,1) "
            + "0%,rgba(61,191,223,1) 100%);"),
    
    // Hue 0
    LINEAR_FADE_RIGHT_BlEUDEFRANCE("-fx-background-color: "
            + "linear-gradient(to left, rgba(190,227,240,1) "
            + "0%,rgba(61,139,223,1) 100%);"),
    
    // Hue +20
    LINEAR_FADE_RIGHT_ROYALBLUE("-fx-background-color: "
            + "linear-gradient(to left, rgba(190,209,240,1) "
            + "0%,rgba(61,83,223,1) 100%);"),
    
    // Hue +40
    LINEAR_FADE_RIGHT_MAJORELLEBLUE("-fx-background-color: "
            + "linear-gradient(to left, rgba(190,192,240,1) "
            + "0%,rgba(93,61,223,1) 100%);"),
    
    // Hue +60
    LINEAR_FADE_RIGHT_BLUEPURPLE("-fx-background-color: "
            + "linear-gradient(to left, rgba(204,190,240,1) "
            + "0%,rgba(147,61,223,1) 100%);"),
    
    // Hue +80
    LINEAR_FADE_RIGHT_MEDIUMORCHID("-fx-background-color: "
            + "linear-gradient(to left, rgba(221,190,240,1) "
            + "0%,rgba(201,61,223,1) 100%);"),
    
    // Hue +100
    LINEAR_FADE_RIGHT_RAZZLEROSE("-fx-background-color: "
            + "linear-gradient(to left, rgba(238,190,240,1) "
            + "0%,rgba(223,61,191,1) 100%);"),
    
     // Hue +120
    LINEAR_FADE_RIGHT_CERISE("-fx-background-color: "
            + "linear-gradient(to left, rgba(240,190,226,1) "
            + "0%,rgba(223,61,137,1) 100%);"),
    
     // Hue +140
    LINEAR_FADE_RIGHT_AMARANTH("-fx-background-color: "
            + "linear-gradient(to left, rgba(240,190,209,1) "
            + "0%,rgba(223,61,83,1) 100%);"),
    
     // Hue +160
    LINEAR_FADE_RIGHT_FLAMEPEA("-fx-background-color: "
            + "linear-gradient(to left, rgba(240,190,192,1) "
            + "0%,rgba(223,93,61,1) 100%);"),
    
    
    // OPAQUE SERIES
    
    // Hue -180 or +180
    OPAQUE_SPRINGBUD("-fx-background-color: rgba(170,255,1,0.4)"),
    
    // Hue -160
    OPAQUE_BRIGHTGREEN("-fx-background-color: rgba(86,255,1,0.4)"),
    
    // Hue -140
    OPAQUE_GREEN("-fx-background-color: rgba(1,255,1,0.4)"),
    
    // Hue -120
    OPAQUE_MALACHITE("-fx-background-color: rgba(1,255,86,0.4)"),
    
    // Hue -100
    OPAQUE_MEDIUMSPRINGGREEN("-fx-background-color: rgba(1,255,170,0.4)"),
    
    // Hue -80
    OPAQUE_CYAN("-fx-background-color: rgba(1,255,255,0.4)"),
    
    // Hue -60
    OPAQUE_CAPRI("-fx-background-color: rgba(1,170,255,0.4)"),
    
    // Hue -40
    OPAQUE_BLUERYB("-fx-background-color: rgba(1,86,255,0.4)"),
    
    // Hue -20
    OPAQUE_BLUE("-fx-background-color: rgba(1,1,255,0.4)"),
    
    // Hue 0
    OPAQUE_ELECTRICULTRAMARINE("-fx-background-color: rgba(86,1,255,0.4)"),
    
    // Hue +20
    OPAQUE_VIVIDVIOLET("-fx-background-color: rgba(170,1,255,0.4)"),
    
    // Hue +40
    OPAQUE_MAGENTA("-fx-background-color: rgba(255,1,255,0.4)"),
    
    // Hue +60
    OPAQUE_HOLLYWOODCERISE("-fx-background-color: rgba(255,1,170,0.4)"),
    
    // Hue +80
    OPAQUE_FOLLY("-fx-background-color: rgba(255,1,86,0.4)"),
    
    // Hue +100
    OPAQUE_RED("-fx-background-color: rgba(255,1,1,0.4)"),
    
    // Hue +120
    OPAQUE_INTERNATIONALORANGE("-fx-background-color: rgba(255,86,1,0.4)"),
    
    // Hue +140
    OPAQUE_CHROMEYELLOW("-fx-background-color: rgba(255,170,1,0.4)"),
    
    // Hue +160
    OPAQUE_YELLOW("-fx-background-color: rgba(255,255,1,0.4)");
    
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
