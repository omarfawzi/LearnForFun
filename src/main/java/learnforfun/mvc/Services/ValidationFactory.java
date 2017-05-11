package learnforfun.mvc.Services;

/**
 * Created by Omar on 11-May-17.
 */
public class ValidationFactory {
    public Validation getValidation(String type){
        if (type == null)
            return null;
        else if (type.equals("teacher"))
            return new TeacherValidation();
        else if (type.equals("student"))
            return new StudentValidation();
        return null;
    }
}
