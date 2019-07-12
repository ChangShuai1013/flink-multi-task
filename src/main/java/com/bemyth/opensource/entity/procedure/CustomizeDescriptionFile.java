package com.bemyth.opensource.entity.procedure;

public class CustomizeDescriptionFile {
    public String descriptionFileName;
    public Integer allLen;
    public Integer[] metaLocs;
    public Step[] steps;

    public void setSteps(Step... steps){
        this.steps = steps;
    }
    public void setAllLen(Integer allLen){
        this.allLen = allLen;
    }
    public void setMetaLocs(Integer... metaLocs){
        this.metaLocs = metaLocs;
    }
}
