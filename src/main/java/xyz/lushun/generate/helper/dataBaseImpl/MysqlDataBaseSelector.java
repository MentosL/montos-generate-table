package xyz.lushun.generate.helper.dataBaseImpl;


import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import xyz.lushun.generate.anntation.MysqlGenerateTable;
import xyz.lushun.generate.enums.GenerateTypeEnum;
import xyz.lushun.generate.enums.charsetType.MysqlCharsetTypeEnum;
import xyz.lushun.generate.enums.engineType.MysqlEngineTypeEnum;
import xyz.lushun.generate.helper.IDataBaseSelector;
import xyz.lushun.generate.utils.AnnotationUtil;
import xyz.lushun.generate.utils.ClassScannerUtil;
import xyz.lushun.generate.utils.GetPropertiesUtils;

import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

/**
 * @author Montos
 * @create 2020/12/10 3:05 下午
 */
public class MysqlDataBaseSelector extends IDataBaseSelector {

    private static final Log logger = LogFactory.getLog(MysqlDataBaseSelector.class);

    @Override
    protected void buildTableMapConstruct(Class<?> clazz, GenerateTypeEnum type, Map<String, Map<String, TableConfig>> baseTableMap) {

        // 表名
        String tableName = GetPropertiesUtils.getTableName(clazz);
        // 表备注
        String tableComment = GetPropertiesUtils.getTableComment(clazz);
        // 获取表字符集
        MysqlCharsetTypeEnum charsetTypeEnum = GetPropertiesUtils.getTableCharset(clazz);
        // 获取表引擎
        MysqlEngineTypeEnum engineTypeEnum =  GetPropertiesUtils.getTableEngine(clazz);
        // 获取索引字段- 可能是联合索引，联合索引使用逗号区分
        String[] jointIndex = GetPropertiesUtils.getJointIndex(clazz);

        if (GenerateTypeEnum.ALL_NEW == type) { // 删除当前所以的表进行重新创建。


        }

    }

    @Override
    protected void createOrModifyTableConstruct(Map<String, Map<String, TableConfig>> baseTableMap) {

    }

    @Override
    public void generateTable(String[] scanBasePackages, GenerateTypeEnum type, Class<? extends Annotation>... annotations) {
        // 获取当前的entity的class对象
        Set<Class> scan = ClassScannerUtil.scan(scanBasePackages, annotations);

        for (Class clazz : scan) {
            if (!AnnotationUtil.classHasAnnotations(clazz, Table.class, TableName.class, MysqlGenerateTable.class)) {
                logger.warn("There are no table annotations for the current class,Skip this==>" + clazz.getName());
                continue;
            }
            buildTableMapConstruct(clazz, type, baseTableMap);
        }
    }
}
