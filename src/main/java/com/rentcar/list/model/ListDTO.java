package com.rentcar.list.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ListDTO {

        /** 번호 */
        private int listno;
        /** 글쓴이 */
        private String mname;
        /** 제목 */
        private String title;
        /** 내용 */
        private String content;
        /** 패스워드 */
        private String passwd;
        /** 조회수 */
        private int viewcnt;
        /** 등록일 */
        private String wdate;
        /** 그룹 번호 */
        private int grpno;
        /** 답변 차수 */
        private int indent;
        /** 답변 순서 */
        private int ansnum;
        /** 파일 이름 */
        private String filename;
        /** 파일 사이즈 */
        private int filesize;
        /** form 선택한 파일을 서버에서 처리할 수 있는 타입으로 선언 */
        private MultipartFile filenameMF;
}
