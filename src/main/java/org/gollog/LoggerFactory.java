package org.gollog;

import org.gollog.console.*;
import org.gollog.file.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {

    private static final Map<Class<?>, Logger> loggers = new HashMap<>();

    public static Logger getLogger(Class<?> clazz) {
        return loggers.computeIfAbsent(clazz, LoggerFactory::createNewLogger);
    }

    private static Logger createNewLogger(Class<?> clazz) {
        String logName = clazz.getSimpleName();
        File logFile = getFile();

        File file = new File(LoggerFactory.class.getClassLoader().getResource("gollog.properties").toString());

        boolean consoleLogger = false;
        boolean fileLogger = false;
        String loglevel = "ERROR";

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("gollog.level"))
                        loglevel = line.substring("gollog.level=".length());

                    if (line.equals("gollog.logger.file=true"))
                        fileLogger = true;

                    if (line.equals("gollog.logger.console=true"))
                        consoleLogger = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (consoleLogger && fileLogger) {
                switch (loglevel) {
                    case "ERROR":
                        return new FileAndConsoleLogger(new ErrorFileLogger(logFile, logName), new ErrorConsoleLogger(logName));
                    case "WARN":
                        return new FileAndConsoleLogger(new WarnFileLogger(logFile, logName), new WarnConsoleLogger(logName));
                    case "INFO":
                        return new FileAndConsoleLogger(new InfoFileLogger(logFile, logName), new InfoConsoleLogger(logName));
                    case "DEBUG":
                        return new FileAndConsoleLogger(new DebugFileLogger(logFile, logName), new DebugConsoleLogger(logName));
                    case "TRACE":
                        return new FileAndConsoleLogger(new TraceFileLogger(logFile, logName), new TraceConsoleLogger(logName));
                }
            } else if (consoleLogger) {
                switch (loglevel) {
                    case "ERROR":
                        return new ErrorConsoleLogger(logName);
                    case "WARN":
                        return new WarnConsoleLogger(logName);
                    case "INFO":
                        return new InfoConsoleLogger(logName);
                    case "DEBUG":
                        return new DebugConsoleLogger(logName);
                    case "TRACE":
                        return new TraceConsoleLogger(logName);
                }
            } else if (fileLogger) {
                switch (loglevel) {
                    case "ERROR":
                        return new ErrorFileLogger(logFile, logName);
                    case "WARN":
                        return new WarnFileLogger(logFile, logName);
                    case "INFO":
                        return new InfoFileLogger(logFile, logName);
                    case "DEBUG":
                        return new DebugFileLogger(logFile, logName);
                    case "TRACE":
                        return new TraceFileLogger(logFile, logName);
                }
            }
        }

        return new InfoConsoleLogger(logName);
    }

    public static File getFile() {
        File file = null;
        try {
            File directory = new File("log/");
            if (!directory.exists()) {
                directory.mkdir();
            }

            file = new File("log/" + LocalDate.now().toString() + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
