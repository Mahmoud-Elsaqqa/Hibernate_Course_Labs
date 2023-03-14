package gov.iti.jets.dao2;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "phone", length = 45)
    private String phone;

    @Column(name = "mobile", length = 45)
    private String mobile;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @OneToOne(mappedBy = "user")
    private Buyer buyer;

    @OneToOne(mappedBy = "user")
    private Seller seller;



    

    public User(String email, String address, String phone, String mobile, LocalDate dateOfBirth,
            LocalDate registrationDate, String userName, String password, String fullName) {
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

}