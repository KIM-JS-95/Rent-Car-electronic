use project;
drop table list;

create table list(
listno int not null auto_increment, 
mname varchar(100) not null,
title varchar(100) null, 	
content varchar(3000) not null,
viewcnt int DEFAULT '0',
wdate date not null,
grpno int not null,
ansnum int  DEFAULT '0',
filename varchar(8) not null,
filesize int  DEFAULT '0',
	primary KEY(listno)
    );
    
    -- create
		INSERT INTO list (mname, title, content, wdate,grpno,filename, filesize)
        VALUES( "이름", "제목", "내용",  DATE(NOW()),
        (SELECT ifnull(MAX(grpno),0) + 1 FROM list b),"어디인가",1 );
        
        select*from list;
        
        -- read
        
		SELECT listno,mname, title, content, viewcnt, wdate, filename
        FROM list
        WHERE listno = 1;
        
        -- update
		update list
        set mname = "",
            title = "",
            content = ""
            where listno = 1;
        
        -- delete
        DELETE FROM list
        WHERE listno = 1;
        
        -- upAnsnum
		update list
        set ansnum =
        ansnum + 1
        where grpno = 1
        and ansnum > 0;
        
        
create table reply(
rnum int NOT NULL AUTO_INCREMENT,
  content varchar(500) NOT NULL,
  regdate date NOT NULL,
  id varchar(10) NOT NULL,
  listno int not null ,
  PRIMARY KEY (rnum),
  FOREIGN KEY (listno) REFERENCES list (listno)
    );
    
    -- create
	insert into reply(content, regdate, id, listno)
    values("", sysdate(), "", 1); 
    
    select *from reply;
    
    
    -- read 
	select * from reply
    where rnum = 1;
    
    -- update
update reply
set content = ""
where rnum = 1;
    
    
    -- delete
delete from REPLY
where rnum = 1;
    