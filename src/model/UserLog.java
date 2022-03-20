package model;

import com.sun.net.httpserver.Authenticator;

import java.time.LocalDateTime;

public class UserLog {
    private Integer id;
    private User user;
    private LocalDateTime enterDate;
    private Success success;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDateTime enterDate) {
        this.enterDate = enterDate;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }
}
