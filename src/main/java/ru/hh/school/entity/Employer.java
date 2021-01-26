package ru.hh.school.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

//TODO: оформите entity
@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employer_id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    // не используйте java.util.Date
    // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#basic-datetime-java8
    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "employer", fetch = LAZY)
    @Cascade(SAVE_UPDATE)
    private final List<Vacancy> vacancies = new ArrayList<>();

    @Column(name = "block_time")
    private LocalDateTime blockTime;

    public Employer() {
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(LocalDateTime blockTime) {
        this.blockTime = blockTime;
    }

    // статьи на тему реализации equals() и hashCode():
    //
    // https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
    // https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(companyName, employer.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName);
    }

}
