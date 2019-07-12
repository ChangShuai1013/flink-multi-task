package com.bemyth.opensource.flink;

import com.bemyth.opensource.entity.procedure.CustomizeDescriptionFile;
import com.bemyth.opensource.flink.source.CustomizeSource;
import com.bemyth.opensource.flink.task.CustomizeFlinkTask;

//public interface Framework {
//
//}
public  class Framework<T,R> {

    public Framework(){}

    public static CustomizeFlinkTask createTask(CustomizeDescriptionFile descriptionFile, CustomizeSource dataSource){
        return new CustomizeFlinkTask(descriptionFile,dataSource);
    }

}
