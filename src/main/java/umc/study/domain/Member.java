package umc.study.domain;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.Status;
import umc.study.domain.mapping.Member_mission;
import umc.study.domain.mapping.Prefer_food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    private LocalDate inactive_date;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "Member", cascade = CascadeType.ALL)
    private List<Review> ReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "Member", cascade = CascadeType.ALL)
    private List<Prefer_food> Prefer_foodList = new ArrayList<>();

    @OneToMany(mappedBy = "Member", cascade = CascadeType.ALL)
    private List<Member_mission> Member_missionList = new ArrayList<>();

}
