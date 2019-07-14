package com.bemyth.opensource.entity;

public class CustomizeData {
    public Double[] data;

    public CustomizeData(Double[] data){
        this.data = data;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Double d : data){
            stringBuilder.append(d);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

}
