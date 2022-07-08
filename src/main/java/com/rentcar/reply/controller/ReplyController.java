package com.rentcar.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rentcar.utility.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ReplyController {
  private static final Logger log = LoggerFactory.getLogger(ReplyController.class);

  @Autowired
  @Qualifier("com.rentcar.reply.ReplyServiceImpl")
  private ReplyService service;
  
  @GetMapping("/list/reply/list/{listno}/{sno}/{eno}")
  public ResponseEntity<List<ReplyDTO>> getList(
      @PathVariable("listno") int listno, 
      @PathVariable("sno") int sno,
      @PathVariable("eno") int eno) {
 
    Map map = new HashMap();
    map.put("sno", sno);
    map.put("eno", eno);
    map.put("listno", listno);
 
    return new ResponseEntity<List<ReplyDTO>>(service.list(map), HttpStatus.OK);
}
  @GetMapping("/list/reply/page")
  public ResponseEntity<String> getPage(
     int nPage, int nowPage,int listno, String col, String word)  {
 
    int total = service.total(listno);
    String url = "/list/read/"+listno;
 
    int recordPerPage = 3; // 한페이지당 출력할 레코드 갯수
 
    String paging = Utility.rpaging(total, nowPage, recordPerPage, col, word, url, nPage);
    System.out.println("paging:"+paging);
    return new ResponseEntity<>(paging, HttpStatus.OK);
 
  }
  @PostMapping("/list/reply/create")
  public ResponseEntity<String> create(@RequestBody ReplyDTO vo) {
 
    log.info("ReplyDTO1: " + vo.getContent());
    log.info("ReplyDTO1: " + vo.getId());
    log.info("ReplyDTO1: " + vo.getListno());
 
    vo.setContent(vo.getContent().replaceAll("/n/r", "<br>"));
 
    int flag = service.create(vo);
 
    log.info("Reply INSERT flag: " + flag);
 
    return flag == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
 
  @GetMapping("/reply/{rnum}")
  public ResponseEntity<ReplyDTO> get(@PathVariable("rnum") int rnum) {
 
    log.info("get: " + rnum);
 
    return new ResponseEntity<>(service.read(rnum), HttpStatus.OK);
  }
  @PutMapping("/reply/")
  public ResponseEntity<String> modify(@RequestBody ReplyDTO vo) {
 
    log.info("modify: " + vo);
 
    return service.update(vo) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 
  }
 
  @DeleteMapping("/reply/{rnum}")
  public ResponseEntity<String> remove(@PathVariable("rnum") int rnum) {
 
    log.info("remove: " + rnum);
 
    return service.delete(rnum) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
 
  }
}