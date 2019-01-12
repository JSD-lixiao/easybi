package org.imw.easybi.controller;

import org.imw.easybi.pojo.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class HomeController extends BaseController{

    @RequestMapping("/")
    public String defaultIndex(){
        return "login";
    };

    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping("/index")
    public String index(@AuthenticationPrincipal Principal principal, ModelMap modelMap){
        setUserNameAndAuthorities(principal, modelMap);
        return "starter";
    }

    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, ModelMap modelMap){
        setUserNameAndAuthorities(principal, modelMap);
        return "/user/user";
    }

    @RequestMapping("/register")
    public String register(){
        return "userManage";
    }
    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, ModelMap modelMap){
        setUserNameAndAuthorities(principal, modelMap);
        return "/admin/admin";
    }

    /*@RequestMapping("/index")
    public String index(@AuthenticationPrincipal Principal principal, ModelMap modelMap){
        setUserNameAndAuthorities(principal, modelMap);
        return "index";
    }*/

    private void setUserNameAndAuthorities(Principal principal, ModelMap modelMap){
        String username = null;
        if (principal!=null){
            username = principal.getName();
       }
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        modelMap.addAttribute("authorities",authorities);
        modelMap.addAttribute("username",username);
    }
}
