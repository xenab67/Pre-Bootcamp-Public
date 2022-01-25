public class ProjectTest {
    public static void main(String[] args){
        Project project1= new Project();
        Project project2= new Project();
        project1.setName("Project 1");
        project1.setDescription("This is the description!");
        String project1Name=project1.getName();
        String project1Description=project1.getDescription();
        project2.setName("Project 2");
        project2.setDescription("And this is my description!");
        String project2Name=project2.getName();
        String project2Description=project2.getDescription();
        String testElevator = project1.elevatorPitch(project1Name,project1Description);
        String testElevator2 = project2.elevatorPitch(project2Name,project2Description);
        System.out.println(testElevator);
        System.out.println(testElevator2);
    } 
}
