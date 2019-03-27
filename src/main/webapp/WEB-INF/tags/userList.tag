<%@ tag language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:forEach items="${requestScope.userList}" var="user">
    <tr id=${user.id}>
        <th scope="row">${user.id}</th>
        <td>${user.surname}</td>
        <td>${user.email}</td>
        <td>${user.password}</td>
        <td>${user.isBlock}</td>
        <td>${user.role}</td>
        <td>
            <c:if test="${user.isBlock == true}">
                <input type="button" onclick="unlockUser(${user.id})" class="blockUser" name="blockButton"
                       value="unlock">
            </c:if>
            <c:if test="${user.isBlock == false}">
                <input type="button" onclick="blockUser(${user.id})" class="blockUser" name="blockButton"
                       value="block">
            </c:if>
        </td>
    </tr>
    <script type="text/javascript" src="/js/user.js"></script>
</c:forEach>