package com.zxb.effective.chapter01.example01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Noninstantiable class for service registration and access 用于服务注册和访问的不可实例化的类
 * @author Mr.zxb
 * @date 2018-12-11 15:48
 */
public class ServiceImpl {

    /**
     * 防止实例化
     */
    private ServiceImpl() {}

    private static final Map<String, Provider> PROVIDERS = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    /**
     * 服务提供者注册API
     * @param provider
     */
    public static void registerDefaultProvider(Provider provider) {
        PROVIDERS.put(DEFAULT_PROVIDER_NAME, provider);
    }

    public static void registerDefaultProvider(String name, Provider provider) {
        PROVIDERS.put(name, provider);
    }

    /**
     * Service access API 服务访问API
     * @return
     */
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider provider = PROVIDERS.get(name);
        if (provider == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return provider.newService();
    }
}
