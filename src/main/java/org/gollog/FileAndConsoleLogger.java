package org.gollog;

import org.gollog.file.FileLogger;
import org.gollog.console.ConsoleLogger;

import java.io.File;

public class FileAndConsoleLogger implements Logger {

    private final FileLogger fileLogger;
    private final ConsoleLogger consoleLogger;

    public FileAndConsoleLogger(FileLogger fileLogger, ConsoleLogger consoleLogger) {
        this.fileLogger = fileLogger;
        this.consoleLogger = consoleLogger;
    }

    @Override
    public void error(String message, Object... params) {
        consoleLogger.error(message, params);
        fileLogger.error(message, params);
    }

    @Override
    public void warn(String message, Object... params) {
        consoleLogger.warn(message, params);
        fileLogger.warn(message, params);
    }

    @Override
    public void info(String message, Object... params) {
        consoleLogger.info(message, params);
        fileLogger.info(message, params);
    }

    @Override
    public void debug(String message, Object... params) {
        consoleLogger.debug(message, params);
        fileLogger.debug(message, params);
    }

    @Override
    public void trace(String message, Object... params) {
        consoleLogger.trace(message, params);
        fileLogger.trace(message, params);
    }
}
