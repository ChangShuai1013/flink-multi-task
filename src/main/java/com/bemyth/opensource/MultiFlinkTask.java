package com.bemyth.opensource;

import com.bemyth.opensource.entity.procedure.CustomizeDescriptionFile;
import com.bemyth.opensource.entity.procedure.Operater;
import com.bemyth.opensource.entity.procedure.Step;
import com.bemyth.opensource.flink.Framework;
import com.bemyth.opensource.flink.source.CustomizeSource;
import com.bemyth.opensource.flink.task.CustomizeFlinkTask;

public class MultiFlinkTask {
    public static void main(String[] args){

        CustomizeDescriptionFile descriptionFile = newDescriptionFile1();


        CustomizeFlinkTask task = Framework.createTask(descriptionFile,new CustomizeSource(descriptionFile));

        try {
            task.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /*  (a+b) * (b-c)
     t1 = a + b
     t2 = b - c
     t3 = t1 * t2
             0 1 2 3  4  5
      data[] a b c T1 T2 T3
     */
    public static CustomizeDescriptionFile newDescriptionFile1(){


        Step step1 = new Step();
        step1.setInputs(0,1);
        step1.setOutputs(3);
        step1.setOperater(Operater.ADD);

        Step step2 = new Step();
        step2.setInputs(1,2);
        step2.setOutputs(4);

        Step step3 = new Step();
        step3.setInputs(3,4);
        step3.setOutputs(5);


        CustomizeDescriptionFile descriptionFile = new CustomizeDescriptionFile();
        descriptionFile.descriptionFileName  = "test1";
        descriptionFile.setSteps(step1,step2,step3);
        descriptionFile.setAllLen(6);
        descriptionFile.setMetaLocs(0,1,2);

        return descriptionFile;
    }
}
