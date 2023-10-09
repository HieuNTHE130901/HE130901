<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="model.Issue" %> 
<%@ page import="dao.IssueDAO" %> 

<%
  // Retrieve the form data from the request

  
   int issueIdToUpdate = Integer.parseInt(request.getParameter("issueId"));
        String updatedIssueType = request.getParameter("issueType");
        String updatedIssueStatus = request.getParameter("issueStatus");
        String updatedIssueDescription = request.getParameter("issueDescription");
        int updatedBy = Integer.parseInt(request.getParameter("updatedBy"));

        // Create an IssueDAO instance
        IssueDAO issueDAO = new IssueDAO();

        // Update the issue
        boolean success = issueDAO.updateIssue(
                issueIdToUpdate,
                updatedIssueType,
                updatedIssueStatus,
                updatedIssueDescription,
                updatedBy
        );

  if (success) {
    // Redirect the user to a success page
    response.sendRedirect("view_issue.jsp"); // Replace "success.jsp" with the appropriate success page path
  } else {
    // Redirect the user to an error page
    response.sendRedirect("error.jsp"); // Replace "error.jsp" with the appropriate error page path
  }
%>
