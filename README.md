# SimpleDialogFX   

Easy to use lightweight dialog library for JavaFX applications.

### Features
  - Minimal design 
  - Apply your own title, head and message texts.

### Update
**[18-12-2014]** The upcoming release is now push to version 2.0.0 instead of the previous stated version 1.2.0. This is due to the complete overhaul refactor of how the library works with a much more simplified way of constructing dialogs, more dialogs and more user customizations.

### Dialogs
<p align="center">
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/InfoDialog.png?token=AGk1WtIl0yQai-c3MiXwwyPwtbakmtY4ks5UmUB6wA%3D%3D" alt="Information Dialog" />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ConfirmDialog.png?token=AGk1Wszv2Ed0NeExs00rvs0RxzWKNHquks5UmUChwA%3D%3D" alt="Confirmation Dialog" />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/WarningDialog.png?token=AGk1WkOat2dl0G-gUxoeE8ockiVejWY-ks5UmUC6wA%3D%3D" alt="Warning Dialog" />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ErrorDialog.png?token=AGk1Why_GDl4ELib3F_X8rq1NS2chp1kks5UmUDQwA%3D%3D" alt="Error Dialog" />
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/GenericOKDialog.png?token=AGk1Whpo9J-RTuqldAtwGAGa-qAG1jXxks5UmUHzwA%3D%3D" alt="Generic OK Dialog" />
</p>
### Installation
SimpleDialogFX is available in Maven Central. To start using, simply add the following elements to your pom.xml file:

```
<dependency>
  <groupId>com.github.daytron</groupId>
  <artifactId>SimpleDialogFX</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Usage
##### Prior to version 2.0.0
For a confirmation dialog, simply create a new `ConfirmationDialog` object.
```
ConfirmationDialog dialog = new ConfirmationDialog("Confirm Action","Are you sure?");
dialog.showAndWait();
```

To retrieve a response, simply use:
```
DialogResponse response = dialog.getResponse();
```
Another example:
```
ConfirmationDialog dialog = new ConfirmationDialog("Confirm Action","Are you sure?");
dialog.setTitle("This is a sample title");
dialog.showAndWait();

if (dialog.getResponse() == DialogResponse.YES) {
    // Rest of the code
}
```

Result:
<p align="center">
<img src ="https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/Example1.png?token=AGk1WoIR64Ya--Vi2cwke9I-LhXW-_fsks5UmUF-wA%3D%3D" alt="Result Example Dialog" />
</p>

##### Dialogs available (v1.0.0 only):
- `InfoDialog`
- `ConfirmationDialog`
- `WarningDialog`
- `ErrorDialog`
- `GenericOKDialog`

See Javadoc for more information.

##### For the upcoming version 2.0.0 and above
For any type of dialog with native window style, you only have to create a new `Dialog` object. For a confirmation dialog:
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

### Documentation
See [Javadoc]

### Development

Want to contribute? Please do open up an issue for any bug reports, recommendation or feedback. 



License
----

MIT

[Javadoc]:https://daytron.github.io/SimpleDialogFX/apidocs/
