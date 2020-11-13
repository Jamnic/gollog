package org.gollog.console;

public class ErrorConsoleLogger extends ConsoleLogger {

    public ErrorConsoleLogger(String logName) {
        super(logName);
    }

    @Override
    public void error(String message, Object... params) {
        log("[ERROR ] ", message, params, System.err);
    }

    @Override
    public void warn(String message, Object... params) {
    }

    @Override
    public void info(String message, Object... params) {
    }

    @Override
    public void debug(String message, Object... params) {
    }

    @Override
    public void trace(String message, Object... params) {
    }
}
