package com.UserData.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="vuser")
@Getter @Setter @NoArgsConstructor @ToString        //lombok dependents
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private @NonNull String email;
    private @NonNull String pass;
    private String address;
    private String city;
    private String state;
    private String[] pets;
    private boolean aBoolean;
    private String option;

}
