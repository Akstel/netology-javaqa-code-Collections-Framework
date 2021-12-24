package ru.netology.repository;

import ru.netology.domain.Issue;
import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private List<Issue> issues = new ArrayList<>();

    public void addAll(List<Issue> issues) {
        this.issues.addAll(issues);
    }

    public List<Issue> findAll() {
        return issues;
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public Issue findById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        issues.removeIf(issue -> issue.getId() == id);
    }

    public void removeAll(List<Issue> issues) {
        this.issues.removeAll(issues);
    }
}