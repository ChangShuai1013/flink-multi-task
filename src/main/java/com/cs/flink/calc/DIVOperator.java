package com.cs.flink.calc;

import com.cs.flink.entity.CalcData;
import com.cs.flink.entity.procedure.Step;

/**
 * @Auther dier
 * @Date 9/29/2019 10:46
 * @Description
 */
public class DIVOperator extends AbstractOperator {
    @Override
    public CalcData calc() {
        calcData.data[step.outputs[0]] = calcData.data[step.inputs[0]] / calcData.data[step.inputs[1]];
        return calcData;
    }

    public DIVOperator(CalcData calcData, Step step){
        this.calcData = calcData;
        this.step = step;
    }
}
