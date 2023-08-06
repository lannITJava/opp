package impl;

import ra.IStudent;

import java.util.Scanner;

public  class Student implements IStudent {
    private String studentId;
    private String studentName;
    private int age;
    private float htmlScore;
    private float  cssScore;
    private float javascriptScore;
    private float avgMark;
    private boolean sex;
    private String rank;
    private String action ;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, float htmlScore, float cssScore, float javascriptScore, float avgMark, boolean sex, String rank, String action) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
        this.avgMark = avgMark;
        this.sex = sex;
        this.rank = rank;
        this.action = action;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJavascriptScore() {
        return javascriptScore;
    }

    public void setJavascriptScore(float javascriptScore) {
        this.javascriptScore = javascriptScore;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    @Override
    public void inputData(Scanner scanner, Student[] arrStudent, int index) {
        System.out.println("Nhập vào mã sinh viên");
        boolean checkStudentId = true;
        do {
            this.studentId = scanner.nextLine();

                boolean isExit = false;
                for (int i = 0; i < index; i++) {
                    if (arrStudent[i].studentId.equals(this.studentId)){
                        isExit= true;
                        break;
                    }
                }
                if (!isExit){
                    if (this.studentId.length()==4){
                        if (this.studentId.charAt(0)=='S'&& this.studentId.charAt(1)=='V'){
                            break;
                        }else {
                            System.err.println("Mã sinh viên phải bắt đầu là SV, vui lòng nhập lại");
                        }
                    }else {
                        System.err.println("Mã sinh viên phải gồm 4 ký tự, vui lòng nhập lại");
                    }
                }else {
                    System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại");
                }

        }while (checkStudentId);
        System.out.println("Nhập vào tên sinh viên");
        boolean checkStudentName = true;
        do{
            this.studentName= scanner.nextLine();
            if (this.studentName.length()<6||this.studentName.length()>50){
                System.err.println("Tên sinh viên phải gồm 6-50 ký tự, vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkStudentName);
        System.out.println("Nhập vào tuổi sinh viên");
        boolean checkAge = true;
        do {
            this.age= Integer.parseInt(scanner.nextLine());
            if (this.age<18){
                System.err.println("Sinh viên phải lớn hơn hoặc bằng 18, vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkAge);
        System.out.println("Nhập vào điểm htmlScore");
        boolean checkHtmlScore= true;
        do{
            this.htmlScore= Float.parseFloat(scanner.nextLine());
            if (this.htmlScore<0||this.htmlScore>10){
                System.err.println("Điểm phải có giá trị trong khoảng 0-10, vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkHtmlScore);
        System.out.println("Nhập vào điểm cssScore");
        boolean checkCssScore= true;
        do{
            this.cssScore= Float.parseFloat(scanner.nextLine());
            if (this.cssScore<0||this.cssScore>10){
                System.err.println("Điểm phải có giá trị trong khoảng 0-10, vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkCssScore);
        System.out.println("Nhập vào điểm javascriptScore");
        boolean checkJavascriptScore= true;
        do{
            this.javascriptScore= Float.parseFloat(scanner.nextLine());
            if (this.javascriptScore<0||this.javascriptScore>10){
                System.err.println("Điểm phải có giá trị trong khoảng 0-10, vui lòng nhập lại");
            }else {
                break;
            }
        }while (checkJavascriptScore);
        System.out.println("Nhập vào giới tính sinh viên: ");
        this.sex = Boolean.parseBoolean(scanner.nextLine());

    }

    @Override
    public void displayData() {
        String sexDisplay = this.sex ? "Nam" : "Nữ";
        System.out.printf("Mã sinh viên: %s - Tên sinh viên: %s - Tuổi: %d - Giới tính: %s\n", this.studentId, this.studentName, this.age, sexDisplay);
        System.out.printf("HTML: %.1f - CSS: %.1f - Javascript: %.1f - Avg Mark: %.1f - Xếp loại: %s - Trạng thái: %s\n", this.htmlScore, this.cssScore, this.javascriptScore, this.avgMark, this.rank, this.action);
    }

    @Override
    public void calAvgMark() {
        this.avgMark= (this.htmlScore+this.cssScore+this.javascriptScore)/3;
    }
    public void calRank(){
        if (this.avgMark<5){
            this.rank= "Yếu";
        } else if (this.avgMark>=5&& this.avgMark<7) {
            this.rank= "Trung bình";
        } else if (this.avgMark>=7&& this.avgMark<8) {
            this.rank= "Khá";
        } else if (this.avgMark>=8&& this.avgMark<9) {
            this.rank= "Giỏi";
        }else {
            this.rank= "Xuất sắc";
        }
    }
    public void calAction(){
        if (this.avgMark>= MARK_PASS){
            this.action="PASS";
        }else {
            this.action="FAIL";
        }
    }
}
