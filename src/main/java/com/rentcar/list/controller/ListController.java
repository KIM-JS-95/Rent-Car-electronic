package com.rentcar.list.controller;



import com.rentcar.list.UploadList;
import com.rentcar.list.model.ListDTO;
import com.rentcar.list.service.ListService;
import com.rentcar.reply.ReplyService;

import com.rentcar.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController("/contents")
public class ListController {

    @Autowired
    @Qualifier("com.rentcar.list.ListServiceImpl")
    private ListService service;

    @Autowired
    @Qualifier("com.rentcar.reply.ReplyServiceImpl")
    private ReplyService rservice;

    @GetMapping("/list")
    public String list(){

        return"/list";
    }

    @GetMapping("/list/create")
    public String create() {
        return "/list/create";
    }

    @PostMapping("/list/create")
    public String create(ListDTO dto, HttpServletRequest request) throws IOException {
        String upDir = UploadList.getUploadDir();

        if (dto.getFilenameMF().getSize() > 0) {
            dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), upDir));
            dto.setFilesize((int) dto.getFilenameMF().getSize());
        }

        boolean flag = false;

        int cnt = service.create(dto);

        if (cnt > 0) {
            flag = true;
        }

        if (flag) {
            return "redirect:/list";
        } else {
            return "/list/error";
        }

    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        // 검색관련------------------------
        String col = Utility.checkNull(request.getParameter("col"));
        String word = Utility.checkNull(request.getParameter("word"));

        if (col.equals("total")) {
            word = "";
        }

        // 페이지관련-----------------------
        int nowPage = 1;// 현재 보고있는 페이지
        if (request.getParameter("nowPage") != null) {
            nowPage = Integer.parseInt(request.getParameter("nowPage"));
        }
        int recordPerPage = 3;// 한페이지당 보여줄 레코드갯수

        // DB에서 가져올 순번-----------------oracle
        //int sno = ((nowPage - 1) * recordPerPage) + 1; //시작위치(1부터)
        //int eno = nowPage * recordPerPage;             //끝위치

        // DB에서 가져올 순번-----------------mysql
        int sno = ((nowPage-1) * recordPerPage);  //시작위치 (0부터)
        int eno = recordPerPage;                      //가져올 레코드 수(한페이지당 보여줄 레코드수와 같음)

        Map map = new HashMap();
        map.put("col", col);
        map.put("word", word);
        map.put("sno", sno);
        map.put("eno", eno);

        int total = service.total(map);

        // List<ListDTO> list = dao.list(map);
        List<ListDTO> list = service.list(map);

        String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

        // request에 Model사용 결과 담는다
        request.setAttribute("list", list);
        request.setAttribute("nowPage", nowPage);
        request.setAttribute("col", col);
        request.setAttribute("word", word);
        request.setAttribute("paging", paging);

        return "/list";
    }

    @GetMapping("/list/read")
    public String read(int listno, Model model) {

        service.upViewcnt(listno);
        ListDTO dto = service.read(listno);

        String content = dto.getContent().replaceAll("\r\n", "<br>");
        dto.setContent(content);

        model.addAttribute("dto", dto);

        return "/list/read";
    }

    @GetMapping("/list/update")
    public String update(int listno, Model model) {
        model.addAttribute("dto", service.read(listno));

        return "/list/update";
    }

    @PostMapping("/list/update")
    public String update(ListDTO dto, String oldfile,
                         RedirectAttributes redirect, HttpServletRequest request) throws IOException {
        String upDir = UploadList.getUploadDir();

        System.out.println("MF:" + dto.getFilenameMF());
        if (dto.getFilenameMF().getSize() > 0) {
            if (oldfile != null)
                Utility.deleteFile(upDir, oldfile);
            dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), upDir));
            dto.setFilesize((int) dto.getFilenameMF().getSize());
        }

        Map map = new HashMap();
        map.put("listno", dto.getListno());
        map.put("passwd", dto.getPasswd());
        boolean pflag = false;

        int cnt = service.passCheck(map);
        if (cnt > 0)
            pflag = true;

        boolean flag = false;

        if (pflag) {
            int cnt2 = service.update(dto);
            if (cnt2 > 0)
                flag = true;
        }

        if (!pflag) {
            return "passwdError";
        } else if (flag) {
            redirect.addAttribute("col", request.getParameter("col"));
            redirect.addAttribute("word", request.getParameter("word"));
            redirect.addAttribute("nowPage", request.getParameter("nowPage"));
            return "redirect:/list/list";
        } else {
            return "error";
        }

    }

    @PostMapping("/list/reply")
    public String reply(ListDTO dto, HttpServletRequest request) throws IOException {
        String upDir = UploadList.getUploadDir();
        if (dto.getFilenameMF().getSize() > 0) {
            dto.setFilename(Utility.saveFileSpring(dto.getFilenameMF(), upDir));
            dto.setFilesize((int) dto.getFilenameMF().getSize());
        }else {
            dto.setFilename("");
        }

        Map map = new HashMap();
        map.put("grpno", dto.getGrpno());
        map.put("ansnum", dto.getAnsnum());

        service.upAnsnum(map);

        boolean flag = false;
        int cnt = service.createReply(dto);
        if (cnt > 0)
            flag = true;

        if (flag) {
            return "redirect:/list/list"; // 재요청
        } else {
            return "error";
        }

    }

    @GetMapping("/list/reply")
    public String reply(int listno, Model model) {

        model.addAttribute("dto", service.readReply(listno));
        return "/list/reply";
    }

    @PostMapping("/list/delete")
    public String delete(int listno, String passwd, String oldfile,
                         RedirectAttributes redirect,HttpServletRequest request) throws IOException {

        String upDir = UploadList.getUploadDir();
        Map map = new HashMap();
        map.put("listno", listno);
        map.put("passwd", passwd);
        int cnt = service.passCheck(map);

        String url = "passwdError";

        if (cnt > 0) {

            try {
                service.delete(listno);
                redirect.addAttribute("col", request.getParameter("col"));
                redirect.addAttribute("word", request.getParameter("word"));
                redirect.addAttribute("nowPage", request.getParameter("nowPage"));
                url = "redirect:/list/list";
                if (oldfile != null)
                    Utility.deleteFile(upDir, oldfile);
            } catch (Exception e) {
                e.printStackTrace();
                url = "error";
            }

        }

        return url;
    }

    @GetMapping("/list/delete")
    public String delete(int listno, Model model) {

                  int cnt = service.checkRefnum(listno);

                   boolean flag = false;
                    if(cnt>0) flag = true;

                  model.addAttribute("flag",flag);

        return "/list/delete";

    }


}