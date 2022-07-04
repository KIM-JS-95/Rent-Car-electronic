package com.rentcar.kakao.controller;



import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class kakaocontroller {

    @Value("${kakao.url}")
    private String url;

    @Value("${kakao.ak}")
    private String ak;

    @GetMapping("/kakao_url")
    public JSONArray kakao_charge() throws IOException, ParseException {

        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "=" + 1);
        urlBuilder.append("&" + URLEncoder.encode("sort", "UTF-8") + "=" + "accuracy");
        urlBuilder.append("&" + URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode("전기차충전소", "UTF-8"));

        // size max is 1<=x<=15
        urlBuilder.append("&" + URLEncoder.encode("size", "UTF-8") + "=" + 15);

        System.out.println(urlBuilder);

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "KakaoAK " + ak);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");


        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            System.out.println("에러발생!");
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }


        rd.close();
        conn.disconnect();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(sb.toString());
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get("documents");
        System.out.println(array);

        // 사용자 기준으로 가장 가까운 주유소 검색
        // x,y 값을 여기서 계산하자
        Map<String, Object[]> map = new HashMap<>();
        for(int i=0; i<array.size(); i++){
            JSONObject obj1 = (JSONObject) array.get(i);
//            System.out.println(obj1.get("x"));
//            System.out.println(obj1.get("y"));
            Object[] val = {obj1.get("x"), obj1.get("y")};
            //map.add(obj1.get(""), val);
            //map.put("coordinate", val);
        }

        return array;
    }

        /*

        {
        title: '카카오',
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },

     */
}
