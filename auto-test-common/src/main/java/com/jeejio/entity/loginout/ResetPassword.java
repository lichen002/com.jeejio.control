package com.jeejio.entity.loginout;

import lombok.Data;

@Data
public class ResetPassword {
    private String userPasswd;
    private String userKey;
}
