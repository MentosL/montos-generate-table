package xyz.lushun.generate.constant;


/**
 * @author Montos
 * @create 2020/12/11 10:27 上午
 * 常量定义
 */
public class GenerateTableConstant {

    // 1.用于存需要创建的表名+（字段结构/表信息）
    public static final String NEW_TABLE_MAP = "newTableMap";
    // 2.用于存需要更新字段类型等的表名+结构
    public static final String MODIFY_TABLE_MAP = "modifyTableMap";
    // 3.用于存需要增加字段的表名+结构
    public static final String ADD_TABLE_MAP = "addTableMap";
    // 4.用于存需要删除字段的表名+结构
    public static final String REMOVE_TABLE_MAP = "removeTableMap";
    // 5.用于存需要删除主键的表名+结构
    public static final String DROP_KEY_TABLE_MAP = "dropKeyTableMap";
    // 6.用于存需要删除唯一约束的表名+结构
    public static final String DROP_INDEX_AND_UNIQUE_TABLE_MAP = "dropIndexAndUniqueTableMap";
    // 7.用于存需要增加的索引
    public static final String ADD_INDEX_TABLE_MAP = "addIndexTableMap";
    // 8.用于存需要增加的唯一约束
    public static final String ADD_UNIQUE_TABLE_MAP = "addUniqueTableMap";
    // 9.用于存更新表注释
    public static final String MODIFY_TABLE_PROPERTY_MAP = "modifyTablePropertyMap";


}
