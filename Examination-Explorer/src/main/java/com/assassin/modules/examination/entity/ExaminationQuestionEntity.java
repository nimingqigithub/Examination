package com.assassin.modules.examination.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
public class ExaminationQuestionEntity {

    private Long bsm; //标识码
    private String tmmc; //题目名称
    private String tmlx; //题目类型
    private Date gxsj; //更新时间
    private String kslx;//考试类型
    private List<ExaminationAnswerEntity> examinationAnswerEntityList;

    public Long getBsm() {
        return bsm;
    }

    public void setBsm(Long bsm) {
        this.bsm = bsm;
    }

    public String getTmmc() {
        return tmmc;
    }

    public void setTmmc(String tmmc) {
        this.tmmc = tmmc;
    }

    public String getTmlx() {
        return tmlx;
    }

    public void setTmlx(String tmlx) {
        this.tmlx = tmlx;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    public List<ExaminationAnswerEntity> getExaminationAnswerEntityList() {
        return examinationAnswerEntityList;
    }

    public void setExaminationAnswerEntityList(List<ExaminationAnswerEntity> examinationAnswerEntityList) {
        this.examinationAnswerEntityList = examinationAnswerEntityList;
    }

    public String getKslx() {
        return kslx;
    }

    public void setKslx(String kslx) {
        this.kslx = kslx;
    }
}
