package com.bemyth.opensource.flink.sink;

import com.bemyth.opensource.entity.CustomizeData;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class CustomizeSink  extends RichSinkFunction<CustomizeData>{
    @Override
    public void open(Configuration parameters) throws Exception {
        System.out.println("sink open");
    }

    @Override
    public void close() throws Exception {
        System.out.println("sink close");
    }

    @Override
    public void invoke(CustomizeData value, Context context) throws Exception {
        System.out.println(value.toString());
    }
}