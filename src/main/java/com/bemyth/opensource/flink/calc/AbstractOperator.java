package com.bemyth.opensource.flink.calc;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.entity.procedure.Step;

/**
 * @Auther dier
 * @Date 9/29/2019 10:16
 * @Description
 */
public abstract class AbstractOperator {
    protected Step step;
    protected CalcData calcData;
    public abstract CalcData calc();
}
