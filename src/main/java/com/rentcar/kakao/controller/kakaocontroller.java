package com.rentcar.kakao.controller;


import com.rentcar.kakao.service.Kakaoservice;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class kakaocontroller {

    @Value("${kakao.url}")
    private String url;

    @Autowired
    private Kakaoservice kakaoservice;

    @GetMapping("/kakao_url/{lat}/{lng}")
    public JSONArray kakao_charge(@PathVariable("lat") String lat, @PathVariable("lng") String lng) throws IOException, ParseException {

        /*
        lat( x 좌표 ) lng( y 좌표 ) 가 카카오에서는 두 값을 바꾸어 입력해야 정상값이 도출된다.
         */
        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "=" + 1);
        urlBuilder.append("&" + URLEncoder.encode("sort", "UTF-8") + "=" + "accuracy");
        urlBuilder.append("&" + URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode("전기차충전소", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("x", "UTF-8") + "=" + lng);
        urlBuilder.append("&" + URLEncoder.encode("y", "UTF-8") + "=" + lat);
        urlBuilder.append("&" + URLEncoder.encode("radius", "UTF-8") + "=" + 2000); // 1km
        urlBuilder.append("&" + URLEncoder.encode("size", "UTF-8") + "=" + 15); // 0< x < 15


        return kakaoservice.getMap(urlBuilder);
    }

//    @GetMapping("map/{id}")
//    public void charge_info(@PathVariable("id") String id) throws IOException {
//        // 크롤링으로  http://place.map.kakao.com/id 의 페이지 일부만 가져옴.
//        String URL = "http://place.map.kakao.com/9122692";
//        Document doc = Jsoup.connect(URL).get();
//
//        Elements imageUrlElements = doc.getElementsByClass("electricChargingStation");
//
//        System.out.println(doc.html());  //html 출력
//    }

}
