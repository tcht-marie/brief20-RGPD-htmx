package fr.simplon.brief20.service;

import fr.simplon.brief20.model.Meeting;
import java.util.List;
import java.util.Optional;

public interface MeetingService {
    Meeting saveMeeting(Meeting meeting);
    Optional<Meeting> findById(Long id);
    List<Meeting> findAll();
    List<Meeting> findByEmployeeId(Long employeeId);
    List<Meeting> findByCustomerId(Long customerId);
    void deleteMeeting(Long id);
}
