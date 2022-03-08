package com.example.dating.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Idel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "range_start")
    private int rangeStart;

    @Column(name = "range_end")
    private int rangeEnd;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public enum Type {
        Age,
        Tall
    }
}
