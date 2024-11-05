import java.util.Scanner;

public interface StudentInformation {
    //기능
    void addStudent(Student std);  //학생등록
    void searchAll(); //전체조회
    void searchStudent(int studentNum); //학생조회
    void setInformation(int studentNum , int count , Scanner scan);//정보수정

    //예외처리
    int checkStudentNum(Scanner scan);  //학번 예외처리
    String checkPhoneNum(Scanner scan); //전화번호 예외처리
    String checkName(Scanner scan);     //이름 예외처리
    public int checkNum(Scanner scan);  //관리번호 예외처리
    public int checkNull(Student[] student);


}
