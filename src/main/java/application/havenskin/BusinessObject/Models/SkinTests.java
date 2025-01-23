package application.havenskin.BusinessObject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "SkinTests")
@Data
public class SkinTests {
    @Id
    @Column(name = "skin_test_id", length = 50)
    private String skinTestId;

    @Column(name = "test_name", length = 50)
    private String testName;

    @Column(name = "max_mark")
    private Double maxMark;

    @NotNull
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @Column(name = "status")
    private byte status;

    @OneToMany(mappedBy = "skinTest")
    private List<Questions> questions;

    @OneToMany(mappedBy = "skinTest")
    private List<Answers> answers;

    @OneToMany(mappedBy = "skinTest")
    private List<ResultTests> resultTests;

}
