package com.showcal.framework.cache;

import com.xiniunet.framework.constant.CacheTimeEnum;

import java.lang.annotation.*;

/**
 * 用于查找的时候，放置缓存信息
 *
 * Created by 范智凝 on 2014-10-24 13:00:30.
 *
 * @author 范智凝
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Cache {
    // 模块名
    String moduleName();
    // 对象模型名称
    String modelName();
    // 是否按承租人缓存
    boolean isByTenant() default false;
    //缓存有效期 默认1天
    CacheTimeEnum expiration() default CacheTimeEnum.ONE_DAY;
}
