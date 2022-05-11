/**
 * @author Youngjae Lee
 * @version 2022-02-13
 *
 * description: Repository class
 */

package dmit2015.youngjaelee.assignment03.repository;

import common.jpa.AbstractJpaRepository;
import dmit2015.youngjaelee.assignment03.entity.OscarReview;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class OscarReviewRepository extends AbstractJpaRepository<OscarReview, Long> {

    public OscarReviewRepository() {
        super(OscarReview.class);
    }

}