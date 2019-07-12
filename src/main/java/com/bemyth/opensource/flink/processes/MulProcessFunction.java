package com.bemyth.opensource.flink.processes;

import com.bemyth.opensource.entity.CustomizeData;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

public class MulProcessFunction extends ProcessFunction<CustomizeData,CustomizeData> {
    @Override
    public void processElement(CustomizeData value, Context ctx, Collector<CustomizeData> out) throws Exception {
        // TODO 計算
        out.collect(value);
    }
}
