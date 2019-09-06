package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.Order;
import com.example.demo.utils.CommResult;

@Controller
@RequestMapping("/order")

/**
 * 此处要和client1，的/queryOrder，处重写，更好的看出结果。
 * 还有，springboot拦截器和跨域的问题没有得到解决。即，如果执行了跨域，那拦截器就不会生效。
 * @author b
 */
public class OrderController {
    @RequestMapping(value="/queryOrder",method = RequestMethod.GET)
    @ResponseBody
    public Object queryOrder() {
		Order order=new Order();
		order.setOrder("我是假订单[ddxxx129908]");
		return CommResult.build(200, "cs", order);
    }
    
}
