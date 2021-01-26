package ru.hh.school.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

//TODO: оформите entity
@Entity
@Table(name = "resume")
public class Resume {
    // TODO: сделать так, чтобы id брался из sequence-а
    // таким образом, мы сможем отправлять в бд запросы батчами.
    // нужно учитывать, что описание sequence при создании таблицы также должно соответствовать
    // хиберовской сущности (см. create_resume.sql)
    //
    // Подробнее:
    // https://vladmihalcea.com/how-to-batch-insert-and-update-statements-with-hibernate/
    // https://vladmihalcea.com/from-jpa-to-hibernates-legacy-and-enhanced-identifier-generators/

    @Id
    @GeneratedValue(generator = "gen_resume_id_seq", strategy = SEQUENCE)
    @SequenceGenerator(name = "gen_resume_id_seq", sequenceName = "resume_id_seq")
    private Integer id;

    @Column(name = "description")
    private String description;

    Resume() {
    }

    public Resume(String description) {
        this.description = description;
    }

}
