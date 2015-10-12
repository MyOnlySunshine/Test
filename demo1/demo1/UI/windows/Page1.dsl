<window id="Page1" controller="Page1Controller" namespace="com.sunshine.demo1">
	<import ref="Page1.css" type="css"></import>
	<link type="text/css" href="sys/theme.css"></link>
	<div id="viewPage0">
		<div id="wloginpanel">
			<div id="wuserpanel">
				<image id="wuserimg" scaletype="fitcenter" src="fa_user.png"></image>
				<input id="wusertext" maxlength="256" placeholder="手机\\用户名\\邮箱" type="text"></input>
			</div>
			<div id="wpasspanel">
				<image id="wpassimg" scaletype="fitcenter" src="fa_password.png"></image>
				<input id="wpasstext" maxlength="256" placeholder="密码" type="password"></input>
			</div>
			<input id="wloginbutton" value="登录" class="buttonclass loginbuttonclass" type="button"></input>
			<div id="wotherpanel">
				<label id="wregisterlabel" class="linklabelclass">立即注册</label>
				<label id="wforgetpasslabel" class="linklabelclass">忘记密码</label>
			</div>
			<div id="wotheruserpanel">
				<label id="wfilllabel1"></label>
				<image id="wtencentimage" scaletype="fitcenter" src="icon_tencent.png"></image>
				<label id="wfilllabel2"></label>
				<image id="wsinaimage" scaletype="fitcenter" src="icon_sina.png"></image>
				<label id="wfilllabel3"></label>
				<image id="wrenrenimage" scaletype="fitcenter" src="icon_renren.png"></image>
				<label id="wfilllabel4"></label>
			</div>
		</div>

	</div>
</window>
