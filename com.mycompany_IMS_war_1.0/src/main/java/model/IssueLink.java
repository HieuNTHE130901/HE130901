/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trung
 */
public class IssueLink {
      private int issueId;
    private int linkedIssueId;

    public IssueLink() {
    }

    public IssueLink(int issueId, int linkedIssueId) {
        this.issueId = issueId;
        this.linkedIssueId = linkedIssueId;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getLinkedIssueId() {
        return linkedIssueId;
    }

    public void setLinkedIssueId(int linkedIssueId) {
        this.linkedIssueId = linkedIssueId;
    }
    
    
}
