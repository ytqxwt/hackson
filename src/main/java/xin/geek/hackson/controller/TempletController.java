package xin.geek.hackson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xin.geek.hackson.enity.Family;
import xin.geek.hackson.enity.Templet;
import xin.geek.hackson.repos.TempletRepos;

@RestController
@RequestMapping("/templet")
public class TempletController {
    private final TempletRepos templetRepos;

    @Autowired
    public TempletController(TempletRepos templetRepos) {
        this.templetRepos = templetRepos;
    }

    @RequestMapping(value = "findById", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Templet findById(@RequestParam("id") String cId
    ) {
        return templetRepos.findById(cId).get();
    }

    @RequestMapping(value = "set", produces = {"application/json;charset=UTF-8"})
    public String register(Templet templet) {
        templetRepos.save(templet);
        return "true";
    }

    @RequestMapping(value = "delete", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(@RequestParam("id") String sid) {
        templetRepos.deleteById(sid);
        return "true";
    }
}
