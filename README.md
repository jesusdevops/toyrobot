# Toy Robot

An command line application that simulates the moves of a Toy Robot in a TableTop.

The design is based on the command pattern where there is an Command interface with different 
implementations. This approach simplifies single responsibility, readability and testability of the code.

## Key components

- Main class: acts as the client receiving commands from a text file and delegate the execution of the same to specialized classes.
- CommandsExecutor class: responsible of executing valid commands.
- Command classes: implementation of the Command interface that perform specific actions that affect the position and face direction of the ToyRobot.

## How to execute the application?

Type from command line:

java Main [command file location]
 


