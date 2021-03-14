package com.spring.mvc.cotroller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController  {



    @RequestMapping("/test.do")
    @ResponseBody                                                   //user 对象  Map
    public Object test(@RequestParam(name = "name") String name, HttpServletRequest request, HttpServletResponse response){
        System.out.println("调用了");
        request.getParameter("name");
        Map hashMap = new HashMap();
        hashMap.put("key","value");
        return  hashMap;
    }

	@PostMapping(value = "/test2.do")
	@ResponseBody                                                   //user 对象  Map
	public Object test2(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response){
		System.out.println("调用了");
		Map<String, Object> resutlMap = new HashMap();
		resutlMap.putAll(param);
		resutlMap.put("date", new Date());
		return  resutlMap;
	}

    @RequestMapping("/model.do")
//    @ResponseBody
    public String model(HttpServletRequest request,HttpServletResponse response){
        // /page/index.html
        return "index";
    }


}
