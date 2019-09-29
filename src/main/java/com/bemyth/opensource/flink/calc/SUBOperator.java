package com.bemyth.opensource.flink.calc;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.entity.procedure.Step;

/**
 * @Auther dier
 * @Date 9/29/2019 10:43
 * @Description
 */
public class SUBOperator extends AbstractOperator {
    @Override
    public CalcData calc() {
        calcData.data[step.outputs[0]] = calcData.data[step.inputs[0]] - calcData.data[step.inputs[1]];
        return calcData;
    }
    public SUBOperator(CalcData calcData, Step step){
        this.calcData = calcData;
        this.step = step;
    }
}
