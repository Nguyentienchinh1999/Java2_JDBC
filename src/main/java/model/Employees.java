package model;

public class Employees {
    private int id;
    private String full_name;
    private String city;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String phone;
    private int gender;
    private int salrary;

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", salrary=" + salrary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getSalrary() {
        return salrary;
    }

    public void setSalrary(int salrary) {
        this.salrary = salrary;
    }

    public Employees() {
    }

    public Employees(int id, String full_name, String city, String email, String phone, int gender, int salrary) {
        this.id = id;
        this.full_name = full_name;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salrary = salrary;
    }
}
