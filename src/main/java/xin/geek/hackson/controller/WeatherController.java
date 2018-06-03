package xin.geek.hackson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xin.geek.hackson.enity.Weather;
import xin.geek.hackson.enity.WeatherPK;
import xin.geek.hackson.repos.WeatherRepos;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherRepos weatherRepos;

    @Autowired
    public WeatherController(WeatherRepos weatherRepos) {
        this.weatherRepos = weatherRepos;
    }

    /*
     * 获得有city的 weather josn
     * */
    @RequestMapping(value = "getFamilyCity", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Weather> getFamilyCity(@RequestParam("id") String cId
    ) {

        return weatherRepos.getWeatherByFamilyIdAndCityIsNotNull(cId);
    }

    @RequestMapping(value = "findById", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Weather findById(WeatherPK cId
    ) {
        return weatherRepos.findById(cId).get();
    }

    @RequestMapping(value = "set", produces = {"application/json;charset=UTF-8"})
    public String register(Weather w) {
        weatherRepos.save(w);
        return "true";
    }

    @RequestMapping(value = "delete", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(WeatherPK sid) {
        weatherRepos.deleteById(sid);
        return "true";
    }


}
