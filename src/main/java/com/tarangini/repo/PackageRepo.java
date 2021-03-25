package com.tarangini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarangini.entity.PackageEntity;

@Repository
public interface PackageRepo extends JpaRepository<PackageEntity, String>{

}
