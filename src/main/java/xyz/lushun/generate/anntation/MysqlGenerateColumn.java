package xyz.lushun.generate.anntation;


import xyz.lushun.generate.enums.fieldType.MysqlDataTypeEnum;

import java.lang.annotation.*;

/**
 * @author Montos
 * @create 2020/12/10 2:02 下午
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MysqlGenerateColumn {

    /**
     * 字段名 不填默认使用属性名作为表字段名,下划线格式
     *
     * @return
     */
    String value() default "";

    /**
     * mysql字段类型
     *
     * @return
     */
    MysqlDataTypeEnum mysqlType() default MysqlDataTypeEnum.DEFAULT;

    /**
     * 可否为null
     *
     * @return
     */
    boolean isNull() default true;

    /**
     * 是否为主键
     *
     * @return
     */
    boolean isKey() default false;


    /**
     * 是否为自增
     *
     * @return
     */
    boolean isAutoIncrement() default false;

    /**
     * 默认值
     *
     * @return
     */
    String defaultValue() default "";

    /**
     * 备注信息
     *
     * @return
     */
    String comment() default "";


}
