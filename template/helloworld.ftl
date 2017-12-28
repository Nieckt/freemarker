<html>
<head>
	<title></title>
</head>
<body>
	<h1>Welcome ${user}</h1>
	<p>Our latest product:
	<a href="${latestProduct.url}">${latestProduct.name}</a>!
	<#if sex = 1>
		ÄÐ
	</#if>
	<#list arr as item>
		${item}
	</#list>
</body>
</html>