package com.example.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class idpassword
{
    @Id
    @SequenceGenerator(
            name = "Id_sequence",
            sequenceName = "Id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_sequence"
    )
    private Long passwordid;
    String Password;
}
