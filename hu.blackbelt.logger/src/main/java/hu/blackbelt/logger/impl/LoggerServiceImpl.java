package hu.blackbelt.logger.impl;


import hu.blackbelt.logger.api.LoggerService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

@Service(LoggerService.class)
@Component(immediate = true)
public class LoggerServiceImpl implements LoggerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void info(String message) {
        createLoggerFor(getCaller()).info(message);
    }

    @Override
    public void warning(String message) {
        createLoggerFor(getCaller()).warn(message);
    }

    @Override
    public void error(String message) {
        createLoggerFor(getCaller()).error(message);
    }

    @Override
    public void debug(String message) {
        createLoggerFor(getCaller()).debug(message);
    }

    private Logger createLoggerFor(Class<?> clazz) {
        logger.error("Creating logger for class: " + clazz.getSimpleName());
        return getLogger(clazz);
    }

    private Class<?> getCaller() {
        StackTraceElement stackTraceElement = null;
        try {
            stackTraceElement = new Exception().getStackTrace()[2];
            return Class.forName(stackTraceElement.getClassName());
        } catch(NullPointerException e){
            logger.error("Class was not found for caller: " + stackTraceElement + ". Using logger class instead.");
            return getClass();
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
