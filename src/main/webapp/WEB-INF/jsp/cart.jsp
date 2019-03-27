<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%@ taglib prefix="cartItems" tagdir="/WEB-INF/tags" %>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Category</th>
        <th scope="col">Size</th>
        <th scope="col">Color</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
    </tr>
    </thead>
    <tbody>
        <cartItems:cartItems />
    </tbody>
</table>
<p class="text-justify" id="totalPrice">Total price: ${sessionScope.totalPrice}</p>
<a href="/controller?command=createOrder">Create order</a>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>