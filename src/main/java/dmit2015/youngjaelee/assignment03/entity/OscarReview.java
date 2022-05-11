/**
 * @author Youngjae Lee
 * @version 2022-02-13
 *
 * description: Entity class
 */

package dmit2015.youngjaelee.assignment03.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The persistent class for the OscarReviews database table.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OscarReviews")
public class OscarReview implements Serializable {

    @Id                 // This is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    @NotBlank(message = "Category is required")
    @Size(min=1, max=25, message = "size must be between 1 and 25")
    private String category;

    @Column(nullable = false, length = 25)
    @NotBlank(message = "Nominee is required")
    @Size(min=1, max=25, message = "size must be between 1 and 25")
    private String nominee;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "You must type review")
    @Size(min=1, max=100, message = "size must be between 1 and 100")
    private String review;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "Username is required")
    @Size(min=1, max=30, message = "size must be between 1 and 30")
    private String username;

    @Version
    private Integer version;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    @Column(nullable = false)
    private LocalDateTime lastModifiedDateTime;

    public OscarReview(Long id, String category, String nominee, String review, String username, LocalDateTime createdDateTime, LocalDateTime lastModifiedDateTime) {
        this.id = id;
        this.category = category;
        this.nominee = nominee;
        this.review = review;
        this.username = username;
        this.createdDateTime = createdDateTime;
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    @PrePersist
    private void beforePersist() {
        createdDateTime = LocalDateTime.now();
        lastModifiedDateTime = createdDateTime;
    }

    @PreUpdate
    private void beforeUpdate() {
        lastModifiedDateTime = LocalDateTime.now();
    }

}