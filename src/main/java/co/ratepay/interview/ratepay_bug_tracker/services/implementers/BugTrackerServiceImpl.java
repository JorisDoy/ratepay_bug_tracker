package co.ratepay.interview.ratepay_bug_tracker.services.implementers;

import co.ratepay.interview.ratepay_bug_tracker.models.datalayer.entities.Bug;
import co.ratepay.interview.ratepay_bug_tracker.models.datalayer.repositories.BugRepository;
import co.ratepay.interview.ratepay_bug_tracker.models.pojos.BugRequest;
import co.ratepay.interview.ratepay_bug_tracker.services.BugTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugTrackerServiceImpl implements BugTrackerService {
    private final BugRepository bugRepository;

    @Autowired
    public BugTrackerServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @Override
    public ResponseEntity<Bug> createABugRequestOnDB(BugRequest bugRequest) {
        try {
            Bug bug = new Bug();
            bug.setBug_status(bugRequest.getBugStatus());
            bug.setBug_description(bugRequest.getBug_description());
            bug.setBug_reporter(bugRequest.getBug_reporter());
            bug.setBug_assignee(bugRequest.getBug_assignee());
            return new ResponseEntity<>(bugRepository.saveAndFlush(bug), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Bug>> getAllBugs() {
        try {
            List<Bug> list = bugRepository.findAll();
            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Bug> getBugDetailsById(Long id) {
        Optional<Bug> Bug = bugRepository.findById(id);
        return Bug.map(bug -> new ResponseEntity<>(bug, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Bug> updateBugDetails(BugRequest bugRequest) {
        try {
            Bug newBug = new Bug();
            newBug.setBug_status(bugRequest.getBugStatus());
            newBug.setBug_description(bugRequest.getBug_description());
            newBug.setBug_reporter(bugRequest.getBug_reporter());
            newBug.setBug_assignee(bugRequest.getBug_assignee());
            return new ResponseEntity<>(bugRepository.saveAndFlush(newBug), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteBugById(Long id) {
        try {
            Optional<Bug> Bug = bugRepository.findById(id);
            if (Bug.isPresent()) {
                bugRepository.delete(Bug.get());
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
