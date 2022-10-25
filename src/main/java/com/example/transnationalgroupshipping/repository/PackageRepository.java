package com.example.transnationalgroupshipping.repository;

import com.example.transnationalgroupshipping.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
}
