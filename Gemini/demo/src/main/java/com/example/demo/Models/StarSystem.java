package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StarSystem {
    private int systemID;
    private String systemName;

    public StarSystem(int systemID, String systemName) {
        this.systemID = systemID;
        this.systemName = systemName;
    }

    public int getSystemID() {
        return systemID;
    }

    public String getSystemName() {
        return systemName;
    }

}
