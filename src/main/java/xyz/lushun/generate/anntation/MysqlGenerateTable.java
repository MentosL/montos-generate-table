package xyz.lushun.generate.anntation;

import xyz.lushun.generate.enums.charsetType.MysqlCharsetTypeEnum;
import xyz.lushun.generate.enums.engineType.MysqlEngineTypeEnum;

import java.lang.annotation.*;

/**
 * @author Montos
 * @create 2020/12/11 2:27 下午
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MysqlGenerateTable {

    /**
     * 表名
     *
     * @return
     */
    String name() default "";

    /**
     * 表注释
     *
     * @return
     */
    String comment() default "";

    /**
     * 联合索引 --  这里放入字段名
     *
     * @return
     */
    String[] jointIndex() default "";

    /**
     * 表字符集
     *
     * @return
     */
    MysqlCharsetTypeEnum charset() default MysqlCharsetTypeEnum.DEFAULT;

    /**
     * 表引擎
     *
     * @return
     */
    MysqlEngineTypeEnum engine() default MysqlEngineTypeEnum.DEFAULT;


}
