package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Issue;

public class IssueDAO {

    private DBContext dbContext;

    public IssueDAO() {
        dbContext = new DBContext();
    }

    public List<Issue> getAllIssues() {
        List<Issue> issues = new ArrayList<>();

        try (Connection connection = dbContext.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM Issues")) {

            while (resultSet.next()) {
                Issue issue = extractIssueFromResultSet(resultSet);
                issues.add(issue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issues;
    }

    public Issue getIssueById(int issueId) {
        Issue issue = null;

        try (Connection connection = dbContext.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM Issues WHERE issue_id = ?")) {

            statement.setInt(1, issueId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                issue = extractIssueFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issue;
    }

    public boolean addIssue(Issue issue) {
        boolean success = false;

        try (Connection connection = dbContext.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Issues (project_id, issue_type, issue_status, issue_description, "
                + "created_by, created_date, updated_by, updated_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.setInt(1, issue.getProjectId());
            statement.setString(2, issue.getIssueType());
            statement.setString(3, issue.getIssueStatus());
            statement.setString(4, issue.getIssueDescription());
            statement.setInt(5, issue.getCreatedBy());
            statement.setTimestamp(6, Timestamp.valueOf(issue.getCreatedDate()));
            statement.setInt(7, issue.getUpdatedBy());
            statement.setTimestamp(8, Timestamp.valueOf(issue.getUpdatedDate()));

            int rowsAffected = statement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public boolean updateIssue(int issueId, String issueType, String issueStatus, String issueDescription, int updatedBy) {
        boolean success = false;

        try (Connection connection = dbContext.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "UPDATE Issues SET issue_type = ?, issue_status = ?, issue_description = ?, updated_by = ?, updated_date = CURRENT_TIMESTAMP WHERE issue_id = ?")) {

            statement.setString(1, issueType);
            statement.setString(2, issueStatus);
            statement.setString(3, issueDescription);
            statement.setInt(4, updatedBy);
            statement.setInt(5, issueId);

            int rowsAffected = statement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public boolean deleteIssue(int issueId) {
        boolean success = false;

        try (Connection connection = dbContext.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM Issues WHERE issue_id = ?")) {

            statement.setInt(1, issueId);

            int rowsAffected = statement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    private Issue extractIssueFromResultSet(ResultSet resultSet) throws SQLException {
        int issueId = resultSet.getInt("issue_id");
        int projectId = resultSet.getInt("project_id");
        String issueType = resultSet.getString("issue_type");
        String issueStatus = resultSet.getString("issue_status");
        String issueDescription = resultSet.getString("issue_description");
        int createdBy = resultSet.getInt("created_by");
        LocalDateTime createdDate = resultSet.getTimestamp("created_date").toLocalDateTime();
        int updatedBy = resultSet.getInt("updated_by");
        LocalDateTime updatedDate = resultSet.getTimestamp("updated_date").toLocalDateTime();

        return new Issue(issueId, projectId, issueType, issueStatus, issueDescription,
                createdBy, createdDate, updatedBy, updatedDate);
    }

    public List<Issue> getIssuesByUserId(int userId) {
        List<Issue> issues = new ArrayList<>();

        String sql = "SELECT i.issue_id, i.project_id, i.issue_type, i.issue_status, i.issue_description, "
                + "i.created_by, i.created_date, i.updated_by, i.updated_date "
                + "FROM Issues AS i "
                + "INNER JOIN ProjectMembers AS pm ON i.project_id = pm.project_id "
                + "WHERE pm.user_id = ?";

        try (Connection connection = dbContext.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Issue issue = extractIssueFromResultSet(resultSet);
                issues.add(issue);
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions here
            e.printStackTrace();
        }

        return issues;
    }

}
