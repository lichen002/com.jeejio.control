package com.jeejio.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonResolve {
    //JSON解析方法
    public   String getValueByJPath(JSONObject responseJson, String jpath){
        Object obj = responseJson;
        if(responseJson!=null){
            for(String s : jpath.split("/")) {
                if(!s.isEmpty()) {
                    if(!(s.contains("[") || s.contains("]"))) {
                        obj = ((JSONObject) obj).get(s);
                    }else if(s.contains("[") || s.contains("]")) {
                        obj =((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replaceAll("]", "")));
                    }
                }
            }
            return obj.toString();
        }
        return null;
    }
}
