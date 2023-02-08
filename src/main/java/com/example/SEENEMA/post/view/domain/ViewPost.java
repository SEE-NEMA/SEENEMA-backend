package com.example.SEENEMA.post.view.domain;

import com.example.SEENEMA.theater.domain.Theater;
import com.example.SEENEMA.user.domain.User;
import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Table(name = "POST_VIEW")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity
public class ViewPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long view_no; // 게시글 no

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user; // 작성자 id

    @ManyToOne
    @JoinColumn(name="theater_id")
    private Theater theater; // 공연장

    @Column(nullable = false)
    private String play; // 공연

    @Column(nullable = false)
    private String seat; // 좌석

    @Column(nullable=false)
    private String title;  // 제목

    @Column(nullable = false)
    private String content; // 내용

    @CreatedDate // 생성일 자동화
    @Column(updatable = false)
    private LocalDateTime createdAt; // 작성 일시

    @LastModifiedDate // 수정일 자동화
    @Column
    private LocalDateTime editedAt; // 최종 수정 일시

    @Builder
    public ViewPost(User user, Theater theater, String play, String seat, String title, String content, LocalDateTime createdAt) {
        this.user = user;
        this.theater = theater;
        this.play = play;
        this.seat = seat;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public void updateViewPost(String play, String seat, String title, String content, LocalDateTime createdAt, LocalDateTime editedAt) {
        this.play = play;
        this.seat = seat;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.editedAt = editedAt;
    }

}