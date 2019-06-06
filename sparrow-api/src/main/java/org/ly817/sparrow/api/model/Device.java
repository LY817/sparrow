package org.ly817.sparrow.api.model;

/**
 * @author LuoYu
 * @date 2019/06/06 9:12
 * <p>
 * Description:
 */
public class Device {
    private Long deviceId;

    private Long imei;

    private Long userId;

    private Long projectId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
