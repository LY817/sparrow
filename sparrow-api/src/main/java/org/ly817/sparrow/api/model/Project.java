package org.ly817.sparrow.api.model;

/**
 * @author LuoYu
 * @date 2019/06/06 9:16
 * <p>
 * Description:
 */
public class Project {
    private Long projectId;

    private String projectName;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
