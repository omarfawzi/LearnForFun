package learnforfun.mvc.Models;

/**
 * Created by Omar on 13-May-17.
 */
public class Notifications {
    private String type, notifizer, notified;
    private int courseID;

    public Notifications() {
    }

    public Notifications(String type, String notifizer, String notified, int courseID) {
        this.type = type;
        this.notifizer = notifizer;
        this.notified = notified;
        this.courseID = courseID;
    }

    public Notifications(Notifications other) {
        this.type = other.type;
        this.notifizer = other.notifizer;
        this.notified = other.notified;
        this.courseID = other.courseID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotifizer() {
        return notifizer;
    }

    public void setNotifizer(String notifizer) {
        this.notifizer = notifizer;
    }

    public String getNotified() {
        return notified;
    }

    public void setNotified(String notified) {
        this.notified = notified;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }
}
