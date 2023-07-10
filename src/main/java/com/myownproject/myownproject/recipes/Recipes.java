package com.myownproject.myownproject.recipes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RECIPES")
public class Recipes {

    @Id
    @SequenceGenerator(
            name = "recipes_sequence",
            sequenceName = "recipes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipes_sequence"
    )
    private Long id;
    private String title;
    private String writer;
    private LocalDate date;
    private String content;

    private String ingredients;

    private Long minute;

    public Recipes() {
    }

    public Recipes(Long id, String title, String writer, LocalDate date, String content) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
    }

    public Recipes(String title, String writer, LocalDate date, String content, String ingredients, Long minute) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
        this.ingredients = ingredients;
        this.minute = minute;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Long getMinute() {
        return minute;
    }

    public void setMinute(Long minute) {
        this.minute = minute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }

}
