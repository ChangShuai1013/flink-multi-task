package com.bemyth.opensource.flink.processes;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.entity.procedure.DescriptionFile;
import com.bemyth.opensource.flink.calc.Executor;
import org.apache.flink.api.common.state.BroadcastState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.StateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.state.KeyedStateFunction;
import org.apache.flink.streaming.api.TimerService;
import org.apache.flink.streaming.api.datastream.BroadcastStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.functions.co.KeyedBroadcastProcessFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther dier
 * @Date 9/29/2019 10:30
 * @Description
 */
public class CalcProcess extends KeyedBroadcastProcessFunction<Integer,CalcData, DescriptionFile,CalcData> {
    private  static Logger logger = LoggerFactory.getLogger(CalcProcess.class);
    MapStateDescriptor<Integer, DescriptionFile> descriptor;

    @Override
    public void open(Configuration configuration){
        logger.info("calc process open");
        this.descriptor = new MapStateDescriptor<>("description", Types.INT,Types.POJO(DescriptionFile.class));
    }
    /**
     * This method is called for each element in the (non-broadcast)
     * {@link KeyedStream keyed stream}.
     *
     * <p>It can output zero or more elements using the {@link Collector} parameter,
     * query the current processing/event time, and also query and update the local keyed state.
     * In addition, it can get a {@link TimerService} for registering timers and querying the time.
     * Finally, it has <b>read-only</b> access to the broadcast state.
     * The context is only valid during the invocation of this method, do not store it.
     *
     * @param value The stream element.
     * @param ctx   A {@link ReadOnlyContext} that allows querying the timestamp of the element,
     *              querying the current processing/event time and iterating the broadcast state
     *              with <b>read-only</b> access.
     *              The context is only valid during the invocation of this method, do not store it.
     * @param out   The collector to emit resulting elements to
     * @throws Exception The function may throw exceptions which cause the streaming program
     *                   to fail and go into recovery.
     */
    @Override
    public void processElement(CalcData value, ReadOnlyContext ctx, Collector<CalcData> out) throws Exception {
        DescriptionFile descriptionFile = ctx.getBroadcastState(this.descriptor).get(value.taskID);
        value = Executor.execute(value,descriptionFile);
        out.collect(value);
    }

    /**
     * This method is called for each element in the
     * {@link BroadcastStream broadcast stream}.
     *
     * <p>It can output zero or more elements using the {@link Collector} parameter,
     * query the current processing/event time, and also query and update the internal
     * {@link BroadcastState broadcast state}. In addition, it
     * can register a {@link KeyedStateFunction function} to be applied to all keyed states on
     * the local partition. These can be done through the provided {@link Context}.
     * The context is only valid during the invocation of this method, do not store it.
     *
     * @param value The stream element.
     * @param ctx   A {@link Context} that allows querying the timestamp of the element,
     *              querying the current processing/event time and updating the broadcast state.
     *              In addition, it allows the registration of a {@link KeyedStateFunction function}
     *              to be applied to all keyed state with a given {@link StateDescriptor} on the local partition.
     *              The context is only valid during the invocation of this method, do not store it.
     * @param out   The collector to emit resulting elements to
     * @throws Exception The function may throw exceptions which cause the streaming program
     *                   to fail and go into recovery.
     */
    @Override
    public void processBroadcastElement(DescriptionFile value, Context ctx, Collector<CalcData> out) throws Exception {
        BroadcastState<Integer, DescriptionFile> bcState= ctx.getBroadcastState(this.descriptor);
        switch (value.method){
            case "UPDATE":
                logger.info("get update");
                bcState.put(value.taskID,value);break;
            case "DELETE":
                bcState.remove(value.taskID);break;
        }
    }
}
