/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trung
 */
public class Subject {
     private int subjectId;
    private String subjectCode;
    private String subjectName;
    private String description;
    private String gitlabConfig;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitlabConfig() {
        return gitlabConfig;
    }

    public void setGitlabConfig(String gitlabConfig) {
        this.gitlabConfig = gitlabConfig;
    }

    public Subject(int subjectId, String subjectCode, String subjectName, String description, String gitlabConfig) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.description = description;
        this.gitlabConfig = gitlabConfig;
    }

    public Subject() {
    }

    
}
