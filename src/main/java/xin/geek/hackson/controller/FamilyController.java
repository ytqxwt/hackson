package xin.geek.hackson.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xin.geek.hackson.enity.Family;
import xin.geek.hackson.repos.FamilyRepos;

@RestController
@RequestMapping("/family")
public class FamilyController {
    private final FamilyRepos familyRepos;

    @Autowired
    public FamilyController(FamilyRepos familyRepos) {
        this.familyRepos = familyRepos;
    }

    @RequestMapping(value = "findById", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Family findById(@RequestParam("id") Long cId
    ) {
        return familyRepos.findById(cId).get();
    }

    @RequestMapping(value = "set", produces = {"application/json;charset=UTF-8"})
    public String register(@RequestParam("name") String name, @RequestParam("count") String count) {
        familyRepos.save(new Family(name, count));
        return "true";
    }

    @RequestMapping(value = "delete", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(@RequestParam("id") Long sid) {
        familyRepos.deleteById(sid);
        return "true";
    }

}
