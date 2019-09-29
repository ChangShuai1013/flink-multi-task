package com.bemyth.opensource.entity.procedure;

public class DescriptionFile {
    public String descriptionFileName;
    public Integer taskID;

    public String method;
    public Step[] steps;

    public String  getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public Integer getCur() {
        return cur;
    }

    public void setCur(Integer cur) {
        this.cur = cur;
    }

    public Integer cur;

    public String getDescriptionFileName() {
        return descriptionFileName;
    }

    public void setDescriptionFileName(String descriptionFileName) {
        this.descriptionFileName = descriptionFileName;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }


    public Step[] getSteps() {
        return steps;
    }
    public void setSteps(Step... steps){
        this.steps = steps;
    }
}
