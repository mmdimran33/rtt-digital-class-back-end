package com.rtt.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

   @Query(value="select subject_Name,subject_Id from Subject_master" , nativeQuery = true)
   List<Object[]> getSubjectNameList();



}
