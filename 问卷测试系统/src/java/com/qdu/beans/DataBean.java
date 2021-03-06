package com.qdu.beans;

import com.qdu.dao.StudentDao;
import com.qdu.dao.ManagerDao;
import com.qdu.dao.CourseDao;
import com.qdu.dao.GradeDao;
import com.qdu.dao.QuestionDao;
import com.qdu.dao.StudentCourseDao;
import com.qdu.dao.TestApplicationDao;
import com.qdu.pojo.Course;
import com.qdu.pojo.Grade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.qdu.pojo.Student;
import com.qdu.pojo.Manager;
import com.qdu.pojo.Question;
import com.qdu.pojo.StudentCourse;
import com.qdu.pojo.TestApplication;
import com.qdu.util.ExcelUtil;
import com.qdu.util.HibernateUtil;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
@SessionScoped
public class DataBean {

    private int stId;//输入的编号
    private String spwd=null;//输入的密码
    private Student student=new Student();
    private Manager manager;
    private Question question=new Question();
    private Course course=new Course();
    private Grade grade=new Grade();
    private TestApplication applications=new TestApplication();
    private String message;
    private String color;
    private List<Course> courselist;
    private List<StudentCourse> scourselist;
    private List<Question> questionlist;
    private List<Grade> gradelist;
    private List<TestApplication> applicationlist;
    private HashMap dateMap;//时间列表
    private String gradeTime="2018-12-25";
    private int gradesno;
    private String courseid;
    private String coursename;
    private String coursemodule;
    private String noneortable="none";
    private String application;

    private HashMap courseMap;  //存储从数据库获取的所有类别，并提供给index.xhtml显示
    private String selectedCourseId; //存储选中的类别的编号 
    private HashMap<Integer, Question> questionMap; //存储选中类别对应的所有问题
    private int currentQuestionId; //当前题目的编号
    private Question currentQuestion; //当前问题的内容
    private String currentChoice; //存储和现实当前题目的选项
    private HashMap<Integer, String> choiceMap;  //存储学生选择的所有选项
    private int marks; //存储计算的成绩并显示在result页面
    private String result; //显示一个结果，挂科还是通过
    
    
    //学生登录
    public String findStudent() {
        StudentDao dao = new StudentDao();
        student = dao.findStudentBystidspwd(stId, spwd);
        if (student != null) {
            return "index_2";
        } else {
            return "fail";
        }
    }
    // 学生信息注册
    public void registerStudent() {
        StudentDao dao = new StudentDao();
        int rows = dao.insert(student);
        if (rows != 0) {
            message = "注册成功，请跳转到登陆页面登录！";
            color = "green";
        } else {
            message = "注册失败，请检查信息！";
            color = "red";
        }
    }

    //修改密码
    public String updateSpwd() {
        StudentDao dao = new StudentDao();
        dao.updateSpwd(student.getStudentId(), spwd);
        return "index";
    }

    //学生修改信息
    public String updateSInfo() {
        StudentDao dao = new StudentDao();
        dao.updateSInfo(student.getStudentId(), student.getStudentAge(), student.getStudentMobile());
        return "success";
    }

    //查询管理员
    public String findManager() {
        ManagerDao dao = new ManagerDao();
        manager = dao.findManagerBymnompwd(stId, spwd);
        if (manager != null) {
            return "managersuccess";
        } else {
            return "fail";
        }
    }

    //管理员修改密码
    public String updateMpwd() {
        ManagerDao dao = new ManagerDao();
        dao.updateMpwd(stId, spwd);
        return "index";
    }

    //准备考试
    public String readyExam() {
        CourseDao dao = new CourseDao();
        courseMap = dao.getCourses();
        return "readyexam";
    }
    //删除类别页面
        public String deleteCourse() {
        CourseDao dao = new CourseDao();
        courselist = dao.getAllCourses();
        return "deleteCourse";
    }
    //删除类别
    public String deleteCourseById(String sid){
    CourseDao dao = new CourseDao();
    dao.deleteCourseById(sid);
    courselist = dao.getAllCourses();
    return "deleteCourse";
    }

     //更改类别信息   
    public void updateCourse(String cid,String cname,int credit,String module) {
        CourseDao dao = new CourseDao();
        dao.updateCourse(cid, cname,credit,module);
        courselist = dao.getAllCourses();
    }   
    //添加类别
    public String insertCourse() {
        CourseDao dao = new CourseDao();
        int rows = dao.insert(course);
        return "managersuccess";
    }
    //添加试题
    public String insertQuestion() {
    QuestionDao dao = new QuestionDao();
    dao.insert(question.getQuestionDesc(),question.getAnswerA(),question.getAnswerB(),question.getAnswerC(),question.getAnswerD(),question.getAnswerKey(),question.getCredit(),currentQuestionId,selectedCourseId);
    return "managersuccess";
    }
    
    //删除试题页面
        public String deleteQuestion() {
        QuestionDao dao = new QuestionDao();
        questionlist = dao.getAllQuestions();
        return "deleteQuestion";
    }
    //删除试题
    public String deleteQuestionById(int qid,String cid){
    QuestionDao dao = new QuestionDao();
    dao.deleteQuestionById(qid,cid);
    questionlist = dao.getAllQuestions();
    return "selectQuestion";
    }
     //更改试题信息   
    public void updateQuestion(int qid, String cid, String desc, String A, String B, String C, String D, String key, int credit) {
        QuestionDao dao = new QuestionDao();
        dao.updateQuestion(qid, cid, desc, A, B, C, D, key, credit);
        questionlist = dao.getAllQuestions();
    }  
    //学生查询成绩
    public String queryGrades(){
        GradeDao dao=new GradeDao();
        gradelist=dao.findGradeBySid(student.getStudentId());
        return "queryGrade";
    }

    //通过类别模块排序类别
    public void queryCourseModule(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Course order by cmodule");
        courselist=query.list();
        HibernateUtil.close(session);
    }
    //通过类别模块查询类别
    public void findCourseByCmodule(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Course where cmodule=:cmodule");
        query.setParameter("cmodule", coursemodule);
        courselist=query.list();
        HibernateUtil.close(session);
    }
    //通过类别编号查询类别
    public void findCourseByCid(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Course where courseId=:courseId");
        query.setParameter("courseId", courseid);
        courselist=query.list();
        HibernateUtil.close(session);
    }
    //通过类别名字查询类别
    public void findCourseByCnm(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Course where courseName=:courseName");
        query.setParameter("courseName", coursename);
        courselist=query.list();
        HibernateUtil.close(session);
    }
    //通过类别编号查询已注册类别
    public void findStudentCourseByCid(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from StudentCourse where courseId=:courseId");
        query.setParameter("courseId", courseid);
        scourselist=query.list();
        HibernateUtil.close(session);
    } 
    //查看已注册的类别
    public String queryCourse(){
        StudentCourseDao dao=new StudentCourseDao();
        scourselist=dao.findCourseBySid(student.getStudentId());
        return "queryCourse";
    }
    //删除类别
    public void deleteStudentCourseById(int sid,String cid){
    StudentCourseDao dao = new StudentCourseDao();
    dao.deleteStudentCourseById(sid,cid);
    scourselist = dao.getAllStudentCourses(cid);
    }
    //通过类别编号查询试题
    public void findQuestionByCid(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Question where courseId=:courseId");
        query.setParameter("courseId", courseid);
        questionlist=query.list();
        HibernateUtil.close(session);
    }
    //通过类别编号查询成绩
    public void findGradeByCid(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Grade where courseId=:courseId");
        query.setParameter("courseId", courseid);
        gradelist=query.list();
        HibernateUtil.close(session);
    }
    //通过类别编号查询成绩排名
    public void findGradeByCidOrder(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Grade where courseId=:courseId order by studentGrade desc");
        query.setParameter("courseId", courseid);
        gradelist=query.list();
        HibernateUtil.close(session);
    }
    //通过学号查询成绩
    public void findGradeBySid(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Grade where studentId=:studentId");
        query.setParameter("studentId", stId);
        gradelist=query.list();
        HibernateUtil.close(session);
    }
    //通过日期查询成绩
    public void findGradeByDateCourse(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from Grade where finishDate=:finishDate and courseId=:courseId");
        query.setParameter("finishDate", gradeTime);
        query.setParameter("courseId",courseid);
        gradelist=query.list();
        HibernateUtil.close(session);
    }

    public String beginExam(){
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        CourseDao dao2 = new CourseDao();
        courseMap = dao2.getCourses();
        return "readyexam";
    }
    //查看考试申请
    public void searchApplicationList(){
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("from TestApplication where application=:application");
        query.setParameter("application", application);
        applicationlist=query.list();
        HibernateUtil.close(session);
    }
     //更改考试申请信息   
    public void updateTestApplication(int sid,String cid,String application) {
        TestApplicationDao dao = new TestApplicationDao();
        dao.updateTestApplication(sid,cid,application);
        applicationlist = dao.getAllTestApplication(application);
    }
    

    
    
    
    
    
    
    
    
    
    
    public String startExam() { //开始考试
        QuestionDao dao = new QuestionDao();
        questionMap = dao.getQuestionsByCourseId(selectedCourseId); //获取类别对应的题目
        currentQuestionId = 1;//设置当前题目题号为1
        currentQuestion = questionMap.get(1); //获取1号题目的内容
        choiceMap = new HashMap<>(); //实例化存储答案的集合
        marks = 0; //成绩清零
        currentChoice = null; //设置第一题选项为没有选中任何选项
        return "exam"; //该返回值让页面跳转到exam页面
    }

    //点击上一题时执行的方法
    public void previous() {
        //从第2题开始才能上一题
        if (currentQuestionId > 1) {
            //显示上一题前先记住当前题目的选项，存储到集合
            choiceMap.put(currentQuestionId, currentChoice);
            //题号减一
            currentQuestionId--;
            //获取新题目内容
            currentQuestion = questionMap.get(currentQuestionId);
            //获取新题目选中项，没有则不选中任何项
            currentChoice = choiceMap.get(currentQuestionId);
        }
    }

    //点击下一题执行的方法
    public void next() {
        //在第5题之前才能下一题
        if (currentQuestionId < questionMap.size()) {
            //显示下一题前存储当前题目的选中项
            choiceMap.put(currentQuestionId, currentChoice);
            //题号+1
            currentQuestionId++;
            //获取新题目内容
            currentQuestion = questionMap.get(currentQuestionId);
            //获取新题目选项
            currentChoice = choiceMap.get(currentQuestionId);
        }
    }

    //点击提交按钮执行的方法
    public String submit() {

        //将提交前选择的当前题目的选项存入集合
        choiceMap.put(currentQuestionId, currentChoice);

        //遍历学生选择的答案集合
        for (int i = 1; i <= choiceMap.size(); i++) {
            //遍历过程中获取学生每题选择的选项
            String choice = choiceMap.get(i);
            //从问题集合获取题目对应的答案
            String answerKey = questionMap.get(i).getAnswerKey();
            if (choice.equals(answerKey)) { //判断选中的是否和答案一致
                marks += questionMap.get(i).getCredit(); //获取题目对应分数计算累加
            }
        }
            Date date = new Date();//获取当前时间
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String time = format.format(date);
            GradeDao gdao = new GradeDao();
            gdao.submitGrade(stId, selectedCourseId, marks, time);//插入数据到成绩表

        //根据计算结果设置result和color
        result = marks >= 60 ? "通过" : "挂科";
        color = marks >= 60 ? "green" : "red";

        return "result"; //返回值让页面跳转到result页面
    }
    
    public String exportAllCpy() throws Exception{
        Workbook wb=new HSSFWorkbook();
        String headers[]={"学生id","类别id","成绩","提交时间"};
        Session session=HibernateUtil.getSession();
        Query query=session.createQuery("select gradeId.studentId,gradeId.courseId,studentGrade,finishDate from Grade where gradeId.studentId=:studentId");
        query.setParameter("studentId", stId);
        List<Object[]> list=query.list();
        HibernateUtil.close(session); 
        ExcelUtil.fillExcel(list, wb, headers);
        
        ExcelUtil.export(wb,"成绩单");
        return null;
    }

    
    
    
    
    public TestApplication getApplications() {
        return applications;
    }

    public void setApplications(TestApplication applications) {
        this.applications = applications;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public HashMap getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(HashMap courseMap) {
        this.courseMap = courseMap;
    }

    public String getSelectedCourseId() {
        return selectedCourseId;
    }

    public void setSelectedCourseId(String selectedCourseId) {
        this.selectedCourseId = selectedCourseId;
    }

    public HashMap<Integer, Question> getQuestionMap() {
        return questionMap;
    }

    public void setQuestionMap(HashMap<Integer, Question> questionMap) {
        this.questionMap = questionMap;
    }

    public int getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(int currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public String getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(String currentChoice) {
        this.currentChoice = currentChoice;
    }

    public HashMap<Integer, String> getChoiceMap() {
        return choiceMap;
    }

    public void setChoiceMap(HashMap<Integer, String> choiceMap) {
        this.choiceMap = choiceMap;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<StudentCourse> getScourselist() {
        return scourselist;
    }

    public void setScourselist(List<StudentCourse> scourselist) {
        this.scourselist = scourselist;
    }
    

    public List<Course> getCourselist() {
        return courselist;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setCourselist(List<Course> courselist) {
        this.courselist = courselist;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Question> getQuestionlist() {
        return questionlist;
    }

    public void setQuestionlist(List<Question> questionlist) {
        this.questionlist = questionlist;
    }

    public List<Grade> getGradelist() {
        return gradelist;
    }

    public void setGradelist(List<Grade> gradelist) {
        this.gradelist = gradelist;
    }

    public List<TestApplication> getApplicationlist() {
        return applicationlist;
    }

    public void setApplicationlist(List<TestApplication> applicationlist) {
        this.applicationlist = applicationlist;
    }

    public HashMap getDateMap() {
        return dateMap;
    }

    public void setDateMap(HashMap dateMap) {
        this.dateMap = dateMap;
    }

    public String getGradeTime() {
        return gradeTime;
    }

    public void setGradeTime(String gradeTime) {
        this.gradeTime = gradeTime;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getGradesno() {
        return gradesno;
    }

    public void setGradesno(int gradesno) {
        this.gradesno = gradesno;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursemodule() {
        return coursemodule;
    }

    public void setCoursemodule(String coursemodule) {
        this.coursemodule = coursemodule;
    }

    public String getNoneortable() {
        return noneortable;
    }

    public void setNoneortable(String noneortable) {
        this.noneortable = noneortable;
    }

}
