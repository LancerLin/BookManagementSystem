package cn.lightina.managebooks.controller;

import cn.lightina.managebooks.pojo.User;
import cn.lightina.managebooks.service.UserService;
import cn.lightina.managebooks.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/managebooks")
public class RegisterController {
    @Autowired
    UserServiceimpl userService;

    @GetMapping(value = "/register")
    public  String register(){return "register";}

    @GetMapping(value = "/register/login")
    public String login(){return  "login";}

    //@PostMapping(value = "register/addregister")
    @GetMapping(value = "/register/addregister")
    public String addregister(Model model,
                            HttpServletRequest request){

        String userName = request.getParameter("username");
        String rname =request.getParameter("rname");
        User user =new User();
        user.setUserName(request.getParameter("username"));
        user.setRname(request.getParameter("rname"));
        user.setPassWd(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phoneNum"));
        user.setUserId(Integer.valueOf(request.getParameter("userid")));


        String username = request.getParameter("username");
        if(userService.findByName(userName)!=null){
            //User is exist
            return "register_failed";
        }else {

            userService.addUser(user);
            return "login";
        }

    }


}
