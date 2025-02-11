package application.havenskin.BusinessObject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class Users {

    @Id
    @Column(name = "user_id", length = 50)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @NotNull
    @Column(name = "first_name", length = 50)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Max(5)
    @Column(name = "rating")
    private byte rating;

    @Column(name = "image", length = 100)
    private String image;

    @NotNull
    @Column(name = "role")
    private byte role;

    @Column(name = "status")
    private byte status;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    @OneToMany(mappedBy = "user")
    private List<ResultTests> resultTests;

    @OneToMany(mappedBy = "user")
    private List<Blogs> blogs;

    @OneToMany(mappedBy = "users")
    private List<Feedbacks> feedbacks;

    @OneToMany(mappedBy = "user")
    private List<SkinCaresPlan> skinCaresPlan;

}
