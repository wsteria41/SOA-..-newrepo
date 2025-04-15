package com.example.examinationservice.repository;

import com.example.examinationservice.entity.Examination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExaminationRepository extends MongoRepository<Examination, String> {
    
    @Query("{ '_id' : ?0 }")
    Optional<Examination> findByExaminationId(String id);
    
    @Query("{ 'user_id' : ?0 }")
    List<Examination> findByUserId(String userId);
    
    @Query("{ 'created_at' : { $gte: ?0, $lte: ?1 } }")
    List<Examination> findByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("{ 'diagnosis' : { $regex: ?0, $options: 'i' } }")
    List<Examination> findByDiagnosisLike(String diagnosis);
    
    Optional<Examination> findById(String id);
    
    long countByUserId(String userId);
}