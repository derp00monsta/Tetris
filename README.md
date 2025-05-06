## TETRIS 🟥🟧🟨🟩🟦🟪⬜

### Project Description:
This game is played in the terminal and is meant to mimic the original Tetris game created in 1985 by Russian software engineer [Alexey Pajitnov](<https://www.britannica.com/biography/Alexey-Pajitnov>). After playing the board game [pentomino](<https://web.ma.utexas.edu/users/smmg/archive/1997/radin.html>) in his office, Alexey Pajitnov decided to create a version of it virtually, which became the popular game of Tetris of the GameBoy. This game is not complete yet and the only way for the game to end is by quitting or losing.
```
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
<! . . . . . . . . . .!>
  \/\/\/\/\/\/\/\/\/\/
```

### 🔎 Features:
There is a grid composed of characters that represent the boundaries of the game and the shapes that are manipulated. A block is represented by "[]". The following shapes may be found in the game.
```
   []   [][][]    [][]        []     [][]    []        
   []     []        [][]      []     [][]    []
 [][]                         []             [][]
                              []
```
Future implementations aim to calculate a score based on the number of lines filled and then clear them.

### 💻 Code:
All shapes have predetermined coordinate positions in the grid. The `T`, `S`, `Z`, `L`, `J`, `I`, and `O` shapes are all subclasses of the `Shape` class. The `Board` class is static and utilizes the `Shape` class by randomly generating `T`,`S`, `Z`, `L`, `J`, `I`, and `O` shapes and manipulating the one that is actively falling. The game uses exception handling and analyzes the input provided by the user to ensure smooth gameplay.

__Classes:__
 > - **Main** [`code/Main.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/Main.java>) The main class that runs the program.
 > - **Board** [`code/Board.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/Board.java>) A static class representing the Tetris grid.
 > - **Shape** [`main/code/shape/Shape.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/Shape.java>) An object that holds a list of coordinates.
 >   - **T** [`main/code/shape/T.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/T.java>) Inherits `Shape.java` and holds the starting coordinates for a T shape.
 >   - **S** [`main/code/shape/S.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/S.java>) Inherits `Shape.java` and holds the starting coordinates for a S shape.
 >   - **Z** [`main/code/shape/Z.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/Z.java>) Inherits `Shape.java` and holds the starting coordinates for a Z shape.
 >   - **O** [`main/code/shape/O.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/O.java>) Inherits `Shape.java` and holds the starting coordinates for a O shape.
 >   - **I** [`main/code/shape/I.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/I.java>) Inherits `Shape.java` and holds the starting coordinates for a I shape.
 >   - **L** [`main/code/shape/L.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/L.java>) Inherits `Shape.java` and holds the starting coordinates for a L shape. 
 >   - **J** [`main/code/shape/J.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/shapes/J.java>) Inherits `Shape.java` and holds the starting coordinates for a J shape.

 **Click on the image to view the UML Diagram Draw.io file**

 [<img src=UML.png>](<https://drive.google.com/file/d/1aZk0wBqmtG04Wr5Ft8qcC6oOq2NXwp34/view?usp=sharing>)

### 🎮 How to Play:
You can download the zip file or clone this repository and run it in VSCode, or another compiler or IDE. When running the code, please make sure that you have selected [`Main.java`](<https://github.com/derp00monsta/Tetris/blob/main/code/Main.java>) as the main class. A random shape is generated and placed at the top of the grid when the previous shape has fallen to the bottom. You will be prompted to move the actively falling shape with the following moves: 
```
l -> left   (move the shape left by one block)
r -> right  (move the shape right by one block)
s -> shoot down   (drop the shape to the bottom)
q -> quit   (exit the game)
```
The game currently only ends when the user quits or when the game is lost (a new shape can not fit in the board).

// TODO: remove commented code
// TODO: update UML Diagram and attach it to the repo
// TODO: check all comments and delete unnecessary print statements
// TODO: check that all criteria in the rubric have been met
// TODO: check if the clearFullLines() method works by having Ari test the game