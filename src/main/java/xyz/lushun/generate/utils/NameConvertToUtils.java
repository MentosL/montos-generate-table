package xyz.lushun.generate.utils;

/**
 * @author Montos
 * @create 2020/12/11 3:43 下午
 */
public class NameConvertToUtils {

    /**
     * Field to underName
     * @param name
     * @return
     */
    public static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            for (int i = 0; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                char c = s.charAt(0);
                if (65 <= Integer.valueOf(c) && Integer.valueOf(c) <= 90) {
                    result.append("_");
                }
                result.append(s.toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * underName to Field
     * @param name
     * @return
     */
    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

}
