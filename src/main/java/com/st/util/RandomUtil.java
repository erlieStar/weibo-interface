package com.st.util;

import com.st.common.Const;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
public class RandomUtil {

    private static long userId = 0;

    public static String getRandomCity() {
        List<String> cityList = YamlUtil.cityList;
        Random random = new Random();
        //随机生成[0,cityList.size())的数
        int index = random.nextInt(cityList.size());
        return cityList.get(index);
    }

    //0是女生，1是男生
    public static String getRandomGender() {
        Random random = new Random();
        int num = random.nextInt(2);
        return num == 0 ? Const.FEMALE : Const.MALE;
    }

    //https://zhidao.baidu.com/question/295786227.html
    //34个身份简写
    public static Integer getRandomProvince() {
        Random random = new Random();
        int num = random.nextInt(60) + 20;
        return num;
    }

    public static Integer getRandomVerifiedType() {
        Random random = new Random();
        //取值范围在[1,4]
        int num = random.nextInt(4) + 1;
        return num;
    }

    public static Long getRandomUserId() {
        return userId++;
    }

    public static void main(String[] args) {
        String str = getRandomCity();
        log.info(str);
    }
}
