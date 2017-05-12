package learnforfun.mvc.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import learnforfun.mvc.DAO.CourseDAO;
import learnforfun.mvc.DAO.MultipleChoiceDAO;
import learnforfun.mvc.DAO.True_FalseDAO;
import learnforfun.mvc.Models.Course;

public class CourseDAOImpl implements CourseDAO
{
    private PreparedStatement pstmt;
    private Connection con;

    public CourseDAOImpl()
    {
        String dbdriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/learnforfun";
        String username = "root";
        String password = "root";
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void insert(Course course)
    {
    	try 
    	{
			pstmt = con.prepareStatement("INSERT INTO COURSE (NAME, DESCRIPTION, UID) VALUES(?, ?, ?)");
			
			pstmt.setString(1, course.getName());
			pstmt.setString(2, course.getDescription());
			pstmt.setInt(3, course.getUserID());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @Override
    public void delete(int ID)
    {
    	True_FalseDAO tf = new True_FalseDAOImpl();
    	MultipleChoiceDAO mc = new MultipleChoiceDAOImpl();
    	
    	tf.deleteCourseGames(ID);
    	mc.deleteCourseGames(ID);
    	
    	try 
    	{
			pstmt = con.prepareStatement("DELETE FROM COURSE WHERE CID = ?");
			
			pstmt.setInt(1, ID);
			
			pstmt.executeUpdate();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}    	
    }

    @Override
    public int getID(String name)
    {
    	try 
    	{
    		pstmt = con.prepareStatement("SELECT CID FROM COURSE WHERE NAME = ?");
    		
    		pstmt.setString(1, name);
    		
    		ResultSet rs = pstmt.executeQuery();
    		
    		if(rs.next())
    			return rs.getInt(1);
    			
    	} catch (Exception e) {
			// TODO: handle exception
		} 
    	
    	return -1;
    }
    
    @Override
    public ArrayList<Course> TeacherCourses(int ID)
    {
    	ArrayList<Course> courses = new ArrayList<Course>();
    	Course course;
    	
    	try 
    	{
			pstmt = con.prepareStatement("SELECT * FROM COURSE WHERE UID = ?");
			
			pstmt.setInt(1, ID);
			
			ResultSet rs  = pstmt.executeQuery();
			
			while (rs.next())
			{
				course = new Course();
				
				course.setName(rs.getString("NAME"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setID(rs.getInt("CID"));
				course.setUserID(rs.getInt("UID"));
				
				courses.add(course);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return courses;
    }
    
    @Override
    public ArrayList<Course> AllCourses()
    {
    	ArrayList<Course> courses = new ArrayList<Course>();
    	Course course;
    	
    	try 
    	{
			pstmt = con.prepareStatement("SELECT * FROM COURSE");
						
			ResultSet rs  = pstmt.executeQuery();
			
			while (rs.next())
			{
				course = new Course();
				course.setName(rs.getString("NAME"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setID(rs.getInt("CID"));
				course.setUserID(rs.getInt("UID"));
				courses.add(course);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return courses;
    }

	@Override
	public boolean register(int courseID, int userID) {
		try {
			pstmt = con.prepareStatement("INSERT INTO USER_HISTORY (USER_ID, COURSE_ID) VALUES(?, ?)");
			pstmt.setInt(1,userID);
			pstmt.setInt(2,courseID);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Integer> registeredCourses(int userID) {
    	ArrayList<Integer> temp = new ArrayList<Integer>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM USER_HISTORY WHERE USER_ID = ?");
			pstmt.setInt(1,userID);
			ResultSet rs  = pstmt.executeQuery();
			while (rs.next())
			{
				temp.add(rs.getInt("COURSE_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public boolean unregister(int courseID, int userID) {
		try {
			pstmt = con.prepareStatement("DELETE FROM USER_HISTORY where USER_ID = ? and COURSE_ID = ?");
			pstmt.setInt(1,userID);
			pstmt.setInt(2,courseID);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
}
