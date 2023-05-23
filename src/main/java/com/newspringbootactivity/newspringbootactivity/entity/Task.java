package com.newspringbootactivity.newspringbootactivity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "task_tbl")
    public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private Long id;
        @Column
        private String title;
        @Column
        private String description;
        @Column
        private boolean completed;


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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

    }
