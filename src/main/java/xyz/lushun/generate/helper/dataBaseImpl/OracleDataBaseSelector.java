package xyz.lushun.generate.helper.dataBaseImpl;


import xyz.lushun.generate.enums.GenerateTypeEnum;
import xyz.lushun.generate.helper.IDataBaseSelector;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author Montos
 * @create 2020/12/10 6:19 下午
 * Oracle 生成策略
 */
public class OracleDataBaseSelector extends IDataBaseSelector {
    @Override
    protected void buildTableMapConstruct(Class<?> clazz, GenerateTypeEnum type,Map<String, Map<String, TableConfig>> baseTableMap) {

    }

    @Override
    protected void createOrModifyTableConstruct(Map<String, Map<String, TableConfig>> baseTableMap) {

    }

    @Override
    public void generateTable(String[] scanBasePackages, GenerateTypeEnum type, Class<? extends Annotation>... annotations) {

    }


}
