package com.SpringProject.Task.Management.Application.Repositories;

import com.SpringProject.Task.Management.Application.Entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepo extends JpaRepository<Tasks,Long> {

    public List<Tasks> findAllByUsersId(long users_id);
}
