package com.assassin.modules.examination.controller;

import com.assassin.exception.ExceptionUtils;
import com.assassin.exception.AssassinException;
import com.assassin.modules.examination.entity.ExaminationQuestionEntity;
import com.assassin.modules.examination.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@RestController
public class ExaminationController {


    @Autowired
    ExaminationService examinationService;

    @RequestMapping(value="saveExaminationQuestion",method = RequestMethod.POST,produces = "application/json")
    public List<ExaminationQuestionEntity> saveExaminationQuestion(@RequestBody List<ExaminationQuestionEntity> examinationQuestionEntityList
                                          ,HttpServletRequest request, HttpServletResponse response){
        try{
             return examinationService.saveQuestion(examinationQuestionEntityList);
        }
        catch(Exception er){
            ExceptionUtils.LoadLog(er);
            throw new AssassinException(ExceptionUtils.DealErrorMsg(er));
        }
    }
}
