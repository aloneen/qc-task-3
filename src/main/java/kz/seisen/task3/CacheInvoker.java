package kz.seisen.task3;

import java.lang.reflect.Method;
import java.util.*;

public class CacheInvoker {

    private final Map<String, Object> cache = new HashMap<>();

    public Object invoke(Object target, String methodName, String... args) throws Exception {

        // получаем метод через Reflection
        Class<?>[] types = new Class<?>[args.length];
        Arrays.fill(types, String.class);
        Method method = target.getClass().getMethod(methodName, types);

        // если нету аннотации то просто вызываем
        if (!method.isAnnotationPresent(CacheResult.class)) {
            return method.invoke(target, (Object[]) args);
        }

        // ключ из имени метода и аргументов
        String key = methodName + Arrays.toString(args);

        // есть в кеше то возвращаем
        if (cache.containsKey(key)) {
            System.out.println("Return from cache");
            return cache.get(key);
        }

        // нету в кеше, вызываем и сохраняем
        Object result = method.invoke(target, (Object[]) args);
        cache.put(key, result);
        return result;
    }
}