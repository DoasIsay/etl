package serialize.impl;

import config.FieldConfig;
import config.SerializerConfig;
import serialize.AbstractSerializer;
import serialize.Event;

import java.util.List;

public class LineSerializer extends AbstractSerializer<String> {
    private String split;

    @Override
    public void open(SerializerConfig config) {
        super.open(config);
        split = config.get("split");
    }

    @Override
    public String serialize(Event event) {
        StringBuilder sb = new StringBuilder();

        FieldConfigs.forEach(fieldConfig -> {
            sb.append((String) event.getField(fieldConfig.name)).append(split);
        });

        return sb.toString();
    }
}
