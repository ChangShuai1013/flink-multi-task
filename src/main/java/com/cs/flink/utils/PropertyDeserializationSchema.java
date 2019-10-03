package com.cs.flink.utils;

import com.cs.flink.entity.PropertyRecord;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.KeyedDeserializationSchema;

import java.io.IOException;

public class PropertyDeserializationSchema<K, V> implements KeyedDeserializationSchema<PropertyRecord<K, V>> {
    @Override
    public PropertyRecord<K, V> deserialize(byte[] bytes, byte[] bytes1, String s, int i, long l) throws IOException {
        return null;
    }

    @Override
    public boolean isEndOfStream(PropertyRecord<K, V> kvPropertyRecord) {
        return false;
    }

    @Override
    public TypeInformation<PropertyRecord<K, V>> getProducedType() {
        return null;
    }
}
