package com.assassin.modules.examination.service;

import com.assassin.modules.examination.dao.ExaminationDao;
import com.assassin.modules.examination.entity.ExaminationAnswerEntity;
import com.assassin.modules.examination.entity.ExaminationQuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service
public class ExaminationService {

    @Autowired
    ExaminationDao examinationDao;


    /**
     * 批量写入考试题目信息
     * @param examinationQuestionEntityList
     * @return
     */
    public List<ExaminationQuestionEntity> saveQuestion(List<ExaminationQuestionEntity> examinationQuestionEntityList){

        for(ExaminationQuestionEntity examinationQuestionEntity: examinationQuestionEntityList){
            examinationQuestionEntity.setKslx("1");
            examinationDao.insertQuestion(examinationQuestionEntity);
            List<ExaminationAnswerEntity> examinationAnswerEntityList = examinationQuestionEntity.getExaminationAnswerEntityList();

            //设置答案条目的关联字段信息
            for(ExaminationAnswerEntity examinationAnswerEntity : examinationAnswerEntityList){
                examinationAnswerEntity.setKstmbsm(examinationQuestionEntity.getBsm());
            }
        }

        for(ExaminationQuestionEntity examinationQuestionEntity: examinationQuestionEntityList){

            List<ExaminationAnswerEntity> examinationAnswerEntityList = examinationQuestionEntity.getExaminationAnswerEntityList();
            examinationDao.insertAnswerBatch(examinationAnswerEntityList);
        }

        return examinationQuestionEntityList;
    }



}
