<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
</head>
<body>
	<header>
		<h1>${title}</h1>
		<div>
			<a href="sample?action=list">すべての商品</a>
			<c:forEach items="${applicationScope.categories}" var="category">
			| <a href="sample?action=category&categoryId=${pageScope.category.id}">${pageScope.category.name}</a>
			</c:forEach>
		</div>
	</header>
	<main>
		<article>
			<c:choose>
			<c:when test="${empty items}">
			<p>表示する商品はありません。</p>
			</c:when>
			<c:otherwise>
			<table border="1">
				<caption>${category}の商品は${count}件見つかりました。</caption>
				<tr>
					<th>商品番号</th>
					<th>商品名</th>
					<th>価格</th>
				</tr>
				<c:forEach items="${items}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
				</tr>
				</c:forEach>
			</table>
			</c:otherwise>
			</c:choose>
			<p><a href="/tmp-gradle-project">プロジェクトトップページへ</a></p>
		</article>
	</main>
</body>
</html>