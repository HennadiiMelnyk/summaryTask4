<%@ tag language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items="${sessionScope.cart.cart}" var="user">
    <tr id=${user.key.id}>
        <th scope="row">${user.key.id}</th>
        <td>${user.key.name}</td>
        <td>${user.key.category}</td>
        <td>${user.key.size}</td>
        <td>${user.key.color}</td>
        <td>${user.key.price}</td>
        <td>${user.value}</td>
        <td><input type="button" onclick="removeFromCart(${user.key.id})" class="removeButton" name="removeButton" value="remove"></td>
    </tr>
    <script type="text/javascript" src="/js/cart.js"></script>
</c:forEach>