package xyz.lushun.generate.helper;


import xyz.lushun.generate.constant.GenerateTableConstant;
import xyz.lushun.generate.enums.GenerateTypeEnum;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Montos
 * @create 2020/12/10 3:04 下午
 * 数据库生成策略interface  --  底下还有具体的生成类型区分
 */
public abstract class IDataBaseSelector {


    protected static Map<String, Map<String, TableConfig>> baseTableMap = null;

    static {
        baseTableMap = new HashMap<String, Map<String, TableConfig>>();
        // 1.用于存需要创建的表名+（字段结构/表信息）
        baseTableMap.put(GenerateTableConstant.NEW_TABLE_MAP, new HashMap<String, TableConfig>());
        // 2.用于存需要更新字段类型等的表名+结构
        baseTableMap.put(GenerateTableConstant.MODIFY_TABLE_MAP, new HashMap<String, TableConfig>());
        // 3.用于存需要增加字段的表名+结构
        baseTableMap.put(GenerateTableConstant.ADD_TABLE_MAP, new HashMap<String, TableConfig>());
        // 4.用于存需要删除字段的表名+结构
        baseTableMap.put(GenerateTableConstant.REMOVE_TABLE_MAP, new HashMap<String, TableConfig>());
        // 5.用于存需要删除主键的表名+结构
        baseTableMap.put(GenerateTableConstant.DROP_KEY_TABLE_MAP, new HashMap<String, TableConfig>());
        // 6.用于存需要删除唯一约束的表名+结构
        baseTableMap.put(GenerateTableConstant.DROP_INDEX_AND_UNIQUE_TABLE_MAP, new HashMap<String, TableConfig>());
        // 7.用于存需要增加的索引
        baseTableMap.put(GenerateTableConstant.ADD_INDEX_TABLE_MAP, new HashMap<String, TableConfig>());
        // 8.用于存需要增加的唯一约束
        baseTableMap.put(GenerateTableConstant.ADD_UNIQUE_TABLE_MAP, new HashMap<String, TableConfig>());
        // 9.更新表注释
        baseTableMap.put(GenerateTableConstant.MODIFY_TABLE_PROPERTY_MAP, new HashMap<String, TableConfig>());
    }


    /**
     * 生成表方法
     *
     * @param scanBasePackages 扫描包路径
     * @param type             生成表类型
     * @param annotations      扫描的entity类上的注解
     */
    protected abstract void generateTable(String[] scanBasePackages, GenerateTypeEnum type, Class<? extends Annotation>... annotations);

    /**
     * 补充对应的操作集合
     *
     * @param clazz
     * @param baseTableMap
     */
    protected abstract void buildTableMapConstruct(Class<?> clazz,GenerateTypeEnum type, Map<String, Map<String, TableConfig>> baseTableMap);

    /**
     * 执行生成计划
     *
     * @param baseTableMap
     */
    protected abstract void createOrModifyTableConstruct(Map<String, Map<String, TableConfig>> baseTableMap);


    /**
     * 操作信息类
     */
    public static class TableConfig {

        private List<Object> list = new ArrayList<Object>();

        private Map<String, Object> map = new HashMap<String, Object>();

        public TableConfig(List<Object> list, Map<String, Object> map) {
            if (list != null) {
                this.list = list;
            }
            if (map != null) {
                this.map = map;
            }
        }

        public TableConfig(List<Object> list) {
            if (list != null) {
                this.list = list;
            }
        }

        public TableConfig(Map<String, Object> map) {
            this.map = map;
        }

        public Map<String, Object> getMap() {
            return map;
        }

        public void setMap(Map<String, Object> map) {
            this.map = map;
        }

        public List<Object> getList() {
            return list;
        }

        public void setList(List<Object> list) {
            this.list = list;
        }
    }
}
