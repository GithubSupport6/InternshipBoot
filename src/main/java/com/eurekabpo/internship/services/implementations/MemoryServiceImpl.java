package com.eurekabpo.internship.services.implementations;

import com.eurekabpo.internship.services.MemoryService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MemoryServiceImpl implements MemoryService {
    private static Logger logger = Logger.getLogger(MemoryServiceImpl.class.getName());

    @Override
    public String getFreeMemory() {
        logger.info("Getting free memory ...");
        return String.valueOf(Runtime.getRuntime().freeMemory());
    }

    @Override
    public String getAllMemory() {
        logger.info("Getting total memory ...");
        return String.valueOf(Runtime.getRuntime().totalMemory());
    }
}
