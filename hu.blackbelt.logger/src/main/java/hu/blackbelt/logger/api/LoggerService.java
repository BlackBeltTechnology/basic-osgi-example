package hu.blackbelt.logger.api;


public interface LoggerService {

    void info(String message);

    void warning(String message);

    void error(String message);

    void debug(String message);
}
