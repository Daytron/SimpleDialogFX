# SimpleDialogFX   

Easy to use lightweigth dialog library for JavaFX applications.

### Features
  - Minimal design 
  - Apply your own title, head and message texts.

### Dialogs
![Screenshot](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ConfirmationDialog.png?token=AGk1WsadYTmofFb9eeCQGpokMRzlY5Sbks5UmSBiwA%3D%3D)
![Screenshot](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/ErrorDialog.png?token=AGk1WjZUNqE_eVWdMbXgkPCnAMTB5de3ks5UmSCOwA%3D%3D)



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

![Result](https://raw.githubusercontent.com/Daytron/SimpleDialogFX/master/Screenshots/Example1.png?token=AGk1Wpm1D8X83kEEkWISkpDT06-hXGeYks5UmSLBwA%3D%3D)

See Javadoc for more information.

### Development

Want to contribute? Please do open up an issue for any bug reports, recommendation or feedback. 



License
----

MIT


