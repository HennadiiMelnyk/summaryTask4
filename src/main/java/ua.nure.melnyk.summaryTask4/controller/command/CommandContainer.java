package ua.nure.melnyk.summaryTask4.controller.command;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * Holder for all commands.<br/>
 */
public class CommandContainer {
    /**
     * Returns command object with the given name.
     *
     * @param commandName Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName, ServletContext servletContext) {
        Map<String, Command> commands = (Map<String, Command>) servletContext.getAttribute("commands");
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }
}
