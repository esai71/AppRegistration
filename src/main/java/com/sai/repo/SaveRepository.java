package com.sai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.response.RegResponse;
@Repository
public interface SaveRepository extends JpaRepository<RegResponse,String> {

}
