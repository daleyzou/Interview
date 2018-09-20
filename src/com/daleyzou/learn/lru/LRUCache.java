package com.daleyzou.learn.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: DaleyZou
 * @Description: 使用 LinkedHashMap 实现LRU Cache
 * @Date: Created in 20:43 2018-9-19
 * @Modified By:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRUCache(int cacheSize){
        // 默认是按照插入的顺利进行排序，在这里我们使用 “访问” 的顺序进行排序
        super(16, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    // 重写方法判断 移除最久未使用的数据

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    // 测试是否成功
    public static void main(String[] args){
        Map<Integer, Integer> map = new LRUCache<>(4);

        map.put(3,4);
        map.put(4,5);
        map.put(5,6);
        map.put(6,7);
        map.put(7,8);

        // 查看是否有数据被删除
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();iterator.hasNext();){
            System.out.println(iterator.next().getKey());
        }
    }
}
