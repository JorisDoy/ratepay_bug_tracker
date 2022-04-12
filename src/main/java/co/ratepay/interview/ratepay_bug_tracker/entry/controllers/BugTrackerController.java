package co.ratepay.interview.ratepay_bug_tracker.entry.controllers;

import co.ratepay.interview.ratepay_bug_tracker.models.datalayer.entities.Bug;
import co.ratepay.interview.ratepay_bug_tracker.models.pojos.BugRequest;
import co.ratepay.interview.ratepay_bug_tracker.services.BugTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Bug tracker controller.
 */
@RestController
@RequestMapping("/v1/bug-tracker")
public class BugTrackerController {
    private final BugTrackerService bugTrackerService;

    /**
     * Instantiates a new Bug tracker controller.
     *
     * @param bugTrackerService the bug tracker service
     */
    @Autowired
    public BugTrackerController(BugTrackerService bugTrackerService) {
        this.bugTrackerService = bugTrackerService;
    }

    /**
     * Save bug response entity.
     *
     * @param bugRequest the bug request
     * @return the response entity
     */
    @PostMapping("/create")
    public ResponseEntity<Bug> saveBug(@Valid @RequestBody BugRequest bugRequest) {
        return this.bugTrackerService.createABugRequestOnDB(bugRequest);
    }

    /**
     * Gets all bugs.
     *
     * @return the all bugs
     */
    @GetMapping("/bugs")
    public ResponseEntity<List<Bug>> getAllBugs() {
        return this.bugTrackerService.getAllBugs();
    }

    /**
     * Gets bug details by id.
     *
     * @param id the id
     * @return the bug details by id
     */
    @GetMapping("/bugs/{id}")
    public ResponseEntity<Bug> getBugDetailsById(@PathVariable Long id) {
        return this.bugTrackerService.getBugDetailsById(id);
    }

    /**
     * Update bug details response entity.
     *
     * @param bugRequest the bug request
     * @return the response entity
     */
    @PutMapping("/bugs")
    public ResponseEntity<Bug> updateBugDetails(@Valid @RequestBody BugRequest bugRequest) {
        return this.bugTrackerService.updateBugDetails(bugRequest);
    }

    /**
     * Delete bug by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/bugs/{id}")
    public ResponseEntity<HttpStatus> deleteBugById(@PathVariable Long id) {
        return this.bugTrackerService.deleteBugById(id);
    }
}
