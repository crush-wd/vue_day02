package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin //允许跨域请求
public class UserController {

    @Autowired
    private UserService userService;


    /*
    * 删除
    * */

    @GetMapping("/user/delete")
    public Map<String,Object> delete(String id){
        Map<String, Object> map = new HashMap<>();
        log.info("id:[{}]",id);
        try {
            userService.delete(id);
            map.put("state",true);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","删除失败");
        }
        return map;
    }

    /**
     * 添加
     */
    @PostMapping("/user/add")
    public Map<String,Object> add(@RequestBody  User user){
        log.info("================[{}]",user.getId());
        log.info("当前接收的用户为: [{}]",user);
        Map<String, Object> map = new HashMap<>();
        try {
            //StringUtils.isEmpty(user.getId())
            if(StringUtils.isEmpty(user.getId())){
                userService.save(user);
                log.info("[{}]",user);
                map.put("msg","保存成功!");
            }else{
                //修改操作
                userService.update(user);
                map.put("msg","编辑成功!");
            }
            map.put("state",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","保存失败!");
        }
        return  map;
    }

    /**
     * 查询所有
     *
     */
    @GetMapping("/user/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }


}
