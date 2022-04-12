package co.ratepay.interview.ratepay_bug_tracker.models.datalayer.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Bug.
 */
@Entity
@Table(name = "tbl_bug")
@Setter
@Getter
@ToString
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bug_id;

    @Column(name = "bug_type_name")
    private String bug_type_name;

    @Column(name = "bug_status")
    private String bug_status;

    @Column(name = "bug_description")
    private String bug_description;

    @Column(name = "bug_reporter")
    private String bug_reporter;

    @Column(name = "bug_assignee")
    private String bug_assignee;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
