		<ol class="menu__list">
			<li class="menu__item"><a id="all" href="#">ようこそ</a></li>
			<c:forEach items="${categories}" var="category">
			<li class="menu__item"><a id="cat_${category.id}" href="#">${category.name}</a></li>
			</c:forEach>
			<li class="menu__item"><a id="in_cart" href="#">カートを見る</a></li>
		</ol>
