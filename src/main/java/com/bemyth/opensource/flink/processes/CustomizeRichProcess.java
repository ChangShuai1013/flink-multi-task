package com.bemyth.opensource.flink.processes;

import com.bemyth.opensource.entity.CustomizeData;
import com.bemyth.opensource.utils.Utils;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

public class CustomizeRichProcess extends RichFlatMapFunction<CustomizeData,CustomizeData> {
    private Integer[] inputs;
    private Integer[] outputs;
    @Override
    public void flatMap(CustomizeData value, Collector<CustomizeData> out) throws Exception {

    }

    @Override
    public void open(Configuration parameters) throws Exception {

        String sIn = parameters.getString("inputs","");
        String sOut = parameters.getString("outputs","");
        Integer[] inputs = Utils.string2IntergerArray(sIn,",");
        Integer[] outputs = Utils.string2IntergerArray(sOut,",");

        //super.open(parameters);
    }
}
