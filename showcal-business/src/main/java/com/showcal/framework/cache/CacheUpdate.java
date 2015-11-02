package com.showcal.framework.cache;

import java.lang.annotation.*;

/**
 * Created by 范智凝 on 2014-10-24 13:00:30.
 *
 * @author 范智凝
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheUpdate {
    // 模块名
    String moduleName();
    // 对象模型名称
    String modelName();
    // 关联对象模型
    String[] relatedModelName() default {};
    // 是否按承租人缓存
    boolean isByTenant() default true;
}
