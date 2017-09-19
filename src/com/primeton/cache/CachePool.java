package com.primeton.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存池
 *
 * @author Indrave
 */
public class CachePool {
    //缓存池唯一实例
    private static CachePool instance;

    //缓存Map
    private static Map<String, Object> cacheItems;

    private CachePool() {
        cacheItems = new HashMap<String, Object>();
    }

    /**
     * 获取唯一的实例
     *
     * @return instance
     */
    public synchronized static CachePool getInstance() {
        if (instance == null) {
            instance = new CachePool();
        }
        return instance;
    }

    /**
     * 清楚所有的缓存
     */
    public synchronized void clearAllItems() {
        cacheItems.clear();
    }

    /**
     * 获取缓存实例
     *
     * @param name 编号
     * @return object
     */
    public synchronized Object getCacheItem(String name) {
        if (!cacheItems.containsKey(name)) {
            return null;
        }
        CacheItem cacheItem = (CacheItem) cacheItems.get(name);
        if (cacheItem.isExpired()) {
            return null;
        }

        return cacheItem.getEntity();
    }

    /**
     * 存放缓存信息
     *
     * @param name    编号
     * @param obj     实例对象
     * @param expires 超时时长
     */
    public synchronized void putCacheItem(String name, Object obj, long expires) {
        if (!cacheItems.containsKey(name)) {
            cacheItems.put(name, new CacheItem(obj, expires));
        }
        CacheItem cacheItem = (CacheItem) cacheItems.get(name);
        cacheItem.setCreateTime(new Date());
        cacheItem.setEntity(obj);
        cacheItem.setExpireTime(expires);
    }


    /**
     * 清楚缓存信息
     *
     * @param name 编号
     */
    public synchronized void removeCacheItem(String name) {
        if (!cacheItems.containsKey(name)) {
            return;
        }
        cacheItems.remove(name);
    }

    /**
     * 获取缓存数据的数量
     *
     * @return int
     */
    public int getSize() {
        return cacheItems.size();
    }

}
