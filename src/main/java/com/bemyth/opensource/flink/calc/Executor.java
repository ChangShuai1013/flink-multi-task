package com.bemyth.opensource.flink.calc;

import com.bemyth.opensource.entity.CalcData;
import com.bemyth.opensource.entity.procedure.DescriptionFile;
import com.bemyth.opensource.entity.procedure.Step;

/**
 * @Auther dier
 * @Date 9/29/2019 10:32
 * @Description
 */
public class Executor {

    // 顺序计算
    public static CalcData execute(CalcData calcData,DescriptionFile descriptionFile){
        for (Step step:descriptionFile.steps){
            AbstractOperator operator = null;
            switch (step.operater){
                case ADD:
                    operator = new ADDOperator(calcData,step);break;
                case SUB:
                    operator = new SUBOperator(calcData,step);break;
                case MUL:
                    operator = new MULOperator(calcData,step);break;
                case DIV:
                    operator = new DIVOperator(calcData,step);break;
            }
            calcData = operator.calc();
        }
        return calcData;
    }
}
