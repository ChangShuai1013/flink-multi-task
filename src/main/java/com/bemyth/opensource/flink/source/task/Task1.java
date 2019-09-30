package com.bemyth.opensource.flink.source.task;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.entity.procedure.DescriptionFile;
import com.bemyth.opensource.entity.procedure.Operater;
import com.bemyth.opensource.entity.procedure.Step;

/**
 * @Auther dier
 * @Date 9/30/2019 16:10
 * @Description
 */


    /*
     (T2 + T1 * 3) / 2
     0  1   2   3   4   5   6
            3   2
     T1 T2 C1   C2  P1  P2 P3
     */
public class Task1 {

    private static Integer taskID = 1;
    public static CalcData genCalcData(){
        Double[] data = new Double[7];
        data[2] = 3.0;
        data[3] = 2.0;
        data[0] = Math.random() * 100;
        data[1] = Math.random() * 100;

        return new CalcData(taskID,data);
    }
    public static DescriptionFile genDescription() {
        DescriptionFile d1 = new DescriptionFile();
        d1.taskID = taskID;
        d1.method = "UPDATE";

        Step step1 = new Step();
        step1.setInputs(0,2);
        step1.setOutputs(4);
        step1.setOperater(Operater.MUL);

        Step step2 = new Step();
        step2.setInputs(1,4);
        step2.setOutputs(5);
        step2.setOperater(Operater.ADD);

        Step step3 = new Step();
        step3.setInputs(5,3);
        step3.setOutputs(6);
        step3.setOperater(Operater.DIV);


        d1.setSteps(step1,step2,step3);

        return d1;
    }
}
