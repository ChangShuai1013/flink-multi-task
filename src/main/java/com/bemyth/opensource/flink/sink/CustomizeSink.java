package com.bemyth.opensource.flink.sink;

import com.bemyth.opensource.entity.CalcData;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class CustomizeSink  extends RichSinkFunction<CalcData>{
    @Override
    public void open(Configuration parameters) throws Exception {
        System.out.println("sink open");
    }

    @Override
    public void close() throws Exception {
        System.out.println("sink close");
    }

    @Override
    public void invoke(CalcData value, Context context) throws Exception {
        System.out.println(value.toString());
    }
}