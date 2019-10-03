package com.cs.flink.calc;

import com.cs.flink.entity.CalcData;
import com.cs.flink.entity.procedure.Step;

/**
 * @Auther dier
 * @Date 9/29/2019 10:15
 * @Description
 */
public class ADDOperator extends AbstractOperator {
    @Override
    public CalcData calc() {
        calcData.data[step.outputs[0]] = calcData.data[step.inputs[0]] + calcData.data[step.inputs[1]];
        return calcData;
    }
    public ADDOperator(CalcData calcData, Step step){
        this.calcData = calcData;
        this.step = step;
    }
}
