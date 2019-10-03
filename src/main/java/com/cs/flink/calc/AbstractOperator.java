package com.cs.flink.calc;

import com.cs.flink.entity.CalcData;
import com.cs.flink.entity.procedure.Step;

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
