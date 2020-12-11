package xyz.lushun.generate.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import xyz.lushun.generate.anntation.EnableGenerateTable;
import xyz.lushun.generate.enums.GenerateTypeEnum;

/**
 * @author Montos
 * @create 2020/12/10 1:56 下午
 */
public class MontosAutoGenerateStarter implements ApplicationContextAware, InitializingBean {

    private static final Log logger = LogFactory.getLog(MontosAutoGenerateStarter.class);
    private ApplicationContext applicationContext;

    protected Class<?> getAnnotationClass() {
        return EnableGenerateTable.class;
    }

    protected AnnotationAttributes getAttributes(AnnotationMetadata metadata) {
        String name = getAnnotationClass().getName();
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(name, true));
        Assert.notNull(attributes, () -> "No auto-configuration attributes found. Is " + metadata.getClassName()
                + " annotated with " + ClassUtils.getShortName(name) + "?");
        return attributes;
    }


    private void initData() {
        AnnotationMetadata annotationMetadata = applicationContext.getBean(AnnotationMetadata.class);
        AnnotationAttributes attributes = getAttributes(annotationMetadata);
        String[] scanBasePackages = attributes.getStringArray("scanBasePackages");
        GenerateTypeEnum type = attributes.getEnum("type");
        Class<?> dataBaseType = attributes.getClass("dataBaseType");



        switch (type) {
            case NONE:
                logger.trace("EnableGenerateTable is not open,jump !!!");
                return;
            case UPDATE:

                // todo  这里将对应的生成策略的type进行对象传递
                return;
            case ALL_NEW:

                // todo
                return;
            default:
                logger.warn("EnableGenerateTable type  is missing,please check config");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.initData();
    }
}
