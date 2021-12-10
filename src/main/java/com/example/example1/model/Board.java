package com.example.example1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2,max = 30,message = "제목은 2자이상 30자 이하입니다")
    private String title;
    private String content;

    @ManyToOne
    // User에 @Id 설정값이 id이기에 생략가능
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
