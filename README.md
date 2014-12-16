# SimpleDialogFX   

Easy to use lightweigth dialog library for JavaFX applications.

### Features
  - Minimal design 
  - Apply your own title, head and message texts.

### Dialogs
![Info](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/InfoDialog.png?token=AGk1WtIl0yQai-c3MiXwwyPwtbakmtY4ks5UmUB6wA%3D%3D)
![Confirmation](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ConfirmDialog.png?token=AGk1Wszv2Ed0NeExs00rvs0RxzWKNHquks5UmUChwA%3D%3D)
![Warning](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/WarningDialog.png?token=AGk1WkOat2dl0G-gUxoeE8ockiVejWY-ks5UmUC6wA%3D%3D)
![Error](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ErrorDialog.png?token=AGk1Why_GDl4ELib3F_X8rq1NS2chp1kks5UmUDQwA%3D%3D)
![GenericOK](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/GenericOKDialog.png?token=AGk1Whpo9J-RTuqldAtwGAGa-qAG1jXxks5UmUHzwA%3D%3D)

### Usage
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

![](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/Example1.png?token=AGk1WoIR64Ya--Vi2cwke9I-LhXW-_fsks5UmUF-wA%3D%3D)

##### Dialogs available:
- `InfoDialog`
- `ConfirmationDialog`
- `WarningDialog`
- `ErrorDialog`
- `GenericOKDialog`

See Javadoc for more information.

### Javadoc
[Javadoc source]

### Development

Want to contribute? Please do open up an issue for any bug reports, recommendation or feedback. 



License
----

MIT

[Javadoc source]:https://daytron.github.io/SimpleDialogFX/apidocs/
