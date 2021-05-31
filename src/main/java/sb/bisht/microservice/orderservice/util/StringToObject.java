package sb.bisht.microservice.orderservice.util;

import sb.bisht.toObject.annotations.Required;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringToObject {

    public static <T> T fromString(String jsonString, Class<T> desired) throws Exception {
        T t = desired.getConstructor().newInstance();

        Map<String, String> jsonKeyValues = jsonStringToFieldValueMap(jsonString);

        Field[] fields = desired.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String value = jsonKeyValues.get(field.getName());
            if (value != null) {
                if (field.getType() == Long.class) {
                    field.set(t, Long.valueOf(value));
                } else if (field.getType() == Date.class) {
                    field.set(t, new Date(Long.valueOf(value)));
                } else {
                    field.set(t, value);
                }
            }
            if (field.getAnnotations().length != 0 && field.getAnnotation(Required.class) != null) {
                if (field.get(t) == null) {
                    throw new Exception(field.getName() + " is required");
                }
            }
        }
        return t;
    }

    private static Map<String, String> jsonStringToFieldValueMap(String jsonString) throws Exception {
        String json = jsonString.substring(1, jsonString.length() - 1);
        String[] jsonFieldValues = json.split(",");
        Map<String, String> jsonFieldValueMap = new HashMap<>();
        for (String keyValue : jsonFieldValues) {
            String[] keyValuePair = keyValue.split(":");
            jsonFieldValueMap.put(isDoubleQuoted(keyValuePair[0]), isDoubleQuoted(keyValuePair[1]));
        }
        return jsonFieldValueMap;
    }

    private static String isDoubleQuoted(String s) throws Exception {
        if (s.charAt(0) == 34 && s.charAt(s.length() - 1) == 34) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
