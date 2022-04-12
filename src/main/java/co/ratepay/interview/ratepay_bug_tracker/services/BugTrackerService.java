package co.ratepay.interview.ratepay_bug_tracker.services;

import co.ratepay.interview.ratepay_bug_tracker.models.datalayer.entities.Bug;
import co.ratepay.interview.ratepay_bug_tracker.models.pojos.BugRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * The interface Bug tracker service.
 */
public interface BugTrackerService {
    /**
     * Create a bug request on db response entity.
     *
     * @param bugRequest the bug request
     * @return the response entity
     */
    ResponseEntity<Bug> createABugRequestOnDB(BugRequest bugRequest);

    /**
     * Gets all bugs.
     *
     * @return the all bugs
     */
    ResponseEntity<List<Bug>> getAllBugs();

    /**
     * Gets bug details by id.
     *
     * @param id the id
     * @return the bug details by id
     */
    ResponseEntity<Bug> getBugDetailsById(Long id);

    /**
     * Update bug details response entity.
     *
     * @param bugRequest the bug request
     * @return the response entity
     */
    ResponseEntity<Bug> updateBugDetails(BugRequest bugRequest);

    /**
     * Delete bug by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    ResponseEntity<HttpStatus> deleteBugById(Long id);
}
