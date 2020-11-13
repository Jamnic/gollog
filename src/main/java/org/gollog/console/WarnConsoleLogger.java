package org.gollog.console;

public class WarnConsoleLogger extends ConsoleLogger {

    public WarnConsoleLogger(String logName) {
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
    }

    @Override
    public void debug(String message, Object... params) {
    }

    @Override
    public void trace(String message, Object... params) {
    }
}
