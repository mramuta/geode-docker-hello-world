package com.mram.geode;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloWorld {
    @GetMapping(value = "hello")
    public void hello(){
        ClientCache cache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .create();

        Region<String, String> region = cache
                .<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY)
                .create("hello");

        region.put("1", "Hello");
        region.put("2", "World");

        for (Map.Entry<String, String>  entry : region.entrySet()) {
            System.out.format("key = %s, value = %s\n", entry.getKey(), entry.getValue());
        }
        cache.close();
    }
}
