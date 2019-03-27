<%@ include file="/WEB-INF/jspf/head.jspf" %>

<form action="/controller" method="post">
    <input type='hidden' name='command' id='command' value='login' />
    <div class="form-group">
        <label for="loginEmail">Email address</label>
        <input type="email" name='email' class="form-control" id="loginEmail" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="loginPassword">Password</label>
        <input type="password" name='password' class="form-control" id="loginPassword" placeholder="Password">
    </div>
    <div class="alert alert-danger" role="alert">
        ${requestScope.errorMap.login}
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>