package com.cs.flink.task;

import com.cs.flink.entity.CalcData;
import com.cs.flink.entity.procedure.DescriptionFile;
import com.cs.flink.processes.CalcProcess;
import com.cs.flink.sink.CustomizeSink;
import com.cs.flink.source.CalcDataSource;
import com.cs.flink.source.DescriptionSource;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.BroadcastStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Auther dier
 * @Date 9/29/2019 10:10
 * @Description 这个任务包含原始数据
 */
public class OTask  {
    private StreamExecutionEnvironment env;

    public OTask(){
        this.env = StreamExecutionEnvironment.getExecutionEnvironment();
    }

    public void buildDAG(){

        DataStream<CalcData> calcDataDataStream = env.addSource(new CalcDataSource()).name("CalcDataStream");
        DataStream<DescriptionFile> descriptionFileDataStream = env.addSource(new DescriptionSource()).name("DescriptionStream");

        KeyedStream<CalcData,Integer> calcDataByTaskID = calcDataDataStream.
                keyBy((KeySelector<CalcData,Integer>) calcData -> calcData.taskID);

        MapStateDescriptor<Integer,DescriptionFile> mapStateDescriptor = new MapStateDescriptor<>("description", Types.INT,Types.POJO(DescriptionFile.class));
        BroadcastStream<DescriptionFile> bcedDescriptions = descriptionFileDataStream.broadcast(mapStateDescriptor);


        calcDataByTaskID.connect(bcedDescriptions).
                process(new CalcProcess()).name("CalcProcess").setParallelism(2)
                .addSink(new CustomizeSink()).name("CustomizeSink").setParallelism(1);
    }
    public void run() throws Exception{
        this.env.execute();
    }

    public static void main(String[] args) throws Exception{
        OTask task = new OTask();
        task.buildDAG();
        task.run();
    }
}
