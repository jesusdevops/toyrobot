package com.nasa.toyrobot;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible of producing a list of Commands based on a text input.
 * The resulting commands will be associated with the specified ToyRobot.
 */
public class CommandsParser {

    private final List<String> lines;
    private final ToyRobot toyRobot;

    public CommandsParser(List<String> lines, ToyRobot toyRobot) {
        this.lines = lines;
        this.toyRobot = toyRobot;
    }

    /**
     * Supports the parsing of the following text commands:
     * PLACE, MOVE, LEFT, RIGHT and REPORT
     * @return A list of Commands
     */
    public List<Command> parse() {
        final List<Command> commands = new ArrayList<>();
        boolean toyRobotHasBeenPlacedInsideTheTableTop = false;
        for(String line : lines) {
            line = line.trim();
            if (line.startsWith(CommandType.PLACE.name())) {
                String[] parts = line.substring(CommandType.PLACE.name().length()).split(",");
                PlaceCommand placeCommand = new PlaceCommand(toyRobot,
                        Integer.parseInt(parts[0].trim()),
                        Integer.parseInt(parts[1].trim()),
                        Face.valueOf(parts[2].trim()));
                if (placeCommand.getX() < toyRobot.getTableTop().getLength() ||
                        placeCommand.getY() < toyRobot.getTableTop().getWidth()) {
                    commands.add(placeCommand);
                    toyRobotHasBeenPlacedInsideTheTableTop = true;
                } else {
                    toyRobotHasBeenPlacedInsideTheTableTop = false;
                }
                continue;
            }

            if(!toyRobotHasBeenPlacedInsideTheTableTop) continue;

            if (line.startsWith(CommandType.MOVE.name())) {
                commands.add(new MoveCommand(toyRobot));
                continue;
            }

            if (line.startsWith(CommandType.LEFT.name())) {
                commands.add(new LeftCommand(toyRobot));
                continue;
            }

            if (line.startsWith(CommandType.RIGHT.name())) {
                commands.add(new RightCommand(toyRobot));
                continue;
            }

            if (line.startsWith(CommandType.REPORT.name())) {
                commands.add(new ReportCommand(toyRobot));
                continue;
            }

        }
        return commands;
    }
}
