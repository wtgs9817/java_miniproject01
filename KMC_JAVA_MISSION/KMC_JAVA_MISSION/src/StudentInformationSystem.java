import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentInformationSystem implements StudentInformation {
    public StudentInformationSystem() {}

    private Student[] student= new Student[25];  //25명으로 제한
    private int count=0;  //student 배열을 위한 인덱스



    Scanner scan = new Scanner(System.in);

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void addStudent(Student student) {  //1.학생 등록
        if(count == this.student.length) {
            System.out.println("학생 수 초과");
            return;
        }

        this.student[count] = student;   // 학생 배열에 학생 추가
        count++;  //학생 추가 후 배열 인덱스 증가

    }


    @Override
    public void searchAll() {  //2.전체 조회
        int num=0;

        for(Student s : this.student) {
            if(s != null) {  //student 배열이 비어있지 않으면 배열 내 학생의 학생정보 전체 출력
                System.out.println("학 번 : " + s.getStudentNum());
                System.out.println("이 름 : " + s.getStudentName());
                System.out.println("학 과 : " + s.getMajor());
                System.out.println("연락처 : " + s.getPhoneNum());

                System.out.println("====================================");
            }
        }

    }

    @Override
    public void searchStudent(int studentNum) {  //3.학생 조회

        for(Student student : this.getStudent()) {
            if(student != null) {
                if(student.getStudentNum() == studentNum) {  //조회하려고 하는 학번과 일치하는 학번이 있으면
                    System.out.println("학  번 : " + student.getStudentNum());
                    System.out.println("이  름 : " + student.getStudentName());
                    System.out.println("학  과 : " + student.getMajor());
                    System.out.println("연락처  : " + student.getPhoneNum());
                    //일치하는 학생의 학생정보 출력
                }
            }
        }

    }


    public void setInformation(int studentNum , int count , Scanner scan) {  //4. 정보 수정
        System.out.println("학  번 : " + this.student[count].getStudentNum());
        System.out.println("이  름 : " + this.student[count].getStudentName());

        System.out.print("학  과 입력 : " );
        String major = this.checkMajor(scan);

        if(major == null) {
            System.out.println("[학과를 확인해주세요.]");
            return;
        }



        System.out.print("전화번호 입력 : " );
        String phoneNum = this.checkPhoneNum(scan);

        if(phoneNum == null) {
            System.out.println("[전화번호를 확인해주세요.]");
            return;
        }

        this.student[count].setMajor(major);   //입력받은 학번이 일치하는 학생의 학과를 변경
        this.student[count].setPhoneNum(phoneNum); //입력받은 학번이 일치하는 학생의 전화번호를 변경

    }

    //예외처리 메소드 시작

    @Override
    public int checkStudentNum(Scanner scan) {  //학번 예외처리
        /* 학번은 int 타입
           문자열로 입력 시 예외발생 예외처리

         */

        try {
            int studentNum = scan.nextInt();
            scan.nextLine();
            /* nextInt() 는 숫자만 읽고 개행문자(\n)를 버퍼에 남겨두기 때문에
            그 다음에 다른 타입 ex -> (nextLine()) 으로 입력받을 경우, 남아있던
            개행문자를 읽어서 다음 입력이 넘어가게 되는 경우가 있음. 그렇기 때문에 nextLine()을 추가하여
            버퍼를 비워주는 게 좋음.
             */

            String strnum = Integer.toString(studentNum);  //학번을 문자열로 변환해서 길이 확인
            if(strnum.length() !=  8 || (studentNum < 0 )) { //학번(8자리) 입력이 아니거나 음수인 경우
                return -1;
            }

            return studentNum;
        }
        catch(InputMismatchException e) { //int 타입과 다른 타입이 입력된 경우
            scan.nextLine();
            return -1;
        }

    }


    @Override
    public String checkPhoneNum(Scanner scan) {  // 전화번호 예외처리

        //정규 표현식에서 \d 는 숫자이지만 자바에서는 이스케이프 문자 때문에 \\d 써야 숫자로 인식됨

        String phoneNum = scan.nextLine();

        String pattern="^\\d{3}-\\d{4}-\\d{4}$"; //정규 표현식 패턴 설정
        //{3자리}-{4자리}-{4자리}
        // ^ : 문자열로 시작한다는 의미 \d : 숫자
        //Pattern 은 정적메소드를 제공하기 때문에 따로 객체 생성없이 matches 메소드를 사용할 수 있음.
         if(!Pattern.matches(pattern, phoneNum)) { //정규 표현식(pattern)과 일치하지 않으면
             return null;
         }

         return phoneNum;


    }

    public String checkName(Scanner scan) {  // 제대로 된 이름 입력을 받기 위한 메소드

        String studentName = scan.nextLine();
        String pattern = "^[가-힣]{2,5}$";  //정규 표현식 패턴 설정 한글 2자이상 5자 미만


        if(!Pattern.matches(pattern , studentName)) {  //정의한 정규 표현식에 맞지 않을 때
            return null;
        }

        return studentName;
    }

    public String checkMajor(Scanner scan) {
        String studentMajor = scan.nextLine();
        String pattern = "^[가-힣]{3,}$";   // 3, -> 최소 3자 이상이면 ok


        if(!Pattern.matches(pattern , studentMajor)) {
            return null;
        }

        return studentMajor;
    }

    public int checkNum(Scanner scan) {  //관리번호 예외처리 메소드

        try{
            int studentNum = scan.nextInt();
            scan.nextLine();

            if(studentNum < 0 || studentNum > 5) {  //관리번호가 음수이거나 5보다 클 때
                return -1;
            }
            return studentNum;
        }
        catch (InputMismatchException e) {
            scan.nextLine();
            return -1;
        }
    }

    public int checkNull(Student[] student) {
        int nullFlag=-1;

        for(Student s : student) {
            if(s != null) {
                nullFlag=1;
            }
        }

        return nullFlag;
    }

}


