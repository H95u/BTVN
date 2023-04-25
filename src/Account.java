package BTVN.src;

public class Account {
    private int id;
    private static int idTemp = 1;
    private String userName;
    private String passWord;
    private String fullName;
    private String phoneNumber;
    private String address;

    public Account() {
        this.id = idTemp++;
    }

    public Account(String userName, String passWord, String fullName, String phoneNumber, String address) {
        this.id = idTemp++;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdTemp() {
        return idTemp;
    }

    public static void setIdTemp(int idTemp) {
        Account.idTemp = idTemp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + "," + userName + ","
                + passWord + "," + fullName + "," + phoneNumber + "," + address;
    }
}
