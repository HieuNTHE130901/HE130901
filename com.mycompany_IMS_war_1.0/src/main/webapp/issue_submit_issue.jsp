<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="model.Issue" %> 
<%@ page import="dao.IssueDAO" %> 

<%
  // Retrieve the form data from the request
  int projectID = Integer.parseInt(request.getParameter("projectID"));
  String issueType = request.getParameter("issueType");
  String issueStatus = request.getParameter("issueStatus");
  String issueDescription = request.getParameter("issueDescription");
  int createdBy = Integer.parseInt(request.getParameter("createdBy"));
  // Create a new Issue object with the form data
    Issue issue = new Issue();
    issue.setProjectId(projectID);
    issue.setIssueType(issueType);
    issue.setIssueStatus(issueStatus);
    issue.setIssueDescription(issueDescription);
    issue.setCreatedBy(createdBy);
    issue.setCreatedDate(LocalDateTime.now());
    issue.setUpdatedBy(createdBy);
    issue.setUpdatedDate(LocalDateTime.now());

  // Save the issue to the database using the DAO
  IssueDAO issueDAO = new IssueDAO(); // Instantiate your IssueDAO class
  boolean success = issueDAO.addIssue(issue);

  if (success) {
    // Redirect the user to a success page or display a success message
    response.sendRedirect("view_issue.jsp"); // Replace "view_issue.jsp" with the appropriate success page
  } else {
    // Redirect the user to an error page or display an error message
    response.sendRedirect("error.jsp"); // Replace "error.jsp" with the appropriate error page
  }
%>