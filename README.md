# LS_Grafik

## General Discription
A graphical application (written in JavaFX) that lets you draw a triangle by entering three points.
Then you can specify an angle by which you can rotate said triangle around the center of the coordiinate system.

## Technical Details
The UI has been made with JavaFX in MVC-Style. The classes/files do the following

### sample.fxml
Defines the layout of the user interface

### Controller
The class that controls the application...

### Matrix
An extensive class that provides all the math that is needed to do the transformations needed to rotate the triangle.

### Point
A class that provide points with an x- and y-coordinate.

### Transform
A class that builds the transformation matrix to translate and rotate points. (probably not the best place for that)

### Triangle
The class where the triangle lives. It defines a triangle from points, rotates and draws it.

### Main
Just starts the application.

## Shortcomings
* There is no input verification yet. So you could make an input other than a number and the application would then crash.
* There is no validation if the given point coordinates lie inside the actual canvas. There won't be an error, you just might not see your resulting triangle.
* The window does not resize intelligently.
* The variable names are not the greatest...
* The code could be better structured.
