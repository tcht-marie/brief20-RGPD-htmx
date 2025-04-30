package fr.simplon.brief20.repository;

import fr.simplon.brief20.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByEmployeeId(Long employeeId);
    List<Meeting> findByCustomerId(Long customerId);
}
