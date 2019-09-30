package com.bemyth.opensource.entity.procedure;


public class  Step {
    // 输入， 数据在数组中的编号
    public  Integer[] inputs;

    // 输出，数据编号
    public Integer[] outputs;

    //
    public Operater operater;

    public Step(Integer[] inputs,Integer[] outputs, Operater operater){
        this.inputs = inputs;
        this.outputs = outputs;
        this.operater = operater;
    }
    public Step(){}

    public void setInputs(Integer... inputs){
        this.inputs = inputs;
    }
    public void setOutputs(Integer... outputs){
        this.outputs = outputs;
    }
    public void setOperater(Operater operater){
        this.operater = operater;
    }
}
