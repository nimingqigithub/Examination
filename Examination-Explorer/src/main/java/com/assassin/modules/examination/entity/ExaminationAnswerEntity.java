package com.assassin.modules.examination.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/1.
 */
public class ExaminationAnswerEntity {


    private Long bsm; //标识码
    private Long kstmbsm; //考试题目标识码
    private String danr; //答案内容
    private String dalx; //答案类型
    private Date gxsj; //更新时间

    public Long getBsm() {
        return bsm;
    }

    public void setBsm(Long bsm) {
        this.bsm = bsm;
    }

    public Long getKstmbsm() {
        return kstmbsm;
    }

    public void setKstmbsm(Long kstmbsm) {
        this.kstmbsm = kstmbsm;
    }

    public String getDanr() {
        return danr;
    }

    public void setDanr(String danr) {
        this.danr = danr;
    }

    public String getDalx() {
        return dalx;
    }

    public void setDalx(String dalx) {
        this.dalx = dalx;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }
}
