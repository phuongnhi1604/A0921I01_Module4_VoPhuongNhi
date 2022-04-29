package codegym.entity;

public class Declaration {
    private String id;
    private String name;
    private String birthday_year;
    private String gender;
    private String nationality;
    private String cmnd;
    private String vehicle;
    private String number_vehicle;
    private String number_chair;
    private String city_visited;

    public Declaration() {
    }

    public Declaration(String id,String name, String birthday_year, String gender,String nationality, String cmnd, String vehicle, String number_vehicle, String number_chair, String city_visited) {
        this.id=id;
        this.name = name;
        this.birthday_year = birthday_year;
        this.gender = gender;
        this.nationality=nationality;
        this.cmnd = cmnd;
        this.vehicle = vehicle;
        this.number_vehicle = number_vehicle;
        this.number_chair = number_chair;

        this.city_visited = city_visited;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday_year() {
        return birthday_year;
    }

    public void setBirthday_year(String birthday_year) {
        this.birthday_year = birthday_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumber_vehicle() {
        return number_vehicle;
    }

    public void setNumber_vehicle(String number_vehicle) {
        this.number_vehicle = number_vehicle;
    }

    public String getNumber_chair() {
        return number_chair;
    }

    public void setNumber_chair(String number_chair) {
        this.number_chair = number_chair;
    }

    public String getCity_visited() {
        return city_visited;
    }

    public void setCity_visited(String city_visited) {
        this.city_visited = city_visited;
    }
}
