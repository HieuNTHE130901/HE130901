/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trung
 */
public class ProjectMember {
       private int projectId;
    private int userId;
    private boolean isTeamLeader;

    public ProjectMember() {
    }

    public ProjectMember(int projectId, int userId, boolean isTeamLeader) {
        this.projectId = projectId;
        this.userId = userId;
        this.isTeamLeader = isTeamLeader;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isIsTeamLeader() {
        return isTeamLeader;
    }

    public void setIsTeamLeader(boolean isTeamLeader) {
        this.isTeamLeader = isTeamLeader;
    }
    
    
    
}
