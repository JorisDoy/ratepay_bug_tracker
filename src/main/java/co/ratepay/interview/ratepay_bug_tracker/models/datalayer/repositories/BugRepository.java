package co.ratepay.interview.ratepay_bug_tracker.models.datalayer.repositories;

import co.ratepay.interview.ratepay_bug_tracker.models.datalayer.entities.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Bug repository.
 */
@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {
}
