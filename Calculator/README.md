# Simple Calculator

A Java-based graphical calculator built using Swing components to perform basic arithmetic operations. This calculator provides a clean interface, including buttons for numbers, operators, and a display for showing results.

## Features

- Supports basic arithmetic operations: addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
- A clear (`C`) button to reset calculations.
- Real-time display for equations and results.
- User-friendly design with hover effects for buttons.

## Prerequisites

- **Java Development Kit (JDK)** - Version 8 or above.

## Code Structure

- **Calculator.java**: Main file containing the logic and GUI setup for the calculator.
- **FormulasSolver.java** (expected as helper): Assists with solving equations typed into the calculator.

## Classes and Components

1. **JFrame (Calculator)**: Sets up the main window for the calculator.
2. **JPanel (keyContainer, displayContainer)**: Contains the keypad and display sections.
3. **JTextField (eqDisplay, ansDisplay)**: Displays the current equation and result.
4. **JButton (btns)**: Represents each button on the keypad for numbers, operators, and clear function.

## Customization

- **Fonts and Colors**: You can modify the font sizes or colors in the constructor to suit your preferences.
- **Button Symbols**: The `symbols` array defines the layout and functions of the buttons.
