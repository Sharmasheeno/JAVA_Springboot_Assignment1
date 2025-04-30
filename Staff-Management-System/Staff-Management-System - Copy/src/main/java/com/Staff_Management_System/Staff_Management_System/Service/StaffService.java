package com.Staff_Management_System.Staff_Management_System.Service;

import com.Staff_Management_System.Staff_Management_System.Model.Staff;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {

    private final Map<Long, Staff> staffMap = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public Collection<Staff> getAllStaffs() {
        return staffMap.values();
    }

    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    public Staff saveStaff(Staff staff) {
        Long staffId = (staff.getId() != null) ? staff.getId() : idCounter.incrementAndGet();
        staff.setId(staffId);
        staffMap.put(staffId, staff);
        return staff;
    }

    public void updateStaff(Long id, Staff updatedStaff) {
        if (staffMap.containsKey(id)) {
            Staff existing = staffMap.get(id);
            existing.setName(updatedStaff.getName());
            existing.setPosition(updatedStaff.getPosition());
            staffMap.put(id, existing);
        }
    }

    public void deleteStaff(Long id) {
        staffMap.remove(id);
    }
}