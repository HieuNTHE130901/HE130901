package test;

import dao.IssueDAO;

public class test {

    public static void main(String[] args) {
        // Define the values you want to update
        int issueIdToUpdate = 21;
        String updatedIssueType = "Test";
        String updatedIssueStatus = "Test";
        String updatedIssueDescription = "Test";
        int updatedBy = 1;

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
            System.out.println("Issue updated successfully.");
        } else {
            System.out.println("Error updating the issue.");
        }
    }
}
