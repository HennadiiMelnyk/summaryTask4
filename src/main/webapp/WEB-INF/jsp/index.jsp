<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%@ taglib prefix="item" tagdir="/WEB-INF/tags" %>
<div class="dropdown" style="padding-left: 75px; margin-bottom: 15px;">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" style="background: lightskyblue;">
        Dropdown
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="left: 75px;">
        <a class="dropdown-item" href="/controller?command=sortByPrice">Sort by price</a>
        <a class="dropdown-item" href="/controller?command=sortByName">Sort by name</a>
    </div>
</div>
<div class="container">
<div class="row">

    <div class="col-lg-3">
        <form action="/controller" method="get">
            <input type="hidden" name="command" id="command" value="filter">
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header">
                        <h6 class="title">Category </h6>
                    </header>
                    <div class="filter-content">
                        <div class="card-body">
                            <c:forEach items="${sessionScope.categoryList}" var="category">
                                <label class="form-check">
                                    <input class="form-check-input" type="checkbox" name="category" style="position: relative !important;" id="${category}" value="${category}" ${sessionScope.checkedCategories[category]}>
                                    <span class="form-check-label">
                                            ${category}
                                    </span>
                                </label> <!-- form-check.// -->
                            </c:forEach>
                        </div> <!-- card-body.// -->
                    </div>
                </article> <!-- card-group-item.// -->
            </div> <!-- card.// -->
            <input type="submit" onclick="onsubmit" class="filterButton" name="filterButton" value="Filter">
        </form>
        <form action="/controller" method="get">
            <input type="hidden" name="command" id="command" value="filterNovice">
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header">
                        <h6 class="title">Novice</h6>
                    </header>
                    <div class="filter-content">
                        <div class="card-body">
                            <c:forEach items="${sessionScope.noviceList}" var="novice">
                                <label class="form-check">
                                    <input class="form-check-input" type="checkbox" name="novice" style="position: relative !important;" id="${novice}" value="${novice}">
                                    <span class="form-check-label">
                                            ${novice}
                                    </span>
                                </label> <!-- form-check.// -->
                            </c:forEach>
                        </div> <!-- card-body.// -->
                    </div>
                </article> <!-- card-group-item.// -->
            </div> <!-- card.// -->
            <input type="submit" onclick="onsubmit" class="filterButton" name="filterButton" value="Filter">
        </form>

    </div>
    <!-- /.col-lg-3 -->

    <div class="col-lg-9">

        <div class="row" style="height: 400px">

            <item:item/>

        </div>
        <!-- /.row -->

    </div>
<!-- /.container -->
<%@ include file="/WEB-INF/jspf/footer.jspf" %>