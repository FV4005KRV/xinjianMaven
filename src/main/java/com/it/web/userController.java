package com.it.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.myexception.myaop;
import com.it.pojo.User;
import com.it.service.userService;
import com.it.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("usera")
public class userController {
    private static final String  UPLOAD_FILE_PATH = "/statics/imgs/";
    @Autowired
    private userService us;
    private myaop myaop;
    @RequestMapping("qwe")
    public ModelAndView getCount(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    //查询所有
    @RequestMapping("list")
    public String getUserList(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,10);
        List<User> userlist = us.getUserlist();
        PageInfo<User> pv = new PageInfo<>(userlist,10);
        model.addAttribute("pv",pv);
        System.out.println("pv="+pv);
        return "userlist";
    }
    //添加
    @RequestMapping("addorupdateuser")
    public String addUsers(User user, MultipartFile pic, HttpServletRequest req) throws IOException {
        if (pic != null&&!pic.isEmpty()){
            System.out.println("456");
            String oriname = pic.getOriginalFilename();
            String ext = oriname.substring(oriname.lastIndexOf("."));
            //最终路径
            System.out.println("ext="+ext);
            String s = UUIDUtil.getDate()+UUIDUtil.getUUID()+ext;
            String storepath = UPLOAD_FILE_PATH + s;
            String realPath = req.getServletContext().getRealPath(UPLOAD_FILE_PATH);
            String s1 = realPath +"\\"+ s;
            File file = new File(s1);
            if (!file.exists()){
                file.mkdirs();
            }
            pic.transferTo(file);
            user.setPhoto(storepath);
        }
        if (user.getId()!=null){
            User userById = us.getUserById(user.getId());
            userById.setUsername(user.getUsername());
            userById.setAge(user.getAge());
            userById.setMoney(user.getMoney());
            userById.setPwd(user.getPwd());
            userById.setPhoto(user.getPhoto());
            us.upate(userById);
        }else {
            us.saveUser(user);
        }
        return "redirect:/usera/list";
    }
    @RequestMapping("del/{id}")
    public String del(@PathVariable("id") Integer id, Model model){
        us.delUser(id);
        System.out.println("888888888");
        return "redirect:/usera/list";
    }
    @RequestMapping("up/{id}")
    public String getId(@PathVariable("id") Integer id, Model model){
        User user = us.getUserById(id);
        model.addAttribute("ua",user);
        System.out.println("qwe="+user);
        return "userupd";
    }

}
