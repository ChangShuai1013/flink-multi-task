package com.bemyth.opensource.flink.source;

import com.bemyth.opensource.entity.CustomizeData;
import com.bemyth.opensource.entity.procedure.CustomizeDescriptionFile;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @param allLen  数据总长度.
 * @param metaLocs 原始数据位置.
 *
 *@Example 一个符合要求的数据包如下所示，该数据包中实际数据为 a,b,c; 需要计算生成的数据为 T1, T2, T3
 *所以 allLen = 6, metalocs = {0,1,2}
 *   0  1   2   3   4   5
 *   a  b   c   T1  T2  T3
 */
public class CustomizeSource extends RichSourceFunction<CustomizeData> {
    private  Logger logger = LoggerFactory.getLogger("source logger");
    private  Integer allLen;
    private  Integer[] metaLocs;
    @Override
    public void run(SourceContext<CustomizeData> ctx) throws Exception {
        while (true){
            Double[] data = new Double[this.allLen];
            for(Integer loc:this.metaLocs){
                data[loc] = Math.random();
            }
            CustomizeData customizeData = new CustomizeData(data);
            ctx.collect(customizeData);
            Thread.sleep(1000);
        }
    }
    @Override
    public void cancel() {
        logger.warn("source canceled");
    }
    @Override
    public void open(Configuration parameters) throws Exception {
        logger.warn("source opened");
        //super.open(parameters);
    }
    @Override
    public void close(){
        logger.warn("source closed");
    }

    public CustomizeSource(CustomizeDescriptionFile descriptionFile){
        this.allLen = descriptionFile.allLen;
        this.metaLocs = descriptionFile.metaLocs;
    }
}
