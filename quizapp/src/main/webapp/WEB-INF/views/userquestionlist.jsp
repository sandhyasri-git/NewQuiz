<%@include file="header.jsp" %>
<body>

<c:if test="${!empty allQuestionList}">
<table align="center" border="10" bordercolor=green">
 <tr>
   <th><center>
     <c:out value="Language"></c:out></center>
   </th>
   <th>
   <center><c:out value="Question"></c:out></center>
    </th>
    <th>
      <center><c:out value="Answer1"></c:out></center>
    </th>
    <th>
      <center><c:out value="Answer2"></c:out></center>
    </th>
    <th>
      <center><c:out value="Answer3"></c:out></center>
    </th>
    <th>
      <center><c:out value="Answer4"></c:out></center>
    </th>
   <th>
      <center><c:out value="RightAnswer"></c:out></center>
    </th>
  
 </tr>
<c:forEach var="questionPaperCommand" items="${allQuestionList}" >
     <tr> 
       <td><c:out value="${questionPaperCommand.languageName}"></c:out></td>      
       <td  >
         <a href="addquestion?questionId=${questionPaperCommand.questionId}" >
             <c:out value="${questionPaperCommand.question}" ></c:out>
         </a>
       </td>
       <td><c:out value="${questionPaperCommand.option1}"></c:out></td>
       <td><c:out value="${questionPaperCommand.option2}"></c:out></td>
       <td><c:out value="${questionPaperCommand.option3}"></c:out></td>
       <td><c:out value="${questionPaperCommand.option4}"></c:out></td> 
       <td><input type="text" name="t1"></td>         
     </tr>
         
  </c:forEach>
</table>
</c:if>  
</body>
</html>