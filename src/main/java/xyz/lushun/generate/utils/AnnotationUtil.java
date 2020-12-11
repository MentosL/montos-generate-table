package xyz.lushun.generate.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Montos
 * @create 2020/12/10 10:48 上午
 */
public class AnnotationUtil {

    /**
     * 获取类上注解
     *
     * @param classz
     * @param annotation
     * @param <T>
     * @return
     */
    public static <T> T getAnnotation(Class classz, Class<T> annotation) {
        Annotation[] cas = classz.getAnnotations();
        for (Annotation ca : cas) {
            if (ca.annotationType().equals(annotation)) {
                return (T) ca;
            }
        }
        return null;
    }

    /**
     * 获取字段上注解
     *
     * @param classz
     * @param annotation
     * @param <T>
     * @return
     */
    public static <T> T getAnnotation(Field classz, Class<T> annotation) {
        Annotation[] cas = classz.getAnnotations();
        for (Annotation ca : cas) {
            if (ca.annotationType().equals(annotation)) {
                return (T) ca;
            }
        }
        return null;
    }

    /**
     * 获取方法上注解
     *
     * @param classz
     * @param annotation
     * @param <T>
     * @return
     */
    public static <T> T getAnnotation(Method classz, Class<T> annotation) {
        Annotation[] cas = classz.getAnnotations();
        for (Annotation ca : cas) {
            if (ca.annotationType().equals(annotation)) {
                return (T) ca;
            }
        }
        return null;
    }

    /**
     * 判断类上是否有对应注解
     *
     * @param clazz
     * @param annotations
     * @return
     */
    public static boolean classHasAnnotations(Class clazz, Class<? extends Annotation>... annotations) {
        for (Class<? extends Annotation> cla : annotations) {
            Annotation annotation = clazz.getAnnotation(cla);
            if (annotation != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字段上是否有注解
     *
     * @param field
     * @param annotations
     * @return
     */
    public static boolean fieldHasAnnotations(Field field, Class<? extends Annotation>... annotations) {
        for (Class<? extends Annotation> cla : annotations) {
            Annotation annotation = field.getAnnotation(cla);
            if (annotation != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断方法上是否有注解
     *
     * @param method
     * @param annotations
     * @return
     */
    public static boolean methodHasAnnotations(Method method, Class<? extends Annotation>... annotations) {
        for (Class<? extends Annotation> cla : annotations) {
            Annotation annotation = method.getAnnotation(cla);
            if (annotation != null) {
                return true;
            }
        }
        return false;
    }


}
