package com.showcal.framework.cache;

import com.xiniunet.framework.base.CacheKey;

import java.util.List;
import java.util.Map;

/**
 * Created by 范智凝 on 2014-10-24 13:00:30.
 *
 * @author 范智凝
 */
public interface CacheManager {

    /**
     * 获取Key对应的value
     *
     * @param key 查找关键字
     */
    Object get(String key);

    /**
     * 获取Keys对应的values
     *
     * @param keys 查找关键字
     */
    Map<String, Object> getLists(List<String> keys);

    /**
     * 删除Key对应的内容
     *
     * @param key 查找关键字
     */
    boolean delete(String key);

    /**
     * 设定key对应的value
     *
     * @param key        查找关键字
     * @param value      存储的数据块（可直接理解为key-value结构中的value）
     * @param expireTime 该数据的存活时间（分钟）
     */
    boolean set(String key, Object value, CacheTimeEnum expireTime);

    /**
     * 重新设定key对应的value
     *
     * @param key        查找关键字
     * @param value      存储的数据块（可直接理解为key-value结构中的value）
     * @param expireTime 该数据的存活时间（分钟）
     */
    boolean replace(String key, Object value, CacheTimeEnum expireTime);

    /**
     * 获取Key对应的value
     *
     * @param key 查找关键字
     */
    Object get(CacheKey key);

    /**
     * 获取Keys对应的values
     *
     * @param keys 查找关键字
     */
    Map<String, Object> getList(List<CacheKey> keys);

    /**
     * 删除Key对应的内容
     *
     * @param key 查找关键字
     */
    boolean delete(CacheKey key);

    /**
     * 设定key对应的value
     *
     * @param key        查找关键字
     * @param value      存储的数据块（可直接理解为key-value结构中的value）
     * @param expireTime 该数据的存活时间（分钟）
     */
    boolean set(CacheKey key, Object value, CacheTimeEnum expireTime);

}
