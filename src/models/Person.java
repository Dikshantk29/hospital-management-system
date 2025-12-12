package models;

abstract class Person {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;

    public Person(String id, String name, int age, String gender, String contactNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }


    abstract void displayInfo();

    public void getDetails() {
        System.out.println("=========== Person Details ===========");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Number: " + contactNumber);


    }


    //getter
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }


    //setters
    public void setAge(int age){
        this.age = age;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

}
