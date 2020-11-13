package org.gollog;

public interface Logger {

    void error(String message, Object... params);

    void warn(String message, Object... params);

    void info(String message, Object... params);

    void debug(String message, Object... params);

    void trace(String message, Object... params);
}
