package com.example.dating.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createdAt;

    @Column(name = "is_agree")
    private int isAgree;

    @ManyToOne
    @JoinColumn(name = "from_member_id", foreignKey = @ForeignKey(name = "FK_MEMBER_TB_MATCH"))
    private Member fromMember;

    @ManyToOne
    @JoinColumn(name = "to_member_id", foreignKey = @ForeignKey(name = "FK_MEMBER_TB_MATCH2"))
    private Member toMember;
}
