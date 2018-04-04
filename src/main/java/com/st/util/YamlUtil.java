package com.st.util;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class YamlUtil {

    private static Map map;
    public static List<String> cityList;

    static {
        Yaml yaml = new Yaml();
        map = yaml.loadAs(YamlUtil.class.getClassLoader().getResourceAsStream("application.yaml"), Map.class);
        cityList = (List<String>)map.get("city");
    }


    public static Integer getInteger(String key) {
        return (Integer)map.get(key);
    }

    public static void main(String[] args) {
        int start = YamlUtil.getInteger("start");
        log.info(start + "");
    }
}
