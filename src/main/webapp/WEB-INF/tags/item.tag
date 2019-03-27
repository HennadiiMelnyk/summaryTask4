<%@ tag language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items="${requestScope.productList}" var="user">
    <div class="col-lg-4 col-md-6 mb-4">
        <div class="card h-100">
            <a href="#"><img class="card-img-top" alt=""></a>
            <div class="card-body">
                <h4 class="card-title">
                    <a href="#">${user.name}</a>
                </h4>
                <h5>${user.price}$</h5>
                <p class="card-text">${user.color}<br>${user.size}<br>${user.category}</p>
            </div>
            <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                <input type="button" onclick="addToCart(${user.id})" class="buyButton" name="buyButton" value="BUY">
            </div>
        </div>
        <script type="text/javascript" src="/js/add.js"></script>
    </div>
</c:forEach>