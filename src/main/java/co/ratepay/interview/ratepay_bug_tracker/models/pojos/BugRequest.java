package co.ratepay.interview.ratepay_bug_tracker.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class BugRequest implements Serializable {

    @JsonProperty("bugTypeName")
    private String bugTypeName;

    @JsonProperty("bugStatus")
    private String bugStatus;

    @JsonProperty("bugDescription")
    private String bug_description;

    @JsonProperty("bugReporter")
    private String bug_reporter;

    @JsonProperty("bugAssignee")
    private String bug_assignee;
}
