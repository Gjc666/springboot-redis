package com.mr.controller;

import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/5/30.
 */
@Controller
public class UserController {
        @Autowired
        private UserService userService;
    /*@RequestMapping("chaUser")
    public String chaUser(ModelMap map){
        map.put("name","zs");
        return "main";
    }*/

    /**
     * 查询
     */
    @GetMapping("/userList")
    public String userList(ModelMap map){
        List<User> list = userService.userList();
        map.put("list",list);
        return "main";
    }
    /**
     * 删除
     */
    @DeleteMapping("/user/{id}")
    public String userDel(@PathVariable("id") Integer id){
        userService.userDel(id);
        return "redirect:/userList";
    }
    /**
     * 跳转新增页面
     */
    @RequestMapping("toAddPage")
    public String toAddPage(){
        return "add";
    }

   @PostMapping("/addUser")
    public String addUser(User user){
         userService.addUser(user);
        return "redirect:/userList";
    }
    /**
     * 修改
     */
   @GetMapping("/toUpdatePage/{id}")
    public String updatePage(@PathVariable Integer id , ModelMap map){
       User user = userService.findId(id);
       map.put("user",user);
       return "update";
   }

   @PutMapping("/updateUser")
   public String updateUser(User user){
       userService.updateUser(user);
       return "redirect:/userList";
   }
}
