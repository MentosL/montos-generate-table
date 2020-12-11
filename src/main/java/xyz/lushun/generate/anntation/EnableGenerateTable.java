package xyz.lushun.generate.anntation;

import org.springframework.context.annotation.Import;
import xyz.lushun.generate.config.MontosAutoGenerateStarter;
import xyz.lushun.generate.enums.GenerateTypeEnum;
import xyz.lushun.generate.helper.IDataBaseSelector;
import xyz.lushun.generate.helper.dataBaseImpl.MysqlDataBaseSelector;

import java.lang.annotation.*;

/**
 * @author Montos
 * @create 2020/12/10 1:50 下午
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(MontosAutoGenerateStarter.class)
public @interface EnableGenerateTable {

    /**
     * 扫描entity路径
     *
     * @return
     */
    String[] scanBasePackages() default {};

    /**
     * 生成策略
     *
     * @return
     */
    GenerateTypeEnum type() default GenerateTypeEnum.NONE;

    /**
     * 生成器选择
     * @return
     */
    Class< ? extends IDataBaseSelector> dataBaseType() default MysqlDataBaseSelector.class;

}
