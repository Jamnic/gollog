package org.gollog.console;

public class InfoConsoleLogger extends ConsoleLogger {

    public InfoConsoleLogger(String logName) {
        super(logName);
    }

    @Override
    public void error(String message, Object... params) {
        log("[ERROR ] ", message, params, System.err);
    }

    @Override
    public void warn(String message, Object... params) {
        log("[WARN ] ", message, params, System.err);
    }

    @Override
    public void info(String message, Object... params) {
        log("[INFO ] ", message, params, System.out);
    }

    @Override
    public void debug(String message, Object... params) {
    }

    @Override
    public void trace(String message, Object... params) {
    }
}
