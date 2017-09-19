package com.primeton.cache;

/**
 * 主测试类
 *
 * @author Indrave
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        //获取缓存池
        CachePool cachePool = CachePool.getInstance();

        Student stu1 = new Student("l1", "stu001", 25, 40);
        Student stu2 = new Student("l2", "stu002", 25, 40);
        Student stu3 = new Student("l3", "stu003", 25, 40);
        Student stu4 = new Student("l4", "stu004", 25, 40);

        cachePool.putCacheItem("001", stu1, 122222);
        cachePool.putCacheItem("002", stu2, 10);
        cachePool.putCacheItem("003", stu3, 360002);
        cachePool.putCacheItem("004", stu4, 1222222);

        //设置线程休眠，其中002会超时
        Thread.sleep(200);

        Student stu001 = (Student) cachePool.getCacheItem("001");
        if (stu001 != null) {
            System.out.println(stu001.getName());
        }

        //由于超时，这里取出的stu2对象为null
        Student stu002 = (Student) cachePool.getCacheItem("002");
        if (stu002 == null) {
            System.out.println("null");
        }

        //获取缓存池中的对象数量
        System.out.println(cachePool.getSize());

        //删除对象
        cachePool.removeCacheItem("002");

        System.out.println(cachePool.getSize());

    }


}
