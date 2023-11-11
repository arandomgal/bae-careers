package com.bae.careers.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String code;

    @Column
    private String title;

    @Column (length = 2000)
    private String description;

    @Column
    private Integer salary;

    @Column
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @Column
    @Enumerated(EnumType.STRING)
    private Location location;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    public Job(Integer id, String code, String title, String description, Integer salary, Mode mode, Location location, Level level) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.mode = mode;
        this.location = location;
        this.level = level;
    }

    protected Job() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", mode=" + mode +
                ", location=" + location +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(code, job.code) && Objects.equals(title, job.title) && Objects.equals(description, job.description) && Objects.equals(salary, job.salary) && mode == job.mode && location == job.location && level == job.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, title, description, salary, mode, location, level);
    }
}
