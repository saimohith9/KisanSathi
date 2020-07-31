<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900"
	rel="stylesheet">
<link rel="stylesheet" href="../fonts/icomoon/style.css">

<link rel="stylesheet" href="../css/bootstrap.min.css">

<link rel="stylesheet" href="../fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="../css/style.css" type="text/css">
<style type="text/css">
.intro-section {
	background-size: cover;
	position: relative;
}

.price {
	position: absolute;
	display: inline-block;
	width: 80px;
	height: 80px;
	line-height: 80px;
	border-radius: 50%;
	background: #f37121;
	font-size: 20px;
	text-align: center;
	color: #fff;
	font-weight: 500;
}

.intro-section, .intro-section .container .row {
	height: 100vh;
	min-height: 500px;
}

.intro-section:before {
	content: "";
	position: absolute;
	height: 100%;
	width: 100%;
	background: rgba(0, 0, 0, 0.2);
	border-bottom-right-radius: 0px;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

@media ( max-width : 991.98px) {
	.intro-section:before {
		width: 100%;
	}
}

.intro-section h1 {
	font-size: 60px;
	font-weight: 900;
	line-height: 1;
	color: #fff;
}

@media ( max-width : 991.98px) {
	.intro-section h1 {
		font-size: 34px;
	}
}

.intro-section p {
	color: rgba(255, 255, 255, 0.8);
	font-size: 20px;
}

.intro-section.small, .intro-section.small .container .row {
	height: 90vh;
	min-height: 300px;
}

.intro-section .intro {
	margin-top: 6rem;
}

.has-children {
	position: relative;
}

.site-navbar .site-navigation .site-menu .has-children>a {
	position: relative;
	padding-right: 20px;
}

.site-navbar .site-navigation .site-menu .has-children>a:before {
	position: absolute;
	content: "\e313";
	font-size: 16px;
	top: 50%;
	right: 0;
	-webkit-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
	font-family: 'icomoon';
}

.site-navbar .site-navigation .site-menu .has-children .dropdown {
	visibility: hidden;
	opacity: 0;
	top: 100%;
	position: absolute;
	text-align: left;
	border-top: 2px solid #f37121;
	-webkit-box-shadow: 0 2px 10px -2px rgba(0, 0, 0, 0.1);
	box-shadow: 0 2px 10px -2px rgba(0, 0, 0, 0.1);
	border-left: 1px solid #edf0f5;
	border-right: 1px solid #edf0f5;
	border-bottom: 1px solid #edf0f5;
	padding: 0px 0;
	margin-top: 20px;
	margin-left: 0px;
	background: #fff;
	-webkit-transition: 0.2s 0s;
	-o-transition: 0.2s 0s;
	transition: 0.2s 0s;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown.arrow-top
	{
	position: absolute;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown.arrow-top:before
	{
	bottom: 100%;
	left: 20%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown.arrow-top:before
	{
	border-color: rgba(136, 183, 213, 0);
	border-bottom-color: #fff;
	border-width: 10px;
	margin-left: -10px;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown a {
	font-size: 16px;
	text-transform: none;
	letter-spacing: normal;
	-webkit-transition: 0s all;
	-o-transition: 0s all;
	transition: 0s all;
	color: #343a40;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown .active>a
	{
	color: #fff !important;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown>li {
	list-style: none;
	padding: 0;
	margin: 0;
	min-width: 200px;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown>li>a {
	padding: 9px 20px;
	display: block;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown>li>a:hover
	{
	background: #f4f5f9;
	color: #25262a;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown>li.has-children>a:before
	{
	content: "\e315";
	right: 20px;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown>li.has-children>.dropdown,
	.site-navbar .site-navigation .site-menu .has-children .dropdown>li.has-children>ul
	{
	left: 100%;
	top: 0;
}

.site-navbar .site-navigation .site-menu .has-children .dropdown>li.has-children:hover>a,
	.site-navbar .site-navigation .site-menu .has-children .dropdown>li.has-children:active>a,
	.site-navbar .site-navigation .site-menu .has-children .dropdown>li.has-children:focus>a
	{
	background: #f4f5f9;
	color: #25262a;
}

.site-navbar .site-navigation .site-menu .has-children:hover>a,
	.site-navbar .site-navigation .site-menu .has-children:focus>a,
	.site-navbar .site-navigation .site-menu .has-children:active>a {
	color: #fff;
}

.site-navbar .site-navigation .site-menu .has-children:hover,
	.site-navbar .site-navigation .site-menu .has-children:focus,
	.site-navbar .site-navigation .site-menu .has-children:active {
	cursor: pointer;
}

.site-navbar .site-navigation .site-menu .has-children:hover>.dropdown,
	.site-navbar .site-navigation .site-menu .has-children:focus>.dropdown,
	.site-navbar .site-navigation .site-menu .has-children:active>.dropdown
	{
	-webkit-transition-delay: 0s;
	-o-transition-delay: 0s;
	transition-delay: 0s;
	margin-top: 0px;
	visibility: visible;
	opacity: 1;
}
</style>
