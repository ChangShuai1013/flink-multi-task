package com.bemyth.opensource.flink.source;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.flink.source.task.Task1;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @allLen  数据总长度.
 * @metaLocs 原始数据位置.
 *
 */
public class CalcDataSource extends RichSourceFunction<CalcData> {
    private  static Logger logger = LoggerFactory.getLogger(CalcDataSource.class);
    @Override
    public void run(SourceContext<CalcData> ctx) throws Exception {
        logger.info("calc source run");
        while (true){
            ctx.collect(Task1.genCalcData());
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        System.out.println("calc source canceled");
    }
    @Override
    public void open(Configuration parameters) throws Exception {
        logger.info("calc source open");
    }
    @Override
    public void close(){
        logger.info("calc source closed");
    }

    public CalcDataSource(){
    }
}
