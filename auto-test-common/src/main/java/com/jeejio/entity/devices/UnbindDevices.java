package com.jeejio.entity.devices;

import lombok.Data;

@Data
public class UnbindDevices {
    private String machineCode;
    private String ubindingType;
    private String userId;
}
