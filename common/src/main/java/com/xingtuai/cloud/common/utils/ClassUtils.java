package com.xingtuai.cloud.common.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author James
 * @date 2020/9/24
 */
public class ClassUtils {

    public static Map<String, Object> getParameterMap(String[] methodParameterNames, Object[] arguments) {
        Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
        if (ArrayUtils.isNotEmpty(arguments)) {
            for (int i = 0; i < arguments.length; i++) {
                String parameterName = null;
                if (ArrayUtils.isNotEmpty(methodParameterNames)) {
                    parameterName = methodParameterNames[i];
                } else {
                    parameterName = String.valueOf(i);
                }
                Object argument = arguments[i];

                parameterMap.put(parameterName, argument);
            }
        }

        return parameterMap;
    }
}
