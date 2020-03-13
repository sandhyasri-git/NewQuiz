<%@include file="header.jsp" %>
 <table align="center" >
   <% int i=0; %>
  <c:forEach var="questionPaperCommand" items="${questionPaperList}" >
     <tr>
       <td>
        <c:out value="<%=i+1%>"></c:out>
        <c:out value="."></c:out>
        <c:out value="Question :"></c:out>
        <c:out value="${questionPaperCommand.question}"></c:out></td>
     </tr>
     <tr> 
       <td>
         <font color="green" ><c:out value="Answer : "></c:out></font>
         <c:out value="${questionPaperCommand.option1}"></c:out>
      </tr>
     <% i++; %>        
  </c:forEach>
  <tr>
    <td colspan="2" ><c:out value="--------------------------------------"></c:out></td>   
  </tr>
  <tr>
    <td><c:out value="Result"></c:out></td>   
  </tr>
  <tr>
    <td colspan="2">
        <c:out value="Language"></c:out>
        <c:out value="HTML"></c:out>
    </td>   
  </tr>
  <tr>
    <td colspan="2">
        <c:out value="Total Question"></c:out>
        <c:out value="10"></c:out>
    </td>   
  </tr>
  <tr>
    <td colspan="2" >
        <c:out value="Result Marks"></c:out>
        <c:out value="8"></c:out>
    </td>   
  </tr>
  <tr>
    <td colspan="2" >
       <c:out value="Number of right answer : "></c:out>
       <c:out value="8"></c:out>
   </td>   
  </tr>
  <tr>
    <td colspan="2" >
      <c:out value="Number of wrong answer : "></c:out>
      <c:out value="2"></c:out>
    </td>   
  </tr>
</table>
</body>
</html>