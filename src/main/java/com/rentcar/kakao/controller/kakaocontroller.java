package com.rentcar.kakao.controller;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@RestController
public class kakaocontroller {

    @Value("${kakao.url}")
    private String url;

    @Value("${kakao.ak}")
    private String ak;

    @GetMapping("/kakao_url")
    public JSONObject kakao_charge() throws IOException, ParseException {

        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "=" + 1);
        urlBuilder.append("&" + URLEncoder.encode("sort", "UTF-8") + "=" + "accuracy");
        urlBuilder.append("&" + URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode("주유소", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("size", "UTF-8") + "=" + 1);

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

        Map<String, String> result = new HashMap<>();

        return jsonObject;
    }

        /*

        {
        title: '카카오',
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },

     */
}
