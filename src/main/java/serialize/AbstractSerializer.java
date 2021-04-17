package serialize;

import config.FieldConfig;
import config.SerializerConfig;

import java.util.List;

public abstract class AbstractSerializer<T> implements Serializer<T>{
    private SerializerConfig Config;
    public List<FieldConfig> FieldConfigs;

    @Override
    public void open(SerializerConfig config) {
        this.Config = config;
        this.FieldConfigs = config.fieldConfigs;
    }

    @Override
    public void close() {

    }
}
