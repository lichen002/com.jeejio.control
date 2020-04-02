package com.jeejio.common;

public interface ApiPath {
   String SERVER_PATH = "http://0.0.0.0:4723/wd/hub";
   String TEST_ACCOUNT = "15701188230";
   String TEST_PASSWORD = "123qweasd";
   String IMAGE_SUPER_CODE = "6666";
   String PHONE_SUPER_CODE = "888888";
   String TEST_EMAIL_ACCOUNT = "18201422725@163.com";

   /*
   接口地址
    */
   String SERVICE_DEVICES = "http://10.10.11.98";
   String LOGIN_OUT_SERVICE_PATH = "http://10.10.11.61:8501/user/sso/logoutUser";
   String UNBIND_DEVICES_RESTORE_NETWORK = SERVICE_DEVICES+"/machine/machine/unbindMachine";
   String GET_DEVICES_LIST = SERVICE_DEVICES+"/machine/machine/getMachineManageList";
   String RESET_PASSWORD = SERVICE_DEVICES+"/user/users/setOrChangePassword";
   String REGIST_USER_ACCOUNT = SERVICE_DEVICES + "/user/users/registUser";
   String JUDGE_USER_EXIST =SERVICE_DEVICES+ "/user/users/judgeUserExist";


}
