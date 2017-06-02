<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/basetaglib.jsp"%>
<html>
<head>
    <title>考试管理</title>
    <link href="${ctx}/htmlsource/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/htmlsource/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx}/htmlsource/js/jquery.scrollTo.min.js"></script>
    <style type="text/css">
        .newbody {
            font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
            background-color: transparent;
            font-size: 13px;
            color: #676a6c;
            overflow-x: hidden;
            overflow-y: hidden;
        }
        .newlabel {
            display: inline-block;
            max-width: 100%;
            margin-bottom: 5px;
            font-weight: 700;
            font-size:16px;
        }
        .hr-line-dashed {
            border-top: 1px dashed #e7eaec;
            color: #FFFFFF;
            background-color: darkgrey;
            height: 1px;
            margin: 20px 0;
        }
        .checkClass{
            padding-left: 15px;
        }
        .btn-default2{
            background-color: #cacaca;
        }
    </style>
</head>
<body class="newbody">
<div class="form-group">
    <div class="col-sm-4" style="position: fixed">
        <div class="row">
            <button class="btn btn-primary btn-sm" type="button" onclick="testHeight()">开始答题</button>
            <button class="btn btn-success btn-sm" type="submit">提交答案</button>
        </div>
        <div class="row">
            <label class="form-control">测试者：${staffname}</label>
        </div>
        <div class="row">
            <div class="tooltip-demo" style="height: 500px;">
                <c:forEach var="question" items="${questionList}" varStatus="status">
                    <button class="btn btn-default2 btn-circle btn-sm" data-toggle="tooltip"
                            data-placement="right" title="测试提示" xh="${status.count}"
                            type="button" onclick="scrollLocation(this)" tmbsm="${question.bsm}">
                            ${status.count}
                    </button>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
    </div>
    <div class="col-sm-8">


        <div id="divQuestion" style="height: 500px;overflow-y: auto;overflow-x: hidden">
            <c:forEach var="question" items="${questionList}" varStatus="status">
                <div class="row" >
                    <div class="col-sm-12">
                        <label class="newlabel" tmbsm="${question.bsm}" tmlx="${question.tmlx}"
                               kslx="${question.kslx}">${status.count} 、 ${question.tmmc}
                        </label>
                    </div>
                    <c:forEach var="answers" items="${question.examinationAnswerEntityList}" >
                        <div class="i-checks checkClass" tmbsm="${question.bsm}"
                             dabsm="${answers.bsm}" dalx="${answers.dalx}"><label>
                            <input type="radio" name="${answers.kstmbsm}"> <i></i> ${answers.danr} </label></div>
                    </c:forEach>
                </div>
                <div class="hr-line-dashed"></div>
            </c:forEach>
        </div>

    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });


    $(function(){
        $(".iradio_square-green").on("ifChanged",function(event){
            var bsm = $(this).parent().parent().attr("tmbsm");
            $("button[tmbsm='"+bsm+"']").each(function(){
                $(this).removeClass("btn-default2");
                $(this).addClass("btn-info");

            });
        })
    })

    function scrollLocation(obj) {
        var bsm = $(obj).attr("tmbsm");
        var locationObj = $("label[tmbsm='"+bsm+"']");
        //$("#divQuestion").animate({scrollTop:locationObj.offsetTop},"slow");
        //$("#divQuestion").scrollToExtendInit();
        $("#divQuestion").scrollToExtend(locationObj);

    }
    $.fn.scrollToExtendInit = function(){
        return this.scrollTo(0 ,1000);
    };
    $.fn.scrollToExtend = function(obj){
        this.scrollTo(0 ,1);
        var xh  = parseInt($(obj).attr("xh"));

        $.scrollTo.defaults.axis = 'xy';
        var top = parseInt($(obj).offset().top - $(this).offset().top +$(this).scrollTop());
        return this.scrollTo(top - 30 ,200);
    };

</script>
</html>
