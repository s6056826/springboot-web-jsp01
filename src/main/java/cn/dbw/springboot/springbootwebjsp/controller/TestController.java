package cn.dbw.springboot.springbootwebjsp.controller;


import cn.dbw.springboot.springbootwebjsp.mapper.LoginUserMapper;
import cn.dbw.springboot.springbootwebjsp.po.LoginUser;
import cn.dbw.springboot.springbootwebjsp.service.BaseService;
import cn.dbw.springboot.springbootwebjsp.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController<LoginUser> {
//    @Autowired
//    JdbcTemplate jdbcTemplate=null;
    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    LoginUserService loginUserService;

    @GetMapping("bbbc")
    public String aa(Model model){
          model.addAttribute("name","dbw");
          model.addAttribute("namc","dbw");
          return "aaa";
    }
//    @GetMapping("aa")
//    @ResponseBody
//    public Object json(){
//        String sql="select * from login_user where pname = ?";
//        Map<String, Object> map = jdbcTemplate.queryForMap(sql, "ccc");
//        return map;
//    }
    @RequestMapping("/json2")
    @ResponseBody
    public Object json2(){
        LoginUser loginUser = loginUserMapper.selectByPrimaryKey(1);
        return  loginUser;

    }

    @Override
    public BaseService<LoginUser> getBaseService() {
        return loginUserService;
    }
}
