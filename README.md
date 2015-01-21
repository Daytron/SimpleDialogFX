# SimpleDialogFX   

Easy to use lightweight dialog library for JavaFX applications.

### <a name='home'></a>Contents
* <a href='#features'>Features</a>
* <a href='#dialogs'>Dialogs</a>
* <a href='#installation'>Installation</a>
* <a href='#usage'>Usage</a>
 * <a href='#construction'>Construction</a>
 * <a href='#font'>Font</a>
 * <a href='#responses'>Responses</a>
 * <a href='#misc'>Misc</a>
* <a href='#documentation'>Documentation</a>
* <a href='#development'>Development</a>
* <a href='#license'>License</a>

***

### <a name='features'></a>Features <sup><a href='#home'>[back to top]</a></sup> 

  - Minimal design 
  - Apply custom fonts
  - Add your own custom title, head and message texts
  - Flexible constructor options
  - Apply custom CSS style on all dialog UI components
  - Automatically resize to fit your contents


### <a name='dialogs'></a>Dialogs <sup><a href='#home'>[back to top]</a></sup> 
<p align="center">
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/InfoDialog.png?token=AGk1WtIl0yQai-c3MiXwwyPwtbakmtY4ks5UmUB6wA%3D%3D" alt="Information Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ConfirmDialog.png?token=AGk1Wszv2Ed0NeExs00rvs0RxzWKNHquks5UmUChwA%3D%3D" alt="Confirmation Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/WarningDialog.png?token=AGk1WkOat2dl0G-gUxoeE8ockiVejWY-ks5UmUC6wA%3D%3D" alt="Warning Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ErrorDialog.png?token=AGk1Why_GDl4ELib3F_X8rq1NS2chp1kks5UmUDQwA%3D%3D" alt="Error Dialog" />
<br /><br />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/GenericOKDialog.png?token=AGk1Whpo9J-RTuqldAtwGAGa-qAG1jXxks5UmUHzwA%3D%3D" alt="Generic OK Dialog" />
<br /><br />
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/GenericOKCANCELDialog.png" alt="Generic OK CANCEL Dialog" />
<br /><br />
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/GenericYESNODialog.png" alt="Generic OK CANCEL Dialog" />
<br /><br />
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/InputTextDialog.png" alt="Generic OK CANCEL Dialog" />
<br /><br />
<img src="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ExceptionDialog.png" alt="Generic OK CANCEL Dialog" />
</p>
### <a name='installation'></a>Installation <sup><a href='#home'>[back to top]</a></sup>  
SimpleDialogFX is available in Maven Central. To start using, simply add the following elements to your pom.xml file:

```
<dependency>
  <groupId>com.github.daytron</groupId>
  <artifactId>SimpleDialogFX</artifactId>
  <version>2.0.0</version>
</dependency>
```

### <a name='usage'></a>Usage <sup><a href='#home'>[back to top]</a></sup> 
#####<a name='construction'></a>Construction
For any type of dialog with native window style, you only have to create a new `Dialog` object. For example a confirmation dialog would look like this:
```
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                "Confirm Action",
                "Are you sure?");
dialog.showAndWait();
```
For an undecorated window style:
```
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                DialogStyle.UNDECORATED,
                "Confirm Action",
                "Are you sure?");
dialog.showAndWait();
```
For a confirmation dialog with prebuilt texts:
```
Dialog dialog = new Dialog(
                DialogType.CONFIRMATION,
                DialogText.CONFIRMATION_TITLE.getText(),
                DialogText.CONFIRMATION_HEADER.getText(),
                "Are you sure?");
dialog.showAndWait();
```

For an exception dialog:
```
Dialog dialog = new Dialog(exception);
dialog.showAndWait();
```

For undecorated exception dialog:
```
Dialog dialog = new Dialog(
                DialogStyle.UNDECORATED,
                exception);
dialog.showAndWait();
```

To retrieve a response, simply use:
```
DialogResponse response = dialog.getResponse();
```
Another example:
```
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
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/Example1.png?token=AGk1WoIR64Ya--Vi2cwke9I-LhXW-_fsks5UmUF-wA%3D%3D" alt="Result Example Dialog" />
</p>
<br /><br />
##### <a name='font'></a>Font <sup><a href='#home'>[back to top]</a></sup>  
Apply any style fonts using these methods:
```
setFontSize(int font_size)
setFontSize(int header_font_size, int details_font_size)
setFontFamily(String font_family)
setFontFamily(String header_font_family, String details_font_family)
setFont(String font_family, int font_size)
setFont(String header_font_family, int header_font_size, String details_font_family, int details_font_size)
```
##### <a name='responses'></a>Responses <sup><a href='#home'>[back to top]</a></sup> 
The list of all available dialog responses:
- `OK`
- `CANCEL`
- `YES`
- `NO`
- `CLOSE` (When user clicks dialog's close button instead)
- `SEND`
- `NO_RESPONSE` (Default value until the user interacts with it)

##### <a name='misc'></a>Misc <sup><a href='#home'>[back to top]</a></sup>  
UI components can be extracted, allowing you to customize the dialog as you see fit.
```
getHeaderLabel()    // The colored head label
getDetailsLabel()   // The label text below header
getTextField()      // For Input dialog's textfield
getException_area() // For Exception dialog's textarea
```
In addition, the Dialog class itself is a subclass of the Stage class, so you can further customize the look and style of your dialogs.

### <a name='documentation'></a>Documentation <sup><a href='#home'>[back to top]</a></sup> 
See [Javadoc] for more information.

### <a name='development'></a>Development <sup><a href='#home'>[back to top]</a></sup>  

Want to contribute? Please do open up an issue for any bug reports, recommendation or feedback. 



### <a name='license'></a>License <sup><a href='#home'>[back to top]</a></sup> 


MIT

[Javadoc]:https://daytron.github.io/SimpleDialogFX/apidocs/

