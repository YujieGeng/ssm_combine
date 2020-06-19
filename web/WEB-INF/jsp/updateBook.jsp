<%--
  Created by IntelliJ IDEA.
  User: yujie
  Date: 2020/6/19
  Time: 9:57 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <%--bootstrap 美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>

            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <div class="form-group">

            <%--出现的问题，初次考虑是事务，后来配置了，发现还是不行
             所以考虑是不是sql问题，最后发现update的时候id为0，所以需要在前端隐藏的加入一个id--%>
            <input type="hidden" name="bookID" value="${QBooks.bookID}">
            <label >书籍名称</label>
            <input type="text" name="bookName" class="form-control" value="${QBooks.bookName}">
        </div>

        <div class="form-group">
            <label >书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBooks.bookCounts}" required>
        </div>

        <div class="form-group">
            <label >书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${QBooks.detail}" required>
        </div>

        <div class="form-group">
            <input type="submit" class="form-control" value="修改" required>
        </div>
    </form>

</div>
</body>
</html>
