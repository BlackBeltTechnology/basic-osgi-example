package hu.blackbelt.logger.api;


public interface CustomLoggerService {

    void info(String message);

    void warning(String message);

    void error(String message);

    void debug(String message);
}
