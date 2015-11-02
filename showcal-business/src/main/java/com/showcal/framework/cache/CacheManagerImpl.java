package com.showcal.framework.cache;

import com.xiniunet.framework.base.CacheKey;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import net.spy.memcached.internal.OperationFuture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 范智凝 on 2014-10-24 13:00:30.
 *
 * @author 范智凝
 */
public class CacheManagerImpl implements CacheManager {

    private MemcachedClient mcc;

    public CacheManagerImpl(String host, String port, String deployMode, String username, String password) {
        // 如果端口号未设置，则默认设置为11211
        if ("".equals(port)) {
            port = "11211";
        }
        try {
            if (!"production".equals(deployMode.toLowerCase())) {
                mcc = new MemcachedClient(AddrUtil.getAddresses(host + ":" + port));
            } else {
                AuthDescriptor ad = new AuthDescriptor(new String[]{"PLAIN"}, new PlainCallbackHandler(username, password));
                mcc = new MemcachedClient(
                        new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
                                .setAuthDescriptor(ad).build(),
                        AddrUtil.getAddresses(host + ":" + port));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*----------------CACHE AOP用-----------------*/
    /**
     * 获取Key对应的value
     *
     * @param key 查找关键字
     */
    @Override
    public Object get(String key) {
        return mcc.get(key);
    }

    /**
     * 获取Keys对应的values
     *
     * @param keys 查找关键字
     */
    @Override
    public Map<String, Object> getLists(List<String> keys) {
        return mcc.getBulk(keys);
    }

    /**
     * 删除Key对应的内容
     *
     * @param key 查找关键字
     */
    @Override
    public boolean delete(String key) {
        OperationFuture future = mcc.delete(key);
        return future.isDone();
    }

    /**
     * 设定key对应的value
     *
     * @param key        查找关键字
     * @param value      存储的数据块（可直接理解为key-value结构中的value）
     * @param expireTime 该数据的存活时间（分钟）
     */
    @Override
    public boolean set(String key, Object value, CacheTimeEnum expireTime) {
        OperationFuture future = mcc.set(key, expireTime.value() * 60, value);
        return future.isDone();
    }

    /**
     * 重新设定key对应的value
     *
     * @param key        查找关键字
     * @param value      存储的数据块（可直接理解为key-value结构中的value）
     * @param expireTime 该数据的存活时间（分钟）
     */
    @Override
    public boolean replace(String key, Object value, CacheTimeEnum expireTime) {
        OperationFuture future = mcc.replace(key, expireTime.value() * 60, value);
        return future.isDone();
    }

    /*----------------CACHE AOP用-----------------*/

    /**
     * 获取Key对应的value
     *
     * @param key 查找关键字
     */
    @Override
    public Object get(CacheKey key) {
        return mcc.get(convertKey(key));
    }

    /**
     * 获取Keys对应的values
     *
     * @param keys 查找关键字
     */
    @Override
    public Map<String, Object> getList(List<CacheKey> keys) {
        List<String> strList = new ArrayList<>();

        for (CacheKey cacheKey : keys) {
            strList.add(convertKey(cacheKey));
        }
        String[] keyList = (String[]) strList.toArray();
        return mcc.getBulk(keyList);
    }

    /**
     * 删除Key对应的内容
     *
     * @param key 查找关键字
     */
    @Override
    public boolean delete(CacheKey key) {
        OperationFuture future = mcc.delete(convertKey(key));
        return future.isDone();
    }

    /**
     * 设定key对应的value
     *
     * @param key        查找关键字
     * @param value      存储的数据块（可直接理解为key-value结构中的value）
     * @param expireTime 该数据的存活时间（分钟）
     */
    @Override
    public boolean set(CacheKey key, Object value, CacheTimeEnum expireTime) {
        OperationFuture future = mcc.set(convertKey(key), expireTime.value() * 60, value);
        return future.isDone();
    }

    /**
     * 将缓存Key对象转换为字符串
     *
     * @param key 外部传入的缓存键对象
     * @return 字符串化后的键
     */
    private String convertKey(CacheKey key) {
        if(key.getModuleName() == null ){
            //key.setModuleName(this.moduleName);
            key.setModuleName("");
        }
        if(key.getModuleName() == null || key.getModuleName().equals("")){
            throw new RuntimeException("模块名称必须定义");
        }
        String rtnKey = key.getModuleName() + "." + key.getModelName();
        // 如果有承租人ID，则拼接，否则拼All
        if (key.getTenantId() != null) {
            rtnKey += "." + key.getTenantId().toString();
        } else {
            rtnKey += ".All";
        }
        // 如果有模型对应的ID，则拼接，否则不拼接
        if (key.getModelKey() != null && !"".equals(key.getModelKey())) {
            rtnKey += "." + key.getModelKey();
        }

        return rtnKey;
    }
}
