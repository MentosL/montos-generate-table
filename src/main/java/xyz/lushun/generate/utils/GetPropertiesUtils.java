package xyz.lushun.generate.utils;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.util.StringUtils;
import xyz.lushun.generate.anntation.MysqlGenerateTable;
import xyz.lushun.generate.enums.charsetType.MysqlCharsetTypeEnum;
import xyz.lushun.generate.enums.engineType.MysqlEngineTypeEnum;

import javax.persistence.Table;

/**
 * @author Montos
 * @create 2020/12/11 3:16 下午
 */
@MysqlGenerateTable
public class GetPropertiesUtils {

    /**
     * 获取表名
     *
     * @param clazz
     * @return
     */
    public static String getTableName(Class<?> clazz) {
        MysqlGenerateTable tableName = clazz.getAnnotation(MysqlGenerateTable.class);
        Table tableNameCommon = clazz.getAnnotation(Table.class);
        TableName tableNamePlus = clazz.getAnnotation(TableName.class);
        if (tableName != null && !StringUtils.isEmpty(tableName.name())) {
            return tableName.name();
        }
        if (tableNameCommon != null && !StringUtils.isEmpty(tableNameCommon.name())) {
            return tableNameCommon.name();
        }
        if (tableNamePlus != null && !StringUtils.isEmpty(tableNamePlus.value())) {
            return tableNamePlus.value();
        }
        return NameConvertToUtils.underscoreName(clazz.getSimpleName());
    }

    /**
     * 获取表备注信息
     *
     * @param clazz
     * @return
     */
    public static String getTableComment(Class<?> clazz) {
        MysqlGenerateTable tableComment = clazz.getAnnotation(MysqlGenerateTable.class);
        if (tableComment != null && !StringUtils.isEmpty(tableComment.comment())) {
            return tableComment.comment();
        }
        return "";
    }

    /**
     * 获取表字符集
     *
     * @param clazz
     * @return
     */
    public static MysqlCharsetTypeEnum getTableCharset(Class<?> clazz) {
        MysqlGenerateTable table = clazz.getAnnotation(MysqlGenerateTable.class);
        if (table != null && !StringUtils.isEmpty(table.charset())) {
            return table.charset();
        }
        return null;
    }

    /**
     * 获取表引擎
     *
     * @param clazz
     * @return
     */
    public static MysqlEngineTypeEnum getTableEngine(Class<?> clazz) {
        MysqlGenerateTable table = clazz.getAnnotation(MysqlGenerateTable.class);
        if (table != null && !StringUtils.isEmpty(table.engine())) {
            return table.engine();
        }
        return null;
    }

    /**
     * 获取索引字段- 可能是联合索引，联合索引使用逗号区分
     *
     * @param clazz
     * @return
     */
    public static String[] getJointIndex(Class<?> clazz) {
        MysqlGenerateTable table = clazz.getAnnotation(MysqlGenerateTable.class);
        if (table != null && !ArrayUtils.isEmpty(table.jointIndex())) {
            return table.jointIndex();
        }
        return null;
    }
}
