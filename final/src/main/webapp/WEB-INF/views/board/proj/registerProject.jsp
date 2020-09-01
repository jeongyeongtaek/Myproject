<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 등록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">         <!-- js, css 경로로 불러와야 하기 때문에 수정 요함 -->
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/bootstrap-datepicker.ko.js"></script>
    <style>
        body {
            background-color: rgb(244, 243, 250);
        }
        .my-content-bgcolor {
            background-color: white;
        }
        .my-content-box {
            padding-bottom: 100px;
        }
        .my-content-box-mw {
            min-width: 900px;
        }
        .my-row-margin {
            margin-left: 0px !important;
            margin-right: 0px !important;
        }
        .my-image-box-heghit {
            height: 150px;
        }
        .my-input-area {
            cursor:pointer;
            background:white;
        }
    </style>
</head>
<%@ include file="../../includes/header.jsp"%>

    <!-- content -->
    <div class="container-fluid">
        <!-- align-items-center 수직 중앙 정렬 -->
        <div class="row align-items-center">

            <!-- 좌측 기본 여백 -->
            <div class="col-md-2 col-0"></div>

            <!-- 내용이 들어갈 div-->
            <div class="col-md-8 col-12 my-content-bgcolor my-content-box">                     
                
                <div class="row my-content-box-mw">
                    <div class="col-2"></div>
                    <div class="col-8">
                        <!-- jumbotron -->
                        <div class="jumbotron jumbotron-fluid my-content-bgcolor">
                            <div class="container">
                                <h1 class="display-4 font-weight-bolder">튬스톤</h1>
                                <p class="lead font-italic">당신의 관심과 흥미를 한단계 업그레이드하세요</p>
                            </div>
                        </div>
                        <!-- /jumbotron -->
                        <hr>
                        <!-- form -->
                        <form action="registerProject" method="post">

                            <!-- 제목 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <h5 class="card-header">제목</h5>
                                    <div class="card-body">
                                        <input type="text" class="form-control form-control-lg" id="inputTitle" name="projTitle">
                                    </div>
                                </div>
                            </div>
                            <!-- /제목 -->
                            <!-- 간단소개 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <h5 class="card-header">간단소개</h5>
                                    <div class="card-body">
                                        <textarea class="form-control" id="textareaSimple" name="content" rows="2"  aria-describedby="textareaSimpleHelp"></textarea>
                                        <small id="textareaSimpleHelp" class="form-text text-muted">글 목록에서 보이는 소개글입니다. 간단히 작성해주세요.</small>
                                    </div>
                                </div>
                            </div>
                            <!-- /간단소개 -->

                            <!-- 모토 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <h5 class="card-header">모토</h5>
                                    <div class="card-body">
                                        <textarea class="form-control" id="textareaSimple" name="motto" rows="2"  aria-describedby="textareaSimpleHelp"></textarea>
                                        <small id="textareaSimpleHelp" class="form-text text-muted">프로젝트에서 중요하게 생각하는 모토를 적어주세요!</small>
                                    </div>
                                </div>
                            </div>
                            <!-- /모토 -->

                            <!-- 계기 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <h5 class="card-header">만든 계기</h5>
                                    <div class="card-body">
                                        <textarea class="form-control" id="textareaSimple" name="motivation" rows="2"  aria-describedby="textareaSimpleHelp"></textarea>
                                        <small id="textareaSimpleHelp" class="form-text text-muted">프로젝트를 만들게된 계기를 적어주세요!</small>
                                    </div>
                                </div>
                            </div>
                            <!-- /계기 -->

                            <!-- 소개 시작 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <div class="card-header row my-row-margin">
                                        <h5>소개</h5>
                                        <div class="col align-self-end text-right text-muted">
                                            <div><small>이미지를 첨부할 방식을 선택해주세요.</small></div>
                                            <div class="nav float-right" role="tablist"> <!-- 양식 타입 선택 라디오 -->
                                                <div>
                                                    <input id="introFormTypeA" class="introTrigger" checked name="introType" type="radio"
                                                        data-target="#introFormA,#inputImage4IntroTypeA">
                                                    <label for="introFormTypeA"><small>타입A</small></label>
                                                </div>
                                                <div>
                                                    <input id="introFormTypeB" class="introTrigger" name="introType" type="radio"
                                                        data-target="#introFormB,#inputImage4IntroTypeB">
                                                    <label for="introFormTypeB"><small>타입B</small></label>
                                                </div>
                                                <div>
                                                    <input id="introFormTypeC" class="introTrigger" name="introType" type="radio"
                                                        data-target="#introFormC,#inputImage4IntroTypeC">
                                                    <label for="introFormTypeC"><small>타입C</small></label>
                                                </div>
                                                <div>
                                                    <input id="introFormTypeD" class="introTrigger" name="introType" type="radio"
                                                        data-target="#introFormD1,#introFormD2,#inputImage4IntroTypeD1,#inputImage4IntroTypeD2">
                                                    <label for="introFormTypeD"><small>타입D</small></label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card-body tab-content row my-row-margin">
                                        <!-- 이미지 없음 -->
                                        <div id="introFormA" class="tab-pane my-intro-tab-pane col-0"></div>
                                        <!-- 좌측 이미지 1개 -->
                                        <div id="introFormB" class="tab-pane my-intro-tab-pane col-3 border text-center text-muted"><small>*이미지 들어갈 곳*</small></div>
                                        <!-- 내용 입력 부분 -->
                                        <textarea class="form-control col" id="textareaIntroFormTypeA" rows="8"  aria-describedby="textareaIntroHelp"
                                            placeholder="소개 내용을 입력해주세요." name="introdution"></textarea>
                                        <!-- /내용 입력 부분 -->
                                        <!-- 하단 이미지 1개 -->
                                        <div id="introFormC" class="tab-pane my-intro-tab-pane col-12 border text-center text-muted my-image-box-heghit"><small>*이미지 들어갈 곳*</small></div>
                                        <div class="w-100"></div>
                                        <!-- 하단 이미지 2개 -->
                                        <div id="introFormD1" class="tab-pane my-intro-tab-pane col-6 border text-center text-muted my-image-box-heghit"><small>*이미지1 들어갈 곳*</small></div>
                                        <div id="introFormD2" class="tab-pane my-intro-tab-pane col-6 border text-center text-muted my-image-box-heghit"><small>*이미지2 들어갈 곳*</small></div> 
                                        <!-- /하단 이미지 2개 -->
                                        
                                        <small id="textareaIntroHelp" class="form-text text-muted">*주의* 마지막으로 선택한 양식만 전송됩니다. 보여지는 양식과 실제 내용은 차이가 있을 수 있습니다.</small>
                                    </div>
                                </div>

                                <!-- 첨부 파일 처리 부분 -->
                                <div>
                                    <!-- 이미지 없음 -->
                                    <div id="inputImage4IntroTypeA" class="input-group mb-3 tab-pane my-intro-tab-pane active"></div>
                                    <!-- 좌측 이미지 1개 -->
                                    <div id="inputImage4IntroTypeB" class="input-group mb-3 tab-pane my-intro-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon01">이미지</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                        <label class="custom-file-label" for="inputGroupFile01">파일선택</label>
                                        </div>
                                    </div>
                                    <!-- 하단 이미지 1개 -->
                                    <div id="inputImage4IntroTypeC" class="input-group mb-3 tab-pane my-intro-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon01">이미지</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                        <label class="custom-file-label" for="inputGroupFile01">파일선택</label>
                                        </div>
                                    </div>
                                    <!-- 하단 이미지 2개 -->
                                    <div id="inputImage4IntroTypeD1" class="input-group mb-3 tab-pane my-intro-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon01">이미지1</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                        <label class="custom-file-label" for="inputGroupFile01">파일선택</label>
                                        </div>
                                    </div>
                                    <div id="inputImage4IntroTypeD2" class="input-group mb-3 tab-pane my-intro-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon02">이미지2</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile02" aria-describedby="inputGroupFileAddon02">
                                        <label class="custom-file-label" for="inputGroupFile02">파일선택</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /소개 끝 -->

                            <!-- 계획 시작 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <div class="card-header row my-row-margin">
                                        <h5>계획</h5>
                                        <div class="col align-self-end text-right text-muted">
                                            <div><small>이미지를 첨부할 방식을 선택해주세요.</small></div>
                                            <div class="nav float-right" role="tablist"> <!-- 양식 타입 선택 라디오 -->
                                                <div>
                                                    <input id="planFormTypeA" class="planTrigger" checked name="planType" type="radio"
                                                        data-target="#planFormA,#inputImage4PlanTypeA">
                                                    <label for="planFormTypeA"><small>타입A</small></label>
                                                </div>
                                                <div>
                                                    <input id="planFormTypeB" class="planTrigger" name="planType" type="radio"
                                                        data-target="#planFormB,#inputImage4PlanTypeB">
                                                    <label for="planFormTypeB"><small>타입B</small></label>
                                                </div>
                                                <div>
                                                    <input id="planFormTypeC" class="planTrigger" name="planType" type="radio"
                                                        data-target="#planFormC,#inputImage4PlanTypeC">
                                                    <label for="planFormTypeC"><small>타입C</small></label>
                                                </div>
                                                <div>
                                                    <input id="planFormTypeD" class="planTrigger" name="planType" type="radio"
                                                        data-target="#planFormD1,#planFormD2,#inputImage4PlanTypeD1,#inputImage4PlanTypeD2">
                                                    <label for="planFormTypeD"><small>타입D</small></label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card-body tab-content row my-row-margin">
                                        <!-- 이미지 없음 -->
                                        <div id="planFormA" class="tab-pane my-plan-tab-pane col-0"></div>
                                        <!-- 좌측 이미지 1개 -->
                                        <div id="planFormB" class="tab-pane my-plan-tab-pane col-3 border text-center text-muted"><small>*이미지 들어갈 곳*</small></div>
                                        <!-- 내용 입력 부분 -->
                                        <textarea class="form-control col" id="textareaPlanFormTypeA" rows="8"  aria-describedby="textareaPlanHelp"
                                            placeholder="계획 내용을 입력해주세요." name="plan"></textarea>
                                        <!-- /내용 입력 부분 -->
                                        <!-- 하단 이미지 1개 -->
                                        <div id="planFormC" class="tab-pane my-plan-tab-pane col-12 border text-center text-muted my-image-box-heghit"><small>*이미지 들어갈 곳*</small></div>
                                        <div class="w-100"></div>
                                        <!-- 하단 이미지 2개 -->
                                        <div id="planFormD1" class="tab-pane my-plan-tab-pane col-6 border text-center text-muted my-image-box-heghit"><small>*이미지1 들어갈 곳*</small></div>
                                        <div id="planFormD2" class="tab-pane my-plan-tab-pane col-6 border text-center text-muted my-image-box-heghit"><small>*이미지2 들어갈 곳*</small></div> 
                                        <!-- /하단 이미지 2개 -->
                                        
                                        <small id="textareaPlanHelp" class="form-text text-muted">*주의* 마지막으로 선택한 양식만 전송됩니다. 보여지는 양식과 실제 내용은 차이가 있을 수 있습니다.</small>
                                    </div>
                                </div>

                                <!-- 첨부 파일 처리 부분 -->
                                <div>
                                    <!-- 이미지 없음 -->
                                    <div id="inputImage4PlanTypeA" class="input-group mb-3 tab-pane my-plan-tab-pane active"></div>
                                    <!-- 좌측 이미지 1개 -->
                                    <div id="inputImage4PlanTypeB" class="input-group mb-3 tab-pane my-plan-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon01">이미지</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                        <label class="custom-file-label" for="inputGroupFile01">파일선택</label>
                                        </div>
                                    </div>
                                    <!-- 하단 이미지 1개 -->
                                    <div id="inputImage4PlanTypeC" class="input-group mb-3 tab-pane my-plan-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon01">이미지</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                        <label class="custom-file-label" for="inputGroupFile01">파일선택</label>
                                        </div>
                                    </div>
                                    <!-- 하단 이미지 2개 -->
                                    <div id="inputImage4PlanTypeD1" class="input-group mb-3 tab-pane my-plan-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon01">이미지1</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                                        <label class="custom-file-label" for="inputGroupFile01">파일선택</label>
                                        </div>
                                    </div>
                                    <div id="inputImage4PlanTypeD2" class="input-group mb-3 tab-pane my-plan-tab-pane active">
                                        <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupFileAddon02">이미지2</span>
                                        </div>
                                        <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="inputGroupFile02" aria-describedby="inputGroupFileAddon02">
                                        <label class="custom-file-label" for="inputGroupFile02">파일선택</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /계획 끝 -->

                            <!-- 지역 설정 -->
                            <div class="form-group">
                                <div class="card my-4">
                                    <h5 class="card-header">지역 설정(2개 선택 가능)</h5>
                                        <div id="callBackDiv">
                                            <table>
                                                <div>시도명</div>
	                                             	<select class="custom-select" name="projAreaA" width="100px">
	                                             	  <option value="" selected="selected">선택안함</option>
													  <option value="서울특별시">서울특별시</option>
													  <option value="광주광역시">광주광역시</option>
													  <option value="울산광역시">울산광역시</option>
													  <option value="대전광역시">대전광역시</option>
													  <option value="대구광역시">대구광역시</option>
													  <option value="부산광역시">부산광역시</option>
													  <option value="인천광역시">인천광역시</option>
													  <option value="경기도">경기도</option>
													  <option value="강원도">강원도</option>
													  <option value="전라남도">전라남도</option>
													  <option value="전라북도">전라북도</option>
													  <option value="경상북도">경상북도</option>
													  <option value="경상남도">경상남도</option>
													  <option value="제주특별자치도">제주특별자치도</option>
													</select>
                                            </table>
                                        </div>
                                        <hr>
                                        <div id="callBackDiv">
                                            <table>
                                                <div>시도명</div>
                                              		<select class="custom-select" name="projAreaB" width="100px">
                                              		  <option value="" selected="selected">선택안함</option>
													  <option value="서울특별시">서울특별시</option>
													  <option value="광주광역시">광주광역시</option>
													  <option value="울산광역시">울산광역시</option>
													  <option value="대전광역시">대전광역시</option>
													  <option value="대구광역시">대구광역시</option>
													  <option value="부산광역시">부산광역시</option>
													  <option value="인천광역시">인천광역시</option>
													  <option value="경기도">경기도</option>
													  <option value="강원도">강원도</option>
													  <option value="전라남도">전라남도</option>
													  <option value="전라북도">전라북도</option>
													  <option value="경상북도">경상북도</option>
													  <option value="경상남도">경상남도</option>
													  <option value="제주특별자치도">제주특별자치도</option>
													</select>
                                            </table>
                                        </div>
                                </div>
                            </div>
                            <!-- /지역 설정 -->

                            <!-- 버튼 -->    
                            <div>
                                <button type="submit" class="btn btn-primary float-right">
                                    다음<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-right-short" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M8.146 4.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.793 8 8.146 5.354a.5.5 0 0 1 0-.708z"/>
                                        <path fill-rule="evenodd" d="M4 8a.5.5 0 0 1 .5-.5H11a.5.5 0 0 1 0 1H4.5A.5.5 0 0 1 4 8z"/>
                                    </svg>
                                </button>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                         	
                          </form>
                    </div>
                    <div class="col-2"></div>
                </div>
            </div>

            <!-- 우측 기본 여백 -->
            <div class="col-md-2 col-0"></div>               
        </div>
    </div>
    <!-- end content -->

</body>

<script>
    jQuery(function () {    // 라디오 버튼 제어
        var $introContents = $('.my-intro-tab-pane').hide();
        var $planContents = $('.my-plan-tab-pane').hide();
        $('.introTrigger').change(function () {
            $introContents.hide();
            $($(this).data('target')).show()
        })
        $('.planTrigger').change(function () {
            $planContents.hide();
            $($(this).data('target')).show()
        })
    })

    function jusoPopup1(){
        var pop = window.open("/MapTest/jusoPopup1.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    }
    function jusoPopup2(){
        var pop = window.open("/MapTest/jusoPopup2.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    }
    function mapPopup1(){
        var pop = window.open("/MapTest/mapTest1.html","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    }
    function mapPopup2(){
        var pop = window.open("/MapTest/mapTest2.html","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    }


    function jusoCallBack1(siNm,sggNm){             // 첫번 째 주소를 반환
            
            document.form.siNm1.value = siNm;
            document.form.sggNm1.value = sggNm;
            
    }
    function jusoCallBack2(siNm,sggNm){             // 두번 째 주소를 반환
            
            document.form.siNm2.value = siNm;
            document.form.sggNm2.value = sggNm;
            
    }

    $(function() {	
		$('#datePicker').datepicker({
		    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
		    startDate: '+8d',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
		    endDate: '',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
		    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
		    calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
		    clearBtn : false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
		    daysOfWeekHighlighted : [0], //강조 되어야 하는 요일 설정
		    disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
		    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
		    multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
		    multidateSeparator :",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
		    templates : {
		        leftArrow: '&laquo;',
		        rightArrow: '&raquo;'
		    }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
		    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
		    title: "마감일",	//캘린더 상단에 보여주는 타이틀
		    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
		    toggleActive : true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
		    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
		    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
		    
		});//datepicker end
	});//ready end
</script>

</html>