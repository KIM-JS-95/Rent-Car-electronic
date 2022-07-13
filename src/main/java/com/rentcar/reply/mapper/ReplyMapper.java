package com.rentcar.reply.mapper;
 
import com.rentcar.reply.model.ReplyDTO;

import java.util.List;
import java.util.Map;
 
public interface ReplyMapper{
 
   int create(ReplyDTO replyDTO);
 
   List<ReplyDTO> list(Map map);
 
   ReplyDTO read(int rnum);
  
   int update(ReplyDTO replyDTO); 
   
   int delete(int rnum);
 
   int total(int bbsno);

  void bdelete(int bbsno);

}