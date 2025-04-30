package fr.simplon.brief20.service.impl;

import fr.simplon.brief20.model.Meeting;
import fr.simplon.brief20.repository.MeetingRepository;
import fr.simplon.brief20.service.MeetingService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Override
    public Meeting saveMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Optional<Meeting> findById(Long id) {
        return meetingRepository.findById(id);
    }

    @Override
    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    @Override
    public List<Meeting> findByEmployeeId(Long employeeId) {
        return meetingRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<Meeting> findByCustomerId(Long customerId) {
        return meetingRepository.findByCustomerId(customerId);
    }

    @Override
    public void deleteMeeting(Long id) {
        meetingRepository.deleteById(id);
    }
}
