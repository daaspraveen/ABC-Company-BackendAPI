package com.example.abc_company.repository;

import com.example.abc_company.entity.Heading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadingRepository extends JpaRepository<Heading, Long>{
	Heading findTopByOrderByIdDesc();
}
