package com.cs.flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.serialization.TypeInformationSerializationSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String sourceTopic = "test-in";
        String sinkTopic = "test-out";
        String broker = "localhost:9092";

        final ParameterTool parameterTool = ParameterTool.fromArgs(args);
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties p = parameterTool.getProperties();
        p.putAll(parameterTool.getProperties());
        p.put("bootstrap.servers", broker);
        see.getConfig().setGlobalJobParameters(parameterTool);

        TypeInformationSerializationSchema<String, byte[]>

        FlinkKafkaConsumer consumer = new FlinkKafkaConsumer<e>(sourceTopic, new SimpleStringSchema());
    }
}
