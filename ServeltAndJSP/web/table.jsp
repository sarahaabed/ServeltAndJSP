<!DOCTYPE html>
<html>

<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
</head>

<body>

<table style="width:80%">
  <c:forEach items="${products}" var="product">
    <tr>
      <td><c:out value="${product.tareWeight}" /></td>
      <td><c:out value="${product.barCode}" /></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
