<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>罗霄山农产品直销商城——个人注册</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css">
    <!--  <script src="js/jquery-1.11.3.min.js" ></script>
    <script src="js/index.js" ></script>  -->
    <!-- <script type="text/javascript" src="js/jquery1.42.min.js"></script> -->
    <!--
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
     <script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.source.js"></script> -->
</head>
<body>
<!--dengl-->
<div class="yiny">
    <div class="beij_center">
        <div class="dengl_logo">
            <img src="/static/images/logo.png">
            <h1>欢迎注册</h1>
        </div>
    </div>
</div>

<div class="beij_center">
    <div class="ger_zhuc_beij">
        <div class="ger_zhuc_biaot">
            <ul>
                <li class="ger_border_color"><a href="/register">个人注册</a></li>
                <p>我已经注册，现在就<a class="ftx-05 ml10" href="/login">登录</a></p>
            </ul>
        </div>
        <div class="zhuc_biaod">
            <div class="reg-items" >
              	<span class="reg-label">
                	<label>用户名：</label>
              	</span>
                <input   class="i-text" type="text">
                <!--备注————display使用 inline-block-->
                <div class="msg-box">
                    <div class="msg-box" style="display: none;">
                        <div class="msg-weak" style="display: inline-block;"> <i></i>
                            <div class="msg-cont">4-20个字符，支持汉字、字母、数字及“-”、“_”组合</div>
                        </div>
                    </div>
                    <div class="msg-weak err-tips"  style="display: inline-block;"><div>请输入用户名</div></div>
                </div>
                <span class="suc-icon"></span>
            </div>
            <div class="reg-items" >
              	<span class="reg-label">
                	<label>设置密码：</label>
              	</span>
                <input   class="i-text" type="text">
                <!--备注————display使用 inline-block-->
                <div class="msg-box">
                    <div class="msg-box" style="display: none;">
                        <div class="msg-weak" style="display: inline-block;"> <i></i>
                            <div class="msg-cont">键盘大写锁定已打开，请注意大小写!</div>
                        </div>
                    </div>
                    <div class="msg-weak err-tips"  style="display:none;"><div>请输入密码</div></div>
                </div>
            </div>
            <div class="reg-items" >
              	<span class="reg-label">
                	<label>确认密码：</label>
              	</span>
                <input   class="i-text" type="text" disabled="disabled">
                <!--备注————display使用 inline-block-->
                <div class="msg-box">
                    <div class="msg-weak err-tips"  style="display: none;"><div>密码不一样</div></div>
                </div>
            </div>
            <div class="reg-items" >
              	<span class="reg-label">
                	<label>手机号码：</label>
              	</span>
                <input   class="i-text" type="text">
                <!--备注————display使用 inline-block-->
                <div class="msg-box">
                    <div class="msg-weak err-tips"  style="display:none;"><div>手机号不能为空</div></div>
                </div>
            </div>
            <div class="reg-items" >
              	<span class="reg-label">
                	<label>手机号码：</label>
              	</span>
                <input   class="i-text i-short" type="text">
                <div class="check check-border" style="position:relative;left:0">
                    <a class="check-phone" style="padding:11px 10px 14px 10px;*line-height:60px;">获取短信验证码</a>
                    <span class="check-phone disable" style="display: none;"><em>60</em>秒后重新获取</span>
                    <a class="check-phone" style="display: none;padding:11px 10px 14px 10px">重新获取验证码</a>
                </div>
                <!--备注————display使用 inline-block-->
                <div class="msg-box">
                    <div class="msg-weak err-tips"  style="display:none;"><div>请输入短信验证码</div></div>
                </div>
            </div>
            <div class="reg-items" >
              	<span class="reg-label">
                	<label> </label>
              	</span>
                <div class="dag_biaod">
                    <input type="checkbox" value="english" >
                    阅读并同意
                    <a href="#" class="ftx-05 ml10">《罗霄山农产品直销商城用户注册协议》</a>
                    <a href="#" class="ftx-05 ml10">《隐私协议》</a>
                </div>
            </div>
            <div class="reg-items" >
              	<span class="reg-label">
                	<label> </label>
              	</span>
                <input class="reg-btn" value="立即注册" type="button">
            </div>
        </div>
        <div class="xiaogg">
            <img src="/static/images/cdsgfd.jpg">
        </div>
    </div>
</div>

<div class="jianj_dib jianj_dib_1">
    <div class="beia_hao">
        <p>京ICP备：123456789号  </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
    </div>
</div>
</body>
</html>
