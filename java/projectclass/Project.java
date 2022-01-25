public class Project{
    private String name;
    private String description;
    // private static String defaultName ="Default Name";
    // private static String defaultDescription = "Default Description";

    //new Project()
    public Project(){
        // name= defaultName;
        // description=defaultDescription;
    }
    //new Project(String name)
    public Project(String name){
        this.name= name;
    }
    //new Project(String name, String description)
    public Project(String name, String description){
        this.name= name;
        this.description=description;
    }
    //getter method
    public String getName(){
        return name;
    }
    //setter method
    public void setName(String name){
        this.name=name;
    }
    //getter method
    public String getDescription(){
        return description;
    }
    //setter method
    public void setDescription(String description){
        this.description=description;
    }
    public String elevatorPitch(String name, String description){
        return String.format("%s %s",name,description);
    }
}
