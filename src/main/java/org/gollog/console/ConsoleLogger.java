package org.gollog.console;

import org.gollog.Logger;

import java.io.PrintStream;
import java.time.LocalDateTime;

public abstract class ConsoleLogger implements Logger {

    private final String logName;

    public ConsoleLogger(String logName) {
        this.logName = logName;
    }

    protected void log(String level, String message, Object[] params, PrintStream out) {
        out.println(level + LocalDateTime.now().toString() + " " + logName + ": " + String.format(message, params));
    }
}
