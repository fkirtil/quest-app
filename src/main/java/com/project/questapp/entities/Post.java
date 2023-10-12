package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) //user objesinin dbden hemen çekme, postu çektiğimde ilgili user objesi bana gelmeyecek lazım olmadığını düşünüyoruz
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiğinde sen gel onun tüm postlarını sil
    @JsonIgnore //serializationda sıkıntı çıkarmaması için
    User user;

    Long userId;

    String title;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
