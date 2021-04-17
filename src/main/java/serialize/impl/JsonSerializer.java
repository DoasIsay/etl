package serialize.impl;

import com.google.gson.Gson;
import config.FieldConfig;
import config.SerializerConfig;
import serialize.AbstractSerializer;
import serialize.Event;

import java.util.HashMap;
import java.util.List;

public class JsonSerializer extends AbstractSerializer<String> {
    private Gson gson;

    @Override
    public void open(SerializerConfig config) {
        super.open(config);
        gson = new Gson();
    }
    @Override
    public String serialize(Event event) {
        HashMap<String,String> map = new HashMap<>();
        FieldConfigs.forEach(fieldConfig -> {
            map.put(fieldConfig.name, event.getField(fieldConfig.name));
        });

        return gson.toJson(map);
    }
}
