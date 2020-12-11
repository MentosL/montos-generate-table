package xyz.lushun.generate.enums;

/**
 * @author Montos
 * @create 2020/12/10 2:20 下午
 */
public enum DataBaseTypeEnum {
    MYSQL("mysql"), ORACLE("oracle"), SQLSERVER("sqlserver"), POSTGRESQL("postgresql");

    private String name;


    DataBaseTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public DataBaseTypeEnum setName(String name) {
        this.name = name;
        return this;
    }

    public static DataBaseTypeEnum parseByCode(String name) {
        for (DataBaseTypeEnum taskStatusEnums : DataBaseTypeEnum.values()) {
            if (taskStatusEnums.getName().equalsIgnoreCase(name)) {
                return taskStatusEnums;
            }
        }
        return null;
    }
}
