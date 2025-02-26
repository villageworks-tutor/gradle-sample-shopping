<!DOCTYPE html>
<html lang="js">
<head>
	<meta charset="UTF-8">
	<title>JSPサンプルページ</title>
</head>
<body id="sample">
	<h1>JSPサンプルページ</h1>
	<p>送信されたデータは以下の通り：</p>
	<ul>
	<c:forEach items="${seasons}" var="season">
		<li>${season}</li>
	</c:forEach>
	</ul>
</body>
</html>