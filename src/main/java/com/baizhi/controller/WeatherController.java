package com.baizhi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Slf4j
public class WeatherController {


    @GetMapping("/weather/getInfo")
    public Map<String,Object> getWeatherInfo(String cityName){
        Map<String, Object> map =  new HashMap<>();
        String weatherInfo = getCity(cityName);
        map.put("state",true);
        map.put("msg",weatherInfo);
        return map;
    }


    //提供天气查询数据
    public String getCity(String cityName){
        Map<String,String> map = new HashMap<>();
        map.put("北京","北京,今天晴转多云,局部地区伴有大雨,最高温度27度!");
        map.put("上海","上海,今天晴,局部地区伴有大雪,最高温度37度!");
        map.put("南京","南京,今天晴,局部地区伴有小雨,最高温度17度!");
        map.put("郑州","郑州,今天晴转多云,局部地区伴有雷阵雨,最高温度7度!");
        map.put("杭州","杭州,今天晴,局部地区伴有大风,最高温度9度!");
        map.put("天津","天津,今天晴转多云,最高温度16度!");
        return map.get(cityName);
    }



}
