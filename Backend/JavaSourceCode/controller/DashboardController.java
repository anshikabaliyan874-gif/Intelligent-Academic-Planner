package Backend.JavaSourceCode.controller;

import Backend.JavaSourceCode.model.Task;
import Backend.JavaSourceCode.model.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DashboardController {

    private final List<Task> tasks = new ArrayList<>();
    private final List<Activity> activities = new ArrayList<>();

    public DashboardController() {
        // mock tasks
        tasks.add(new Task(1L, "DBMS Revision", "High", false));
        tasks.add(new Task(2L, "Java Practice", "Medium", false));
        tasks.add(new Task(3L, "OS Notes", "Low", false));
        tasks.add(new Task(4L, "Assignment Submission", "High", true));

        // mock activities
        activities.add(new Activity("Plan Created", "Semester Study Plan initiated with 12 tasks", "5 days ago"));
        activities.add(new Activity("Task Updated", "DBMS revision scheduled increased to 4 hours daily", "2 days ago"));
        activities.add(new Activity("Progress Checked", "Overall progress at 65% — 8 of 12 tasks completed", "1 hour ago"));
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("activePlanName", "Semester Study Plan");
        model.addAttribute("currentPhaseName", "Mid Semester");
        model.addAttribute("systemStatusText", "On Track");

        model.addAttribute("activeTasks", tasks);

        model.addAttribute("workload", "Medium");
        model.addAttribute("deadlineProximity", "High");
        model.addAttribute("overloadRisk", "Low");

        model.addAttribute("systemRecommendation", "Focus on DBMS today due to upcoming exams. Delay low-priority tasks.");

        model.addAttribute("recentActivities", activities);

        return "dashboard";
    }

    @PostMapping("/tasks/toggle-complete/{id}")
    public String toggleComplete(@PathVariable("id") Long id) {
        synchronized (tasks) {
            Optional<Task> t = tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
            if (t.isPresent()) {
                Task found = t.get();
                found.setCompleted(!found.isCompleted());
            }
        }
        return "redirect:/dashboard";
    }
}
