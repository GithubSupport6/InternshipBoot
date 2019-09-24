package com.eurekabpo.internship.services.implementations;

import com.eurekabpo.internship.services.NameService;
import org.springframework.stereotype.Service;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NameServiceImpl implements NameService {
    private String CANNOT_FIND_NAME = "Cannot find name";
    private static Logger logger = Logger.getLogger(NameServiceImpl.class.getName());

    @Override
    public String getComputerName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
        return CANNOT_FIND_NAME;
    }
}
