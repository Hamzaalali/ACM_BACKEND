package com.example.acm_backend.staff.entities;
import com.example.acm_backend.podcast.entities.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffCategoryRepo extends JpaRepository<StaffCategory,Long> {
    public StaffCategory findById(long id);
    public List<StaffCategory> findByParentCategory(StaffCategory parentCategory);
}
