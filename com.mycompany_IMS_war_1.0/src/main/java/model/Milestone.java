/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author trung
 */
public class Milestone {
     private int milestoneId;
    private int projectId;
    private String milestoneTitle;
    private String milestoneDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    
     public Milestone() {
    }
    

    public Milestone(int milestoneId, int projectId, String milestoneTitle, String milestoneDescription, LocalDate startDate, LocalDate endDate) {
        this.milestoneId = milestoneId;
        this.projectId = projectId;
        this.milestoneTitle = milestoneTitle;
        this.milestoneDescription = milestoneDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(int milestoneId) {
        this.milestoneId = milestoneId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getMilestoneTitle() {
        return milestoneTitle;
    }

    public void setMilestoneTitle(String milestoneTitle) {
        this.milestoneTitle = milestoneTitle;
    }

    public String getMilestoneDescription() {
        return milestoneDescription;
    }

    public void setMilestoneDescription(String milestoneDescription) {
        this.milestoneDescription = milestoneDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    
}
