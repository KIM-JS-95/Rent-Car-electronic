package com.rentcar.support.controller;

import com.rentcar.support.model.Supporter;
import com.rentcar.support.service.RequestServiceImpl;
import com.rentcar.support.service.SupportServiceImpl;
import com.rentcar.utility.Utility;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
요청 페이지
 */

@Slf4j
@Controller
@RequestMapping("/request")
public class RequestandController {

    Logger logger = LoggerFactory.getLogger(RequestandController.class);

    @Autowired
    private RequestServiceImpl requestService;

    @Autowired
    private SupportServiceImpl supportService;

    /*
   검색 기능 구현
   col : select tag 성택 요소
   word : 검색어
    */
    @GetMapping("/list")
    public String list(HttpServletRequest request){

        String col = Utility.checkNull(request.getParameter("col"));
        String word = Utility.checkNull(request.getParameter("word"));

        if (col.equals("total")) {
            word = "";
        }

        int nowPage = 1;// 현재 보고있는 페이지 (처음들어왔을때 페이지??)
        if (request.getParameter("nowPage") != null) {
            nowPage = Integer.parseInt(request.getParameter("nowPage"));
        }//null을 정수형으로바꿔라 안쓰면 Nullpoint 익셉션뜸 !!!!!!
        int recordPerPage = 3;// 한페이지당 보여줄 레코드갯수

        // DB에서 가져올 순번-----------------
        int sno = ((nowPage - 1) * recordPerPage) ;
        // int eno = nowPage * recordPerPage;

        Map map = new HashMap();
        map.put("col", col); // select tag
        map.put("word", word); // 검색어
        map.put("sno", sno); // 현제 페이지 번호
        map.put("cnt", recordPerPage); // 페이지당 표시할 글 수

        int total = supportService.total(map);
        List<Supporter> list = supportService.list(map);

        String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

        // request에 Model사용 결과 담는다
        request.setAttribute("list", list);
        request.setAttribute("nowPage", nowPage);
        request.setAttribute("col", col);
        request.setAttribute("word", word);
        request.setAttribute("paging", paging);

        return "/list";
    }


    @GetMapping("/request")
    public String repuest(){
        return "/request";
    }

}
