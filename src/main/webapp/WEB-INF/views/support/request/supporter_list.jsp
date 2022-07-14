<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="util" uri="/ELFunctions" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <title>Bootstrap Example</title>
                    <meta charset="utf-8">

                    <script type="text/javascript">
                        function deletefun(carnum, no) {
                            console.log(carnum);
                            alert(carnum + " 차량을 삭제 하시겠습니까?")

                            let response = fetch(`./delete/` + no);
                            if (response == true) {
                                alert("삭제하였습니다.")
                            }
                        }

                        function createwindow() {
                            let windowObjectReference;
                            let windowFeatures = "left=100,top=100,width=320,height=900, width=640";
                            windowObjectReference = window.open("./create", "mozillaTab", windowFeatures);

                        }
                    </script>


                    <!-- <style>
                        .container .form-inline {
                            display: flex;
                            justify-content: center;
                            flex-direction: row;
                            align-items: center;
                            margin-bottom: 50px;
                        }

                        .table {
                            display: flex;
                            justify-content: center;
                            flex-direction: row;
                            align-items: center;
                            margin-bottom: 50px;
                        }
                    </style> -->

                    <link rel="stylesheet" type="text/css" href="/css/support/style.css">
                </head>

                <body>


                    <div class="container">
                        <form class="form-inline" action="/support/list">
                            <div class="form-group">

                                <select class="my-select-menu" name="col">
                                    <option <c:if test="${col=='carnum'}"> selected </c:if>
                                        >차량번호</option>

                                    <option <c:if test="${col=='state'}"> selected </c:if>
                                        >상태</option>

                                    <option <c:if test="${col=='total'}"> selected </c:if>
                                        >전체출력</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter 검색어" name="word"
                                    value="${word}">
                            </div>
                            <div style="left: 0px;">
                                <button type="submit" class="btn btn-default">검색</button>
                                <button onclick="createwindow();">등록</button>
                            </div>
                        </form>
                    </div>

                    <div class=table>
                        <table class="styled-table">
                            <thead>
                                <tr>
                                    <th>차량</th>
                                    <th>요청위치x</th>
                                    <th>요청위치y</th>
                                    <th>상태</th>
                                    <th>폐차</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${empty list}">
                                        <tr>
                                            <td colspan="6">등록된 글이 없습니다.</td>
                                    </c:when>
                                    <c:otherwise>

                                        <c:forEach var="dto" items="${list}">

                                            <tr class="active-row">
                                                <td>${dto.carnum}</td>
                                                <td>${dto.rx}</a></td>
                                                <td>${dto.ry}</td>
                                                <td>${dto.state}</td>
                                                <td><a onclick="deletefun(`${dto.carnum}`,`${dto.no}`)"> 폐차</td>
                                            </tr>

                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>

                    <div>
                        ${paging}
                    </div>
                    </div>
                </body>

                </html>