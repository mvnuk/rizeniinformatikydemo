package edu.vnum00.rizeniinformatiky.services;

import org.springframework.stereotype.Service;

@Service("osService")
public class OsService {
    public String getOs() {
        return System.getProperty("os.name");
    }
}
