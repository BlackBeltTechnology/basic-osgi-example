package hu.blackbelt.logger.impl;


import hu.blackbelt.logger.api.CustomLoggerService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.log.LogService;

import static org.apache.felix.scr.annotations.ReferenceCardinality.MANDATORY_UNARY;
import static org.osgi.service.log.LogService.*;

@Service(CustomLoggerService.class)
@Component(immediate = true)
public class CustomLoggerServiceImpl implements CustomLoggerService {

    @Reference(cardinality = MANDATORY_UNARY)
    private LogService logService;

    @Override
    public void info(String message) {
        logService.log(LOG_INFO, message);
    }

    @Override
    public void warning(String message) {
        logService.log(LOG_WARNING, message);
    }

    @Override
    public void error(String message) {
        logService.log(LOG_ERROR, message);
    }

    @Override
    public void debug(String message) {
        logService.log(LOG_DEBUG, message);
    }

}
