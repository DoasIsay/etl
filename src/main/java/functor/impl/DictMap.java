package functor.impl;

import util.Dictionary;
import config.FunctorConfig;
import functor.AbstractFunctor;
import functor.Functor;

import java.util.List;
import java.util.Map;

public class DictMap extends AbstractFunctor {
    private Map<String, Object> dictionary;

    @Override
    public Functor open(FunctorConfig config) {
        super.open(config);
        dictionary = Dictionary.getInstance().load(config.get("namespace"), config.get("dictionary"));
        return this;
    }

    @Override
    public boolean invoke() {
        if (InFieldValue.isEmpty())
            return false;

        List<String> outFieldValues = (List<String>) dictionary.get(InFieldValue);
        assert(OutFieldNames.size() == outFieldValues.size());

        for (int i = 0; i < OutFieldNames.size(); ++i)
            setField(OutFieldNames.get(i), outFieldValues.get(i));

        return true;
    }

    @Override
    public void close() {
        dictionary.clear();
    }
}