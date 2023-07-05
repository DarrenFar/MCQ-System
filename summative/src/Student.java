public class Student {
    private String userName;
    static int score;
    static int wrongAns;
    static double numberOfQuestions;
    //use public setters and getters to use private variable
    public void setName(String name){
        userName = name;
    }
    public String getName(){
        return userName;
    }
}
