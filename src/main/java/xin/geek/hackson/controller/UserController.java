package xin.geek.hackson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xin.geek.hackson.enity.Family;
import xin.geek.hackson.enity.User;
import xin.geek.hackson.repos.UserRepos;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepos userRepos;

    @Autowired
    public UserController(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @RequestMapping(value = "findById", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public User findById(@RequestParam("openId") String openId
    ) {
        return userRepos.findById(openId).get();
    }

    @RequestMapping(value = "set", produces = {"application/json;charset=UTF-8"})
    public String register(@RequestParam("openId") String openId,
                           @RequestParam(value = "role") String role,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "birthday", required = false) String birthday,
                           @RequestParam(value = "familyId", required = false) String familyId,
                           @RequestParam(value = "city", required = false) String city
    ) {
        User u = new User(openId, role, familyId);
        userRepos.save(u);
        return "true";
    }

    @RequestMapping(value = "delete", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(@RequestParam("openId") String openId) {
        userRepos.deleteById(openId);
        return "true";
    }

}
