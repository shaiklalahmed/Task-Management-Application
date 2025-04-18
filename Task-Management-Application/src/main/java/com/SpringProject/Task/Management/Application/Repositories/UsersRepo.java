package com.SpringProject.Task.Management.Application.Repositories;

import com.SpringProject.Task.Management.Application.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {
}
