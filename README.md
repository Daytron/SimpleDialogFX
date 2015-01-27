# <a name='home'></a>SimpleDialogFX   

Easy to use lightweight dialog library for JavaFX applications.

### Contents
* <a href='#features'>Features</a>
* <a href='#dialogs'>Dialogs</a>
* <a href='#colorthemes'>Color Themes</a>
* <a href='#installation'>Installation</a>
* <a href='#usage'>Usage</a>
 * <a href='#overview'>Overview</a> 
 * <a href='#construction'>Construction</a>
 * <a href='#colorstyle'>Color Style</a>
 * <a href='#font'>Font</a>
 * <a href='#responses'>Responses</a>
 * <a href='#misc'>Misc</a>
* <a href='#documentation'>Documentation</a>
* <a href='#development'>Development</a>
* <a href='#license'>License</a>
 
***

### <a name='features'></a>Features 
<sup><a href='#home'>[back to top]</a></sup>

- Minimal design 
- Apply various custom font styles
- Interchangeble color style themes with 54 background styles to choose from
- Apply your own custom style theme
- Add custom title, header and details/message texts
- Flexible constructor options
- Allows CSS style customization on dialog UI components
- Automatically resize to fit your contents


### <a name='dialogs'></a>Dialogs 
<sup><a href='#home'>[back to top]</a></sup>

<p align="center">
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/InfoDialog.png?token=AGk1WtIl0yQai-c3MiXwwyPwtbakmtY4ks5UmUB6wA%3D%3D" alt="Information Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/ConfirmDialog.png" alt="Confirmation Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/ConfirmAlt1Dialog.png" alt="Confirmation Alternative 1 Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/ConfirmAlt2Dialog.png" alt="Confirmation Alternative 2 Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/WarningDialog.png?token=AGk1WkOat2dl0G-gUxoeE8ockiVejWY-ks5UmUC6wA%3D%3D" alt="Warning Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ErrorDialog.png?token=AGk1Why_GDl4ELib3F_X8rq1NS2chp1kks5UmUDQwA%3D%3D" alt="Error Dialog" />
<br /><br />
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/InputTextDialog.png" alt="Input Text Dialog" />
<br /><br />
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ExceptionDialog.png" alt="Exception Dialog" />
</p>

### <a name='colorthemes'></a>Color Themes 
<sup><a href='#home'>[back to top]</a></sup>

If none of those colors hook you, try mix and match various color styles.

##### Gloss Series
<p align="center">
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/HeaderColors/GlossSeries.png" alt="Gloss Series" />
</p>

##### Linear Fade Left Series
<p align="center">
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/HeaderColors/LinearFadeLeftSeries.png" alt="Linear Fade Left Series" />
</p>

##### Linear Fade Right Series
<p align="center">
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/HeaderColors/LinearFadeRightSeries.png" alt="Linear Fade Right Series" />
</p>


##### Opaque Series
<p align="center">
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/HeaderColors/OpaqueSeries.png" alt="Opaque Series" />
</p>

### <a name='installation'></a>Installation 
<sup><a href='#home'>[back to top]</a></sup>  

SimpleDialogFX is available in Maven Central. To start using, simply add the following elements to your pom.xml file:

```xml
<dependency>
  <groupId>com.github.daytron</groupId>
  <artifactId>SimpleDialogFX</artifactId>
  <version>2.1.1</version>
</dependency>
```

### <a name='usage'></a>Usage 
<sup><a href='#home'>[back to top]</a></sup> 

#####<a name='overview'></a>Overview
<sup><a href='#home'>[back to top]</a></sup> 

A dialog consists of the following areas shown in the figure below:
- Title
- Header
- Details
- and Buttons

<p align="center">
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/OverviewUsage.png" alt="Dialog overview" />
</p>

#####<a name='construction'></a>Construction
<sup><a href='#home'>[back to top]</a></sup> 

For any type of dialog with native window style, you only have to create a new `Dialog` object. For example a confirmation dialog would look like this:
```java
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                "Confirm Action",
                "Are you sure?");
dialog.showAndWait();
```
For an undecorated window style:
```java
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                DialogStyle.UNDECORATED,
                "Confirm Action",
                "Are you sure?");
dialog.showAndWait();
```
For a confirmation dialog with prebuilt texts:
```java
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                DialogText.CONFIRMATION_TITLE.getText(),
                DialogText.CONFIRMATION_HEADER.getText(),
                "Are you sure?");
dialog.showAndWait();
```

For an exception dialog:
```java
Dialog dialog = new Dialog(exception);
dialog.showAndWait();
```

For undecorated exception dialog:
```java
Dialog dialog = new Dialog(
                DialogStyle.UNDECORATED,
                exception);
dialog.showAndWait();
```

To retrieve a response, simply use:
```java
DialogResponse response = dialog.getResponse();
```
Another example:
```java
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                "This is a sample title",
                "Confirm Action",
                "Are you sure?");
dialog.showAndWait();

if (dialog.getResponse() == DialogResponse.YES) {
    // Rest of the code
}
```

Result:
<p align="center">
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/develop/Screenshots/Example1.png" alt="Result Example Dialog" />
</p>
<br />
For the complete list of constructors, see [Javadoc].

##### <a name='colorstyle'></a>Color Style 
<sup><a href='#home'>[back to top]</a></sup>

You can set the color style with `HeaderColorStyle` enum either via the constructor or through a method.

###### Via constructor: 

`Dialog(DialogType dialogType, HeaderColorStyle headerColorStyle, String header, String details)` and

`Dialog(DialogType dialogType, DialogStyle dialogStyle, String title, String header, HeaderColorStyle headerColorStyle, String details, Exception exception)`

###### Via method:
`setHeaderColorStyle(HeaderColorStyle headerColorStyle)`

##### <a name='font'></a>Font 
<sup><a href='#home'>[back to top]</a></sup>  

Apply any style fonts using these methods:
```java
setFontSize(int font_size)
setFontSize(int header_font_size, int details_font_size)
setFontFamily(String font_family)
setFontFamily(String header_font_family, String details_font_family)
setFont(String font_family, int font_size)
setFont(String header_font_family, int header_font_size, String details_font_family, int details_font_size)
```

```java
 setHeaderFontSize(int font_size)
 setDetailsFontSize(int font_size)
 setHeaderFontFamily(String font_family)
 setDetailsFontFamily(String font_family)
 setHeaderFont(String font_family, int font_size)
 setDetailsFont(String font_family, int font_size)
```
##### <a name='responses'></a>Responses 
<sup><a href='#home'>[back to top]</a></sup> 

The list of all available dialog responses:
- `OK`
- `CANCEL`
- `YES`
- `NO`
- `CLOSE` (When user clicks dialog's close button instead)
- `SEND`
- `NO_RESPONSE` (Default value until the user interacts with it)

##### <a name='misc'></a>Misc 
<sup><a href='#home'>[back to top]</a></sup>  

UI components can be extracted, allowing you to customize the dialog as you see fit.
```java
getHeaderLabel()    // The colored head label
getDetailsLabel()   // The label text below header
getTextField()      // For Input dialog's textfield
getExceptionArea() // For Exception dialog's textarea
```
In addition, the Dialog class itself is a subclass of the Stage class, so you can further customize the look and style of your dialogs.

### <a name='documentation'></a>Documentation 
<sup><a href='#home'>[back to top]</a></sup> 

See [Javadoc] for more information.

### <a name='development'></a>Development 
<sup><a href='#home'>[back to top]</a></sup>  

Want to contribute? Please do open up an issue for any bug reports, recommendation or feedback. 



### <a name='license'></a>License 
<sup><a href='#home'>[back to top]</a></sup> 


MIT

[Javadoc]:https://daytron.github.io/SimpleDialogFX/apidocs/

