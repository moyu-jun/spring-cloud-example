package com.xingtuai.cloud.common.utils;

import com.xingtuai.cloud.common.constants.CloudConstants;
import org.apache.commons.io.FileUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 * @date 2020/9/24
 */
public class StringUtils {
    public static List<String> splitToList(String value, String separate) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(value)) {
            return null;
        }

        String[] valueArray = org.apache.commons.lang3.StringUtils.split(value, separate);

        return Arrays.asList(valueArray);
    }

    public static Map<String, String> splitToMap(String value) {
        Map<String, String> map = new HashMap<String, String>();

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(value)) {
            String[] separateArray = org.apache.commons.lang3.StringUtils.split(value, CloudConstants.SEPARATE);
            for (String separateValue : separateArray) {
                String[] equalsArray = org.apache.commons.lang3.StringUtils.split(separateValue, CloudConstants.EQUALS);
                map.put(equalsArray[0].trim(), equalsArray[1].trim());
            }
        }

        return map;
    }

    public static String convertToString(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < list.size(); i++) {
                String value = list.get(i);

                stringBuilder.append(value);
                if (i < list.size() - 1) {
                    stringBuilder.append(CloudConstants.SEPARATE);
                }
            }

            return stringBuilder.toString();
        }

        return null;
    }

    public static String simulateText(String value, int size, String padValue) {
        return org.apache.commons.lang3.StringUtils.rightPad(value, size, padValue);
    }

    public static String simulateText(int size) {
        return simulateText("10", size, "10");
    }

    public static String toDisplaySize(String value) {
        return FileUtils.byteCountToDisplaySize(value.length());
    }

    public static int count(String text, String keyText) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(text) || org.apache.commons.lang3.StringUtils.isEmpty(keyText)) {
            return -1;
        }

        int count = 0;
        while (text.indexOf(keyText) != -1) {
            text = text.substring(text.indexOf(keyText) + 1, text.length());
            count++;
        }

        return count;
    }
}
