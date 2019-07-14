package com.bemyth.opensource.flink.processes;

import com.bemyth.opensource.entity.CustomizeData;
import com.bemyth.opensource.utils.Utils;
import org.apache.flink.api.common.functions.AbstractRichFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import java.io.Serializable;

public  class AddProcessFunction extends ProcessFunction<CustomizeData,CustomizeData>{

    private Integer[] inputs;
    private Integer[] outputs;
    @Override
    public void processElement(CustomizeData value, Context ctx, Collector<CustomizeData> out) throws Exception {
        // 加法 两输入 一输出
        value.data[outputs[0]] = value.data[inputs[0]] + value.data[inputs[1]];
        out.collect(value);
    }
    @Override
    public void open(Configuration parameters){
        String sIn = parameters.getString("inputs","");
        String sOut = parameters.getString("outputs","");
        this.inputs = Utils.string2IntergerArray(sIn,",");
        this.outputs = Utils.string2IntergerArray(sOut,",");
        if (!validate(this.inputs,this.outputs)){
            // TODO
        }
    }

    // 加法 两输入 一输出
    // 验证输入输出是否合法
    private Boolean validate(Integer[] in, Integer[] out){
        return true;
    }
}
