package org.gollog.file;

import java.io.File;

public class WarnFileLogger extends FileLogger {

    public WarnFileLogger(File file, String logName) {
        super(file, logName);
    }

    @Override
    public void error(String message, Object... params) {
        log("[ERROR ] ", message, params);
    }

    @Override
    public void warn(String message, Object... params) {
        log("[WARN ] ", message, params);
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
