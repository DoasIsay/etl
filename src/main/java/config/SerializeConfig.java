package config;

import java.util.Map;

public class SerializeConfig {
    public Map<String, Object> config;
    public <T> T get(String key) { return (T) config.get(key); }
}