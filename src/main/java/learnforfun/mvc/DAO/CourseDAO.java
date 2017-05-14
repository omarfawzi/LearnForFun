package learnforfun.mvc.DAO;

import learnforfun.mvc.Models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CourseDAO {
    public void insert(Course course);

    public void delete(int ID);

    public int getID(String name);

    public ArrayList<Course> TeacherCourses(int ID);

    public ArrayList<Course> AllCourses();

    public boolean register(int courseID, int userID);

    public ArrayList<Integer> registeredCourses(int userID);

    public boolean unregister(int courseID, int userID);

    public ArrayList<Integer> getRegisteredUsers(int courseID);

    public Integer getCourseowner(int courseID);
}
