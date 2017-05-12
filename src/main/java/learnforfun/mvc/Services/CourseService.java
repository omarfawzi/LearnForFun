package learnforfun.mvc.Services;

import learnforfun.mvc.DAO.CourseDAO;
import learnforfun.mvc.DAOImp.CourseDAOImpl;
import learnforfun.mvc.Models.Course;

import java.util.ArrayList;

public class CourseService
{
    private CourseDAO courseDAO = new CourseDAOImpl();
    public void addCourse(Course course){
        courseDAO.insert(course);
    }

    public void deleteCourse(int ID){
        courseDAO.delete(ID);
    }

    public int getCourseID(String name){
        return courseDAO.getID(name);
    }

    public ArrayList<Course> showTeacherCourses(int ID){
        return courseDAO.TeacherCourses(ID);
    }

    public ArrayList<Course> showAllCourses(){
        return courseDAO.AllCourses();
    }

    public boolean registerCourse(Course course){
        return courseDAO.register(course.getID(),course.getUserID());
    }

    public boolean unregisterCourse(Course course){
        return courseDAO.unregister(course.getID(),course.getUserID());
    }


    public ArrayList<Integer> getRegisteredCourses(int userID){
        return courseDAO.registeredCourses(userID);
    }
}
