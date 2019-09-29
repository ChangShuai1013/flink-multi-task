package com.bemyth.opensource.flink.source;

import com.bemyth.opensource.entity.CalcData;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @allLen  数据总长度.
 * @metaLocs 原始数据位置.
 *
 *@Example 一个符合要求的数据包如下所示，该数据包中实际数据为 a,b,c; 需要计算生成的数据为 T1, T2, T3
 *所以 allLen = 6, metalocs = {0,1,2}
 *   0  1   2   3   4   5
 *   a  b   c   T1  T2  T3
 */
public class CalcDataSource extends RichSourceFunction<CalcData> {
    private  static Logger logger = LoggerFactory.getLogger(CalcDataSource.class);
    @Override
    public void run(SourceContext<CalcData> ctx) throws Exception {
        logger.info("calc source run");
        while (true){
            Thread.sleep(1000);
        }
    }

    public void createD1Data(){
        Double[] data = new Double[6];
        data[0]
        new CalcData(1,);
    }
    @Override
    public void cancel() {
        System.out.println("calc source canceled");
    }
    @Override
    public void open(Configuration parameters) throws Exception {
        System.out.println("calc source opened");
    }
    @Override
    public void close(){
        System.out.println("calc source closed");
    }

    public CalcDataSource(){
    }
}
