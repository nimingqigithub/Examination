package com.assassin.modules.examination.dao;

import com.assassin.common.MyBatisDao;
import com.assassin.modules.examination.entity.ExaminationAnswerEntity;
import com.assassin.modules.examination.entity.ExaminationQuestionEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@MyBatisDao
public interface ExaminationDao {
    /**
     * 插入问题
     * @param examinationQuestionEntity
     */
    void insertQuestion(ExaminationQuestionEntity examinationQuestionEntity);

    /**
     * 插入答案选项
     * @param examinationAnswerEntity
     */
    void insertAnswer(ExaminationAnswerEntity examinationAnswerEntity);

    /**
     * 批量插入答案选项
     * @param examinationAnswerEntityList
     */
    void insertAnswerBatch(List<ExaminationAnswerEntity> examinationAnswerEntityList);

    /**
     * 获取所有考试题目
     * @return
     */
    List<ExaminationQuestionEntity> selectAllQuestion();
}
