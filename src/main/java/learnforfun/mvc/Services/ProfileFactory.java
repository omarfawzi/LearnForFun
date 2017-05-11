package learnforfun.mvc.Services;

/**
 * Created by Omar on 11-May-17.
 */
public class ProfileFactory {
    public UserProfile getProfile(String type){
        if (type == null)
            return null;
        else if (type.equals("teacher"))
            return new TeacherProfile();
        else if (type.equals("student"))
            return new StudentProfile();
        return null;
    }
}
