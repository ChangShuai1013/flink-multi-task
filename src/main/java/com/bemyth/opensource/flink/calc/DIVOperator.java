package com.bemyth.opensource.flink.calc;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.entity.procedure.Step;

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
