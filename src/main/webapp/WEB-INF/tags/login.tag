<%@ tag language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<c:if test="${sessionScope.user == null}">
    <form action="/controller" method="post" class="form-inline">
      <input type='hidden' name='command' id='command' value='login' />
      <div class="form-group mx-sm-3 mb-2">
        <label for="loginEmail" class="sr-only">Email</label>
        <input type="email" class="form-control" id="loginEmail" name="email" placeholder="Email">
      </div>
      <div class="form-group mx-sm-3 mb-2">
        <label for="loginPassword" class="sr-only">Password</label>
        <input type="password" class="form-control" id="loginPassword" name="password" placeholder="Password">
      </div>
        <button type="submit" class="btn btn-primary mb-2">Login</button>
        <a href="/controller?command=redirectToRegistration" style="margin-left: 10px;">Registration</a>
    </form>

</c:if>
<c:if test="${sessionScope.user != null}">
    <form action="/controller" method="get">
        <input type='hidden' name='command' id='command' value='logout' />
        <b>Welcome ${sessionScope.user.surname}</b>
        <button type="submit" class="btn btn-primary mb-2">Logout</button>
    </form>
</c:if>