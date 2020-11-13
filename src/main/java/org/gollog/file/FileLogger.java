package org.gollog.file;

import org.gollog.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public abstract class FileLogger implements Logger {

    private final File file;
    private final String logName;

    public FileLogger(File file, String logName) {
        this.file = file;
        this.logName = logName;
    }

    protected void log(String level, String message, Object[] params) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(level + LocalDateTime.now().toString() + " " + logName + ": " + String.format(message, params) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
