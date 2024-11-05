import java.util.Scanner;

public class StudentInformationMain {

    public static void main(String[] args) {

        StudentInformationSystem studentInformation = new StudentInformationSystem();
        Scanner scan = new Scanner(System.in);


        while(true) {
            System.out.println("**** 학생 관리 프로그램 ****");
            System.out.println("1. 학생 등록");
            System.out.println("2. 전체 출력");
            System.out.println("3. 학생 조회");
            System.out.println("4. 정보 수정");
            System.out.println("5. 프로그램 종료");

            System.out.print("관리 번호를 입력하세요. : ");
            int a = studentInformation.checkNum(scan);

            if(a == -1) {
                System.out.println("[다시 입력해주세요.]");
                continue;
            }

            if(a == 1) {
                int flag = 0; //동일한 학번을 입력했을 때 처리를 위한 변수
                System.out.println("[학생을 등록합니다.]");
                System.out.print("학번 입력 : ");

                int studentNum = studentInformation.checkStudentNum(scan);

                if(studentNum == -1) {
                    System.out.println("[학번을 확인해주세요. ]");
                    continue;
                }

                for(Student std : studentInformation.getStudent()) {
                    if(std != null) {
                        if(std.getStudentNum() == studentNum) {
                            System.out.println("[동일한 학번입니다. 다시 입력하세요.]");

                            flag=-1;
                        }
                    }
                }

                if(flag == -1) {
                    continue;
                }


                System.out.print("이  름 입력 : ");
                String studentName = studentInformation.checkName(scan);


                if(studentName == null) {
                    System.out.println("[ 잘못된 이름 입력 ]");
                    continue;
                }

                System.out.print("학  과 입력 : ");
                String major = studentInformation.checkMajor(scan);


                if(major == null) {
                    System.out.println("[ 잘못된 학과 입력 ]");
                    continue;
                }

                System.out.print("전화번호 입력 : ");
                String phoneNum = studentInformation.checkPhoneNum(scan);


                if(phoneNum == null) {
                    System.out.println("[ 잘못된 전화번호 입력 ]");
                    continue;
                }

                System.out.println("====================================");

                studentInformation.addStudent(new Student(studentName , phoneNum , studentNum , major));
            }

            if(a == 2) {
                int nullFlag=studentInformation.checkNull(studentInformation.getStudent());
                if(nullFlag == -1) {
                    System.out.println("[등록된 학생이 없습니다.]");
                    continue;
                }
                else {
                    System.out.println("======전체 학생 출력======");
                    studentInformation.searchAll();
                }
            }

            if(a == 3) {
                int nullFlag = studentInformation.checkNull(studentInformation.getStudent());

                if(nullFlag == -1) {
                    System.out.println("[등록된 학생이 없습니다.]");
                    continue;
                }
                else{
                    System.out.println("[학생을 조회 합니다.]");
                    System.out.println();
                    System.out.print("학번을 입력하십시오. : ");
                    int studentNum = studentInformation.checkStudentNum(scan);


                    if(studentNum == -1 ) {
                        System.out.println("[학번을 확인해주세요.]");
                        continue;
                    }
                    studentInformation.searchStudent(studentNum);
                }
            }

            if(a == 4) {

                int count =0;
                int nullFlag = studentInformation.checkNull(studentInformation.getStudent());


                if(nullFlag == -1) {
                    System.out.println("[등록된 학생이 없습니다.]");
                    continue;
                }
                else {
                    System.out.println("[학생 정보를 수정합니다.]");
                    System.out.print("학번을 입력하십시오. : ");
                    int studentNum = studentInformation.checkStudentNum(scan);


                    if(studentNum == -1) {
                        System.out.println("[학번을 확인해주세요.]");
                        continue;
                    }

                    for(Student std : studentInformation.getStudent()) {
                        if(std != null) {
                            if(std.getStudentNum() == studentNum) {
                                studentInformation.setInformation(studentNum , count , scan);
                            }
                            count++;
                        }
                    }

                }

            }

            if(a == 5) {
                System.out.print("프로그램을 종료하시겠습니까? (y/n) : ");

                String sys = scan.nextLine();

                if("y".equals(sys.trim()) || "Y".equals(sys.trim())) {  //trim()은 앞 뒤 공백을 지워줌.
                    System.out.println("[프로그램을 종료합니다.]");
                    System.exit(0);
                }

                else {
                    continue;
                }
            }
        }


    }
}
