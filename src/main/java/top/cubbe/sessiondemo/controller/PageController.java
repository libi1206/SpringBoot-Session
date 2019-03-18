package top.cubbe.sessiondemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author libi
 */
@RestController
@PropertySource("/application.properties")
public class PageController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        return "port:"+port;
    }

    @RequestMapping("/set")
    public String setAttr(HttpServletRequest request, String attr) {
        request.getSession().setAttribute("name",attr);
        return "成功"+port;
    }

    @RequestMapping("/get")
    public String getAttr(HttpServletRequest request) {
        return "port"+port+":"+(String) request.getSession().getAttribute("name")+";"+request.getSession().getId();
    }
}
