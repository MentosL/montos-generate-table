package xyz.lushun.generate.enums.fieldType;

/**
 * @author Montos
 * @create 2020/12/10 2:28 下午
 */
public enum MysqlDataTypeEnum {

    DEFAULT(null, null),
    INT(11, null),
    VARCHAR(255, null),
    CHAR(255, null),
    BIGINT(20, null),
    BIT(1, null),
    TINYINT(4, null),
    SMALLINT(6, null),
    DECIMAL(10, 2),
    DOUBLE(null, null),
    TEXT(null, null),
    DATETIME(null, null),
    TIMESTAMP(null, null),
    DATE(null, null),
    TIME(null, null),
    FLOAT(null, null),
    YEAR(null, null),
    BLOB(null, null),
    LONGBLOB(null, null),
    TINYTEXT(null, null);

    MysqlDataTypeEnum(Integer defaultCount, Integer decimalCount) {
        this.defaultCount = defaultCount;
        this.decimalCount = decimalCount;
    }

    private Integer defaultCount;
    private Integer decimalCount;

    public Integer getDefaultCount() {
        return defaultCount;
    }

    public MysqlDataTypeEnum setDefaultCount(Integer defaultCount) {
        this.defaultCount = defaultCount;
        return this;
    }

    public Integer getDecimalCount() {
        return decimalCount;
    }

    public MysqlDataTypeEnum setDecimalCount(Integer decimalCount) {
        this.decimalCount = decimalCount;
        return this;
    }

}
