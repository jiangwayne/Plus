package com.plus.server.controller.ftl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import com.github.pagehelper.PageInfo;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.OrderVo;
import com.plus.server.common.vo.ProductVo;
import com.plus.server.model.Order;
import com.plus.server.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plus.server.common.util.EmailUtil;
import com.plus.server.common.util.MsgUtil;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.controller.BaseController;
import com.plus.server.controller.LoginController;
import com.plus.server.model.User;
import com.plus.server.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by jiangwulin on 16/6/11.
 */
@Controller
@RequestMapping(value = "ftl/order")
public class FtlOrderController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private OrderService orderService;


    private void fillDateStr(OrderVo vo){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd Hh:mm:ss");
        if(vo.getGmtCreate() != null){
            vo.setGmtCreateStr(f.format(vo.getGmtCreate()));
        }
    }

    @RequestMapping(value = "/list")
    public ModelAndView orderList(Model model,String keywords, Integer productType, Integer page, Integer pageSize) {
        ModelAndView mv = new ModelAndView("orderList.ftl");
        Order obj = new Order();

        obj.setValid(1);
        try {
            PageInfo<Order> pageInfo = orderService.selectByProductType(obj, page, pageSize, productType, keywords);
            if(pageInfo != null && pageInfo.getList() != null){
                List<OrderVo> list = BeanMapper.mapList(pageInfo.getList(), OrderVo.class);
                for(OrderVo vo : list){
                    fillDateStr(vo);
                }
                model.addAttribute("list", list);
            }
            model.addAttribute("pages",pageInfo.getPages());
            model.addAttribute("page",pageInfo.getPageNum());
            model.addAttribute("total",pageInfo.getTotal());
            model.addAttribute("keywords", keywords);
            model.addAttribute("productType", productType);
        } catch (Exception e) {
            log.error("", e);
        }
        return mv;
    }

}
