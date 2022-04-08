package co.ratepay.interview.ratepay_bug_tracker.services;

import co.ratepay.interview.ratepay_bug_tracker.models.datalayer.entities.Bug;
import co.ratepay.interview.ratepay_bug_tracker.models.pojos.BugRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BugTrackerService {
    ResponseEntity<Bug> createABugRequestOnDB(BugRequest bugRequest);

    ResponseEntity<List<Bug>> getAllBugs();

    ResponseEntity<Bug> getBugDetailsById(Long id);

    ResponseEntity<Bug> updateBugDetails(BugRequest bugRequest);

    ResponseEntity<HttpStatus> deleteBugById(Long id);
}
