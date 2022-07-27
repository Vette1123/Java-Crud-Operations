package com.example.springapitask.users;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String city;
    @Transient
    private Integer age;

    public User( String name, String email, LocalDate birthDate, String city) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.city = city;
    }
//        calculate age
    public Integer getAge() {
        if (this.birthDate == null) {
            return null;
        }
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
