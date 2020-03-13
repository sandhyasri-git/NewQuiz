<%@include file="header.jsp"%>
<body>
  <h2 align="center" >Question Paper</h2>
 <hr width=600 >
 
<form:form action="questionpaper" >
 <table align="center" >
 <c:if test="${!empty questionPaperList}"> 
   <% int i=0; %>
   
   <c:forEach var="questionPaperCommand" items="${questionPaperList}" >
     <input type="hidden"  name="question" />   
     <input type="hidden" value="${questionPaperCommand.questionId}" name="quesNum[<%=i%>]" />   
     <tr>       
       <td>
          <c:out value="<%=i+1%>"></c:out>
          <c:out value="."></c:out>
          <c:out value="Question :"></c:out>
          <c:out value="${questionPaperCommand.question}"></c:out></td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option1Id}">
        <c:out value="${questionPaperCommand.option1}"></c:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option2Id}">
        <c:out value="${questionPaperCommand.option2}"></c:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option3Id}">
        <c:out value="${questionPaperCommand.option3}"></c:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option4Id}">
        <c:out value="${questionPaperCommand.option4}"></c:out>
       </td>
     </tr>
     <% i++; %>   
    </c:forEach>   
     
     <tr>
       <td> 
         <input type="submit" value="Submit"  />
       </td>
     </tr>
  </c:if> 
  <c:if test="${empty questionPaperList}">
    <tr>
      <td>
       <c:out value="Not Avaliable Any Question"></c:out>
      </td> 
    </tr>
  </c:if>    
 </table>
</form:form>

</body>
</html>