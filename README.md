
# Sudoku Game 

A Java-based Sudoku game and solver that allows users to play Sudoku interactively through the console or automatically solve puzzles using a **Recursive Backtracking Algorithm**.
The project demonstrates Java programming concepts, object-oriented programming (OOP), recursion, arrays, file handling, and algorithm design.

## Features

### Sudoku Game
- Select from 4 Sudoku puzzles.
- Display the Sudoku board in a 9×9 grid.
- Enter numbers by selecting a row, column, and value.
- Prevent modifications to fixed cells.
- Validate moves against Sudoku rules.
- Detect conflicts in rows, columns, and 3×3 boxes.
- Update and display the board after successful moves.
- Detect when the player completes the puzzle.
- Exit the game and return to the main menu.

## Technologies Used

- **Java** – Core programming language.
- **Object-Oriented Programming (OOP)** – Classes, objects, encapsulation, and methods.
- **2D Arrays** – Representing the 9×9 Sudoku board.
- **Recursion & Backtracking** – Automatically solving Sudoku puzzles.
- **Java Scanner** – Handling user input through the console.
- **Java File I/O** – Reading puzzles and saving solutions.
- **IntelliJ IDEA** – Development environment.

## Algorithm: Recursive Backtracking

The Sudoku solver uses a recursive backtracking algorithm.

### How It Works

1. Find an empty cell (represented by `0`).
2. Try placing a number from 1 to 9.
3. Check whether the number follows Sudoku rules:
   - The number must not already exist in the same row.
   - The number must not already exist in the same column.
   - The number must not already exist in the same 3×3 box.
4. If the number is valid, place it and recursively solve the remaining puzzle.
5. If no solution is found, reset the cell to `0` and try another number.
6. Continue until the puzzle is solved or no solution is possible.

## Future Improvements

- Timer to track completion time.
- Hint system to assist players.
- Scoring system.
- Save and load game progress.
- Improved input validation and error highlighting.
- React frontend connected to a Java Spring Boot REST API.

## Resources
- [Baeldung – Create a Sudoku Solver in Java](https://www.baeldung.com/java-sudoku)
