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

@RestController
@RequestMapping("/v1/bug-tracker")
public class BugTrackerController {
    private final BugTrackerService bugTrackerService;

    @Autowired
    public BugTrackerController(BugTrackerService bugTrackerService) {
        this.bugTrackerService = bugTrackerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bug> saveBug(@Valid @RequestBody BugRequest bugRequest) {
        return this.bugTrackerService.createABugRequestOnDB(bugRequest);
    }

    @GetMapping("/bugs")
    public ResponseEntity<List<Bug>> getAllBugs() {
        return this.bugTrackerService.getAllBugs();
    }

    @GetMapping("/bugs/{id}")
    public ResponseEntity<Bug> getBugDetailsById(@PathVariable Long id) {
        return this.bugTrackerService.getBugDetailsById(id);
    }

    @PutMapping("/bugs")
    public ResponseEntity<Bug> updateBugDetails(@Valid @RequestBody BugRequest bugRequest) {
        return this.bugTrackerService.updateBugDetails(bugRequest);
    }

    @DeleteMapping("/bugs/{id}")
    public ResponseEntity<HttpStatus> deleteBugById(@PathVariable Long id) {
        return this.bugTrackerService.deleteBugById(id);
    }
}
