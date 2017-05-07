package learnforfun.mvc.Controllers;
import learnforfun.mvc.DAO.UserDAO;
import learnforfun.mvc.DAOImp.UserDAOImpl;
import learnforfun.mvc.Models.*;
import learnforfun.mvc.Services.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.ArrayList;

@RestController
@EnableWebMvc
public class HomeController {
    private StudentValidation student = new StudentValidation();
    private TeacherValidation teacher = new TeacherValidation();
    private TeacherProfile teacherProfile = new TeacherProfile();
    private StudentProfile studentProfile = new StudentProfile();
    private CourseService courseService = new CourseService();
    private TFService tfService = new TFService();
    private MCQService mcqService = new MCQService();
    private HangManService hangManService = new HangManService();
    private UserDAO userDAO = new UserDAOImpl();

    @RequestMapping("/")
    public @ResponseBody
    ModelAndView index() {
        ModelAndView modelandview = new ModelAndView("index");
        return modelandview;
    }

    @RequestMapping("/signout/{username}")
    public @ResponseBody
    ModelAndView signOut(@PathVariable("username") String username) {
        userDAO.delete(username);
        String redirect = "http://localhost:8080/Learn-For-Fun/";
        return new ModelAndView("redirect:"+ redirect);
    }

    @RequestMapping("/sign/{type}")
    public @ResponseBody
    ModelAndView accountView(@PathVariable("type") String type) {
        ModelAndView modelandview = new ModelAndView();
        if (!type.equals("teacher") && !type.equals("student")){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun");
        }
        else {
            modelandview.setViewName("account");
            modelandview.addObject("type", type);
        }
        return modelandview;
    }

    @RequestMapping(value = "/sign/{type}/{mail}/{password}/{userName}/{phone}/{firstName}/{lastName}/{bDate}/{gender}", method = RequestMethod.POST)
    public @ResponseBody
    Integer SignUp(@ModelAttribute Account object, @PathVariable("type") String type) {
        int ret = 0;
        if (type.equals("teacher"))
            ret = teacher.SignUp(object);
        else if (type.equals("student"))
            ret = student.SignUp(object);
        if (ret >= 0)
            userDAO.insert(object.getUserName());
        return ret;
    }

    @RequestMapping(value = "/sign/{type}/{mail}/{password}", method = RequestMethod.POST)
    public @ResponseBody
    Integer SignIn(@ModelAttribute Account object, @PathVariable("type") String type) {
        int ret = 0;
        Account acc = new Account();
        if (type.equals("teacher")) {
            ret = teacher.SignIn(object.getMail(), object.getPassword());
            acc = teacherProfile.getAccount(ret);
        }
        else if (type.equals("student")) {
            ret = student.SignIn(object.getMail(), object.getPassword());
            acc = studentProfile.getAccount(ret);
        }
        if (ret >= 0)
            userDAO.insert(acc.getUserName());
        return ret;
    }

    @RequestMapping(value = "/profile/{type}/{userID}")
    public @ResponseBody
    ModelAndView homepageView(@PathVariable("type") String type, @PathVariable("userID") int userID){
        Account acc = new Account();
        ModelAndView modelandview = new ModelAndView();
        if (type.equals("teacher")) {
            acc = teacherProfile.getAccount(userID);
        } else if (type.equals("student")) {
            acc = studentProfile.getAccount(userID);
        }
        if ( (!type.equals("teacher") && !type.equals("student")) || (acc == null)){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun");
            return modelandview;
        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            modelandview = new ModelAndView("homepage");
            modelandview.addObject("type", type);
            modelandview.addObject("userID", userID);
            modelandview.addObject("account", acc);
            return modelandview;
        }
    }

    @RequestMapping(value = "/profileSettings/{type}/{userID}")
    public @ResponseBody
    ModelAndView profileView(@PathVariable("type") String type, @PathVariable("userID") int userID) {
        Account acc = new Account();
        ModelAndView modelandview = new ModelAndView();

        if (type.equals("teacher")) {
            acc = teacherProfile.getAccount(userID);
        } else if (type.equals("student")) {
            acc = studentProfile.getAccount(userID);
        }
        if ( (!type.equals("teacher") && !type.equals("student")) || (acc == null)){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun/profile/"+type+'/'+userID);
            return modelandview;
        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            modelandview.setViewName("profile");
            modelandview.addObject("type", type);
            modelandview.addObject("userID", userID);
            modelandview.addObject("account", acc);
            return modelandview;
        }
    }

    @RequestMapping(value = "/profileSettings/update/{type}/{userID}/{mail}/{password}/{phone}/{firstName}/{lastName}/{bDate}/{gender}", method = RequestMethod.POST)
    public @ResponseBody
    Boolean UpdateProfile(@ModelAttribute Account object, @PathVariable("type") String type) {
        boolean ret = false;
        if (type.equals("teacher")) {
            ret = teacherProfile.updateAccount(object);
        } else if (type.equals("student")) {
            ret = studentProfile.updateAccount(object);
        }
        return ret;
    }

    @RequestMapping(value = "/createCourse/{type}/{userID}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView createcourseView(@PathVariable("type") String type, @PathVariable("userID") int userID){
        Account acc = new Account();
        ModelAndView modelandview = new ModelAndView();

        if (type.equals("teacher")) {
            acc = teacherProfile.getAccount(userID);
        } else if (type.equals("student")) {
            acc = studentProfile.getAccount(userID);
        }

        if ( (!type.equals("teacher") && !type.equals("student")) || (acc == null)){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun/profile/"+type+'/'+userID);
            return modelandview;

        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            modelandview.setViewName("createCourse");
            modelandview.addObject("type", type);
            modelandview.addObject("userID", userID);
            modelandview.addObject("account", acc);
            return modelandview;

        }
    }

    @RequestMapping(value = "/createCourse/{userID}/{name}/{description}", method = RequestMethod.POST)
    public @ResponseBody
    int createCourse(@ModelAttribute Course course){
        if (courseService.getCourseID(course.getName()) == -1) {
            courseService.addCourse(course);
            return courseService.getCourseID(course.getName());
        }
        return -1;
    }

    @RequestMapping(value = "/showCourses/{courses}/{type}/{userID}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView coursesView(@PathVariable("type") String type, @PathVariable("userID") int userID,@PathVariable("courses") String coursetype){
        Account acc = new Account();
        ModelAndView modelandview = new ModelAndView();
        if (type.equals("teacher")) {
            acc = teacherProfile.getAccount(userID);
        } else if (type.equals("student")) {
            acc = studentProfile.getAccount(userID);
        }

        ArrayList<Course> courses = new ArrayList<Course>();
        if (coursetype.equals("allCourses"))
            courses = courseService.showAllCourses();
        else if (coursetype.equals("createdCourses"))
            courses = courseService.showTeacherCourses(userID);

        if ( (!type.equals("teacher") && !type.equals("student")) || (acc == null) ||(!coursetype.equals("allCourses") &&!coursetype.equals("createdCourses") )){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun/profile/"+type+'/'+userID);
            return modelandview;

        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            modelandview.setViewName("courses");
            modelandview.addObject("type", type);
            modelandview.addObject("userID", userID);
            modelandview.addObject("account", acc);
            modelandview.addObject("courses", courses);
            return modelandview;

        }
    }

    @RequestMapping(value = "/addGames/{type}/{courseID}/{userID}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView addGameView(@PathVariable("type") String type,@PathVariable("courseID") int courseID, @PathVariable("userID") int userID){
        ModelAndView modelAndView = new ModelAndView();
        Account acc = teacherProfile.getAccount(userID);

        if ( (!type.equals("teacher") && !type.equals("student")) ||(acc == null)){
            modelAndView.setViewName("404");
            modelAndView.addObject("homepage","http://localhost:8080/Learn-For-Fun/profile/"+type+'/'+userID);
            return modelAndView;

        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            modelAndView.setViewName("addGames");
            modelAndView.addObject("type", type);
            modelAndView.addObject("userID", userID);
            modelAndView.addObject("courseID", courseID);
            modelAndView.addObject("account", acc);
            return modelAndView;

        }
    }

    @RequestMapping(value = "/addGames/{courseID}/{gameName}/{question}/{answer}", method = RequestMethod.POST)
    public @ResponseBody
    Boolean addTFGame(@ModelAttribute True_False tf){
            if (tfService.getGameID(tf.getGameName()) == -1) {
                tfService.addGame(tf);
                return true;
            }
        return false;
    }

    @RequestMapping(value = "/addGames/{courseID}/{gameName}/{question}/{answer}/{choice1}/{choice2}/{choice3}/{choice4}", method = RequestMethod.POST)
    public @ResponseBody
    Boolean addMCQGame(@ModelAttribute MultipleChoice mcq){
        if (mcqService.getGameID(mcq.getGameName()) == -1) {
            mcqService.addGame(mcq);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/addGames/{courseID}/{gameName}/{question}/{answer}/{hint}", method = RequestMethod.POST)
    public @ResponseBody
    Boolean addHangman(@ModelAttribute HangMan hangMan){
        if (hangManService.getGameID(hangMan.getGameName()) == -1) {
            hangManService.addGame(hangMan);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/showGames/{type}/{userID}/{courseID}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView showGames(@PathVariable("type") String type,@PathVariable("userID") int userID,@PathVariable("courseID") int courseID ){
        Account acc = new Account();
        ModelAndView modelandview = new ModelAndView();
        if (type.equals("teacher")) {
            acc = teacherProfile.getAccount(userID);
        } else if (type.equals("student")) {
            acc = studentProfile.getAccount(userID);
        }

        if ( (!type.equals("teacher") && !type.equals("student")) ||(acc == null)){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun/profile/"+type+'/'+userID);
            return modelandview;

        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            ArrayList<True_False> true_falses = tfService.getCourseGames(courseID);
            ArrayList<MultipleChoice> multipleChoices = mcqService.getCourseGames(courseID);
            ArrayList<HangMan> hangMen = hangManService.getCourseGames(courseID);
            modelandview.setViewName("games");
            modelandview.addObject("type", type);
            modelandview.addObject("userID", userID);
            modelandview.addObject("true_falses", true_falses);
            modelandview.addObject("multipleChoices", multipleChoices);
            modelandview.addObject("hangMen", hangMen);
            modelandview.addObject("account", acc);
            return modelandview;

        }
    }

    @RequestMapping(value = "/hangMan/{type}/{userID}/{gameID}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView hangManView(@PathVariable("type") String type,@PathVariable("userID") int userID,@PathVariable("gameID") int gameID ){
        Account acc = new Account();
        ModelAndView modelandview = new ModelAndView();
        if (type.equals("teacher")) {
            acc = teacherProfile.getAccount(userID);
        } else if (type.equals("student")) {
            acc = studentProfile.getAccount(userID);
        }
        if ( (!type.equals("teacher") && !type.equals("student")) ||(acc == null)){
            modelandview.setViewName("404");
            modelandview.addObject("homepage","http://localhost:8080/Learn-For-Fun/profile/"+type+'/'+userID);
            return modelandview;

        }
        boolean exists = userDAO.exists(acc.getUserName());
        if (!exists){
            String redirect = "http://localhost:8080/Learn-For-Fun/sign/"+type;
            return new ModelAndView("redirect:"+ redirect);
        }
        else {
            modelandview.setViewName("hangman");
            HangMan hangMan = hangManService.getGame(gameID);
            modelandview.addObject("type", type);
            modelandview.addObject("userID", userID);
            modelandview.addObject("account", acc);
            modelandview.addObject("game", hangMan);
            return modelandview;
        }
    }


}
