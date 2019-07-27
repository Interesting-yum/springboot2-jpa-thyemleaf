package com.example.demo.utility;

import org.springframework.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author liufei
 * @date 2019/4/17 14:30
 */
public class BeanCopierUtils {

    private static final int DEFAULT_INITIAL_CAPACITY = 100;
    private final static Map<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>(DEFAULT_INITIAL_CAPACITY);

    /**
     * 对象属性拷贝
     * @param srcObj 有值对象
     * @param destObj 无值目标对象
     */
    public static <S,D> void copy(S srcObj, D destObj) {
        if (Objects.isNull(srcObj)) {
            return;
        }
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, null);
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

}
