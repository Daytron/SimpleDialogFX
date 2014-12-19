# SimpleDialogFX   

Easy to use lightweight dialog library for JavaFX applications.

### Features
  - Minimal design 
  - Custom fonts
  - Custom title, head and message texts
  - Flexible constructor options
  - Custom css style on all dialog labels, textfield and textarea
  - Automatic resize dialog to fit texts


### Dialogs
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
### Installation
SimpleDialogFX is available in Maven Central. To start using, simply add the following elements to your pom.xml file:

```
<dependency>
  <groupId>com.github.daytron</groupId>
  <artifactId>SimpleDialogFX</artifactId>
  <version>2.0.0</version>
</dependency>
```

### Usage
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
### Documentation
See [Javadoc] for more information.

### Development

Want to contribute? Please do open up an issue for any bug reports, recommendation or feedback. 



License
----

MIT

[Javadoc]:https://daytron.github.io/SimpleDialogFX/apidocs/
