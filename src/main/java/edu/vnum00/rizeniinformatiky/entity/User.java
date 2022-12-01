package edu.vnum00.rizeniinformatiky.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class User {
    private long id;
    private String firstName;
    private String surname;
    private int age;
}
