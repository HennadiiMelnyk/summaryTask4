<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%@ taglib prefix="userList" tagdir="/WEB-INF/tags" %>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Surname</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
        <th scope="col">Is block</th>
        <th scope="col">Role</th>
    </tr>
    </thead>
    <tbody>
    <userList:userList/>
    </tbody>
</table>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>