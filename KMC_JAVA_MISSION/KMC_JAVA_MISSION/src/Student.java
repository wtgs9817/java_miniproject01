public class Student {

    private String studentName;   //학생이름
    private String phoneNum;  //학생 전화번호
    private int studentNum;       //학번
    private String major;     //학과

    public Student(String studentName, String phoneNum, int studentNum, String major) {
        this.studentName=studentName;
        this.phoneNum=phoneNum;
        this.studentNum=studentNum;
        this.major=major;

    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentNum() {
        return this.studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
