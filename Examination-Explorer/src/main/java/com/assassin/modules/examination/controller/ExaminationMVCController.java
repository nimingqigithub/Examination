package com.assassin.modules.examination.controller;

import com.assassin.modules.examination.dao.ExaminationDao;
import com.assassin.modules.examination.entity.ExaminationQuestionEntity;
import com.assassin.modules.examination.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Controller
public class ExaminationMVCController {

    @Autowired
    ExaminationDao examinationDao;

    @RequestMapping(value = "examin_login",method = RequestMethod.GET)
    public ModelAndView ExaminaLogin(HttpServletResponse response, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("examination/examination");
        List<ExaminationQuestionEntity> examinationQuestionEntityList
                =examinationDao.selectAllQuestion();
        modelAndView.addObject("questionList",examinationQuestionEntityList);
        return modelAndView;
    }


}
