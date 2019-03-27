<%@ tag language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<c:if test="${sessionScope.user.role == 'ADMIN'}">
    <form action="/controller" method="post" class="form-inline">
        <input type='hidden' name='command' id='command' value='viewAllUsers' />
        <button type="submit" class="btn btn-primary mb-2">manage users</button>
    </form>
</c:if>