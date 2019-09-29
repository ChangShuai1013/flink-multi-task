package com.bemyth.opensource.entity;

public class CalcData {
    public Integer taskID;
    public Double[] data;

    public CalcData(Integer taskID, Double[] data){
        this.taskID = taskID;
        this.data = data;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("["+this.taskID+"]");
        for (Double d : data){
            stringBuilder.append(d);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

}
