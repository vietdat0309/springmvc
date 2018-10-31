package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.utils.MessageResponseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NewController {
    @Autowired
    private INewService newService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView showNews(@ModelAttribute(SystemConstant.MODEL) NewDTO model) {
        ModelAndView mav = new ModelAndView("admin/new/list");
        /*Custom JPA*/
        //newService.findAll(model, new PageRequest(model.getPage(), model.getMaxPageItems()));

        /*Spring data jpa*/
        newService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
    public ModelAndView editNews(@ModelAttribute(SystemConstant.MODEL) NewDTO model,
                                 @RequestParam(value = "id", required = false) Long id, HttpServletRequest httpServletRequest) {
        ModelAndView mav = new ModelAndView("admin/new/edit");
        if(id != null){
            model = newService.findById(id);
        }
        initMessageResponse(mav, httpServletRequest);
        mav.addObject("categories", categoryService.getCategories());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest httpServletRequest) {
        String message = httpServletRequest.getParameter("message");
        if(StringUtils.isNotBlank(message)){
            Map<String, String> messageReponse = MessageResponseUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageReponse.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageReponse.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }
}
