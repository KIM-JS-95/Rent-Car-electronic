<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
<style>
  .section input[id*="slide"]{
    display:none;
  }
  .section .slidewrap{
    max-width:1200px;
    margin:0 auto;
    overflow:hidden;
  }
  .section .slidelist{
    white-space:nowrap;
    font-size:0;
  }
  .section .slidelist >li {
    display:inline-block;
    vertical-align:middle;
    width:100%;
    transition:all .5s;
  }
  .section .slidelist >li >a{
    display:block;
    position:relative;
  }
  .section .slidelist >li > a img{
    width:100%;
  }
  .section .slicelist label{
    position:absolute;
    z-index:10;
    top:50%;
    transform:transateY(-50%);
    padding:50px;
    cursor:pointer;
  }
  .section .slidelist .left{
    left:30px;
    background:url("'./img/left.png'") center center / 100% no-repeat;
  }
  .section .slidelist .right {
    right:30px;
    background:url('./img/right.png') center center / 100% no-repeat;
  }
  .section .slide-control [class*="control"] {display:none;}
  .section [id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
  .section [id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(100%);}
  .section [id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(200%);}

</style>
</head>
<body>
<body class="wrapper lnbWrapper">
<p class="skip"><a href="#container">본문 바로가기</a></p>

<section id="wrapper">

  <header>

</header>

  <div id="container" class="container">


    <div id="contents" class="contents">
            <!-- 컨텐츠 영역  -->
            <div class="mainTop" profileMemberInfoArea>
                <a href="/web/signup/pass/usermodify" class="imgArea">
                    <div><img src="/resource/PC/images/mypage/img_profile_big.png" alt=""></div>
                </a>
                <div class="txtArea">
                    <h2 class="titDep2 name" profileLinkArea> ???님의<br><span>예약 차량 정보</span> </h2>
                </div>

                <div class="btnArea">

                </div>
            </div>

           <div class="txtArea">
             <div id="carnameTOP">
                    <h2 class="titDep2 name" profileLinkArea> <br><span></span> ${dto.carname}</h2>
             </div>



             <div class='section'>
                <input type="radio" name="slide" id="slide01" checked>
                <input type="radio" name="slide" id="slide02" >
                <input type="radio" name="slide" id="slide03" >
                    <div class="slidewrap">
                        <ul class="slidelist">
                            <li>
                                <div>
                                     <a href=""> <img src="https://img.khan.co.kr/news/2021/12/21/l_2021122101002713000235791.jpg"></a>
                                </div>
                            </li>
                            <li>
                                <div>
                                              <a href=""> <img src="https://img.khan.co.kr/news/2021/12/21/l_2021122101002713000235791.jpg"></a>
                                </div>
                            </li>
                            <li>
                                <div>
                                     <a href=""> <img src="https://img.khan.co.kr/news/2021/12/21/l_2021122101002713000235791.jpg"></a>
                                </div>
                            </li>
                          <div class="slide-control">

                            <div class="control01">
                              <label for="slide03" class="left"></label>
                              <label for="slide02" class="right"></label>
                            </div>
                              <div class="control02">
                              <label for="slide01" class="left"></label>
                              <label for="slide03" class="right"></label>
                            </div>
                              <div class="control03">
                              <label for="slide02" class="left"></label>
                              <label for="slide01" class="right"></label>
                            </div>

                          </div>
                        </ul>
                   </div>
            </div>





              <table class="table table-bordered" style="font-size: 100px">
            <tr>

                <th class="col-sm-2">아이디</th>
                <td class="col-sm-8"><a href="javascript:read('${dto.id}')">${dto.id}</a></td>
            </tr>
            <tr>
                <th class="col-sm-2">성명</th>
                <td class="col-sm-8">${dto.mname}</td>
            </tr>
            <tr>
                <th class="col-sm-2">전화번호</th>
                <td class="col-sm-8">${dto.tel}</td>
            </tr>
            <tr>
                <th class="col-sm-2">이메일</th>
                <td class="col-sm-8">${dto.email}</td>
            </tr>

            </table>

                  </div>





                <a href="#" class="bannerType">
                  <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA1MTNfMTEg%2FMDAxNTg5MzM2OTk0NTU0.A5pj4skNVli95pEeW9hRt5lNcqNmZJ3qRXKmieHShMUg.pf_oXQsnbPITsKz6inLsQPTboKyk8jjZ3Kgz2vUohBMg.JPEG.baeeunhye13%2Fskyscape.jpg&type=a340">
                </a>


                    </div>
                </div>
                <div class="bannerArea">
<!--                    <figure><img th:src="${@environment.getProperty('display.static.resource-url')}+'/resource/PC/images/mypage/banner.png'"></figure>-->
<!--                    <div class="txt">-->
<!--                        <p>렌터카 할인쿠폰이 발행되었어요.</p>-->
<!--                        <button type="button" class="btLink btLine light">렌터카 조회하기</button>-->
<!--                    </div>-->
<!--                    <button type="button" class="btDel"></button>-->
                </div>

                <div class="lstWrapper">
                    <strong class="bigTit">고객센터</strong>
                    <ul class="roundList type02">
                        <li>
                            <button type="button" class="btnDefault btnM btnLineG customer01" onclick="jppJs.go('/web/faq', 'help')">자주 찾는 질문</button>
                        </li>
                        <li>
                            <button type="button" class="btnDefault btnM btnLineG customer02" onclick="jppJs.go('/web/inquiry', 'member')">1:1 문의</button>
                        </li>
                        <li>
                            <button type="button" class="btnDefault btnM btnLineG customer03" onclick="jppJs.go('/web/modProposal', 'member')">수정제안 내역</button>
                        </li>
                        <li>
                            <button type="button" class="btnDefault btnM btnLineG customer04" onclick="jppJs.go('/web/mypage/payment', 'member')">결제수단관리</button>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- //컨텐츠 영역 -->
        </div>
  </div>



</section><!-- //wrapper -->


    <section id="pop_notice" class="layPop layerMType02" tabindex="0">
        <header>
            <h2 class="titLay">알림함</h2>
        </header>
<!--        <ul class="tabType02 topType">-->
<!--            <li><a href="#" role="button" aria-selected="true">전체</a></li>-->
<!--            <li><a href="#" role="button" aria-selected="false">이벤트/혜택</a></li>-->
<!--            <li><a href="#" role="button" aria-selected="false">최저가항공권</a></li>-->
<!--        </ul>-->
        <div class="scroll-wrapper layContainer scriptScroll" style="position: relative;"><div class="scroll-content scroll-scrolly_visible" tabindex="0" style="height: auto; margin-bottom: 0px; margin-right: 0px; overflow: hidden; max-height: 526px;">
            <div class="noData noticeType" noData>
                <p class="tit">수신 알림이 없습니다.</p>
            </div>

            <div class="grayList notice" notificationList>

                <div class="noticeHis">
                    <ul>
                    </ul>
                </div>
                <div class="btnMors">
                    <button type="button" class="icoMore">더보기</button>
                </div>
            </div>
        </div><div class="scroll-element scroll-x scroll-scrolly_visible"><div class="scroll-element_outer"><div class="scroll-element_size"></div><div class="scroll-element_track"></div><div class="scroll-bar" style="width: 0px;"></div></div></div><div class="scroll-element scroll-y scroll-scrolly_visible"><div class="scroll-element_outer"><div class="scroll-element_size"></div><div class="scroll-element_track"></div><div class="scroll-bar" style="height: 244px; top: 0px;"></div></div></div></div><!-- //layContainer-->

        <button type="button" class="closeL">팝업 닫기</button>

    </section>

    <div class="toastPopup" id="airToastPopup" style="display:none"><!-- 토스트팝업 띄울때 display:block 시켜줌.-->
        <!--    <p class="txt"><em>3000p</em>를 획득하였습니다!</p>-->
        <p class="txt">클립보드에 복사되었습니다.</p>
    </div>






<aside>
    <button type="button" class="btTop" onclick="location.href='#'">페이지 상단으로 이동</button>
</aside>

<div id="jppAlertBox" class="alertBox" style="z-index: 1050; display:none;">
    <div class="alertInner">
        <p class="titAlert">오류 안내</p>
        <span class="txtAlert">알 수 없는 오류가 발생했습니다.</span>
        <div class="alertBtns">
            <button type="button" class="btnDefault btnL action">확인</button>
        </div>
<!--        <button type="button" class="closeA" onclick="$('#jjpAlertBox').hide()">닫기</button>-->
    </div>
</div>

<div id="jppConfirmBox" class="alertBox" style="z-index: 1050; display:none;">
    <div class="alertInner">
        <p class="titAlert">오류 안내</p>
        <span class="txtAlert">알 수 없는 오류가 발생했습니다.</span>
        <div class="alertBtns">
            <button type="button" class="btnDefault btnL btnCancel">취소</button>
            <button type="button" class="btnDefault btnL action btnConfirm">확인</button>
        </div>
<!--        <button type="button" class="closeA" onclick="$('#jjpAlertBox').hide()">닫기</button>-->
    </div>
</div>

<!-- 텀블러 시작 -->
<section id="tumbler_layer_pop" class="layPop layerM" tabindex="0">
    <header>
        <h2 class="titLay">텀블러 등급</h2>
    </header>
    <div class="layContainer scriptScroll" tabindex="0">
        <div class="layContent">
            <div class="tumblerGradeWrap">
                <div class="tumblerUser">
                    <figure><img id="tumblerPorifleImg" src="" alt=""></figure>
                    <span class="col01" tumblertitle>-</span><strong class="name" tumblerUser>-</strong>
                    <span class="grade" tumblerRanking>텀블러 랭킹 -위</span><span class="grade" tumblerSum>누적 커피 -회 사용</span>
                </div>
                <div class="tumblerGrade">
                    <div class="scoreBar">
                        <span class="icons"></span>
                        <p class="graph">
                            <span class="bar" tumblerBar style="width:0%"></span>
                        </p>
                        <span class="total" tumblerTotal><strong>-</strong> / -</span>
                    </div>
                    <p class="gradeTxt" tumblerGrade>다음 등급까지 <strong>0회</strong> 남았어요!</p>
                </div>
                <ul class="tumblerList">
                    <!-- 211230 수정 -->
                    <!-- 각 등급에 따른 클래스값
                    챌린저 : challenger
                    비기너 : beginner
                    팔로워 : follower
                    프로 : pro
                    마스터 : master
                    레전드 : legend
                    갓 : god
                    등급을 획득하지 못했을 때에는 위 클래스값에 "_lock" 추가됨 -->
                    <li>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge challenger_lock"></span><span>텀블러 챌린저</span></button>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge beginner_lock"></span><span>텀블러 비기너</span></button>
                    </li>
                    <li>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge follower_lock"></span><span>텀블러 팔로워</span></button>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge pro_lock"></span><span>텀블러 프로</span></button>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge master_lock"></span><span>텀블러 마스터</span></button>
                    </li>
                    <li>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge legend_lock"></span><span>텀블러 레전드</span></button>
                        <button type="button" class="tumblerUserBadge"><span class="iconBadge god_lock"></span><span>텀블러 갓</span></button>
                    </li>
                    <!-- //211230 수정 -->
                </ul>
            </div>
            <h2 class="titDep4">텀블러 사용 내역</h2>
            <dl class="temblerUseInfo" tumblerUsedList>
                <!--<dt>라블라주</dt>
                <dd>2020.02.02 23:59</dd>
                <dt>스타벅스 제주공항점</dt>
                <dd>2020.02.02 23:59</dd>
                <dt>섭지코지로</dt>
                <dd>2020.02.02 23:59</dd>-->
            </dl>
        </div>
    </div><!-- //layCont-->
    <div class="btnBtm">
        <div class="btnArea">
            <button type="button" class="btnDefault btnL action" onclick="$fn_tumblerClose();">완료</button>
        </div>
    </div>
    <button type="button" class="closeL" onclick="$fn_tumblerClose();">팝업 닫기</button>
</section>
<!-- 텀블러 종료 -->
<link href="https://static-www.jejupass.com/resource/PC/css/p_common.min.css?v1" rel="stylesheet" type="text/css">
<link href="https://static-www.jejupass.com/resource/PC/css/p_contents.min.css?v1" rel="stylesheet" type="text/css">
<div class="dimmed"></div>
</body>
</html>