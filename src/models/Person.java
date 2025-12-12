package models;

abstract class Person {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;

    public Person(){
        this.id= id;
        this.name=name;
        this.age= age;
        this.gender=gender;
        this.contactNumber = contactNumber;
    }


    abstract void displayInfo();

    public void getDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Number: " + contactNumber);


    }

}
