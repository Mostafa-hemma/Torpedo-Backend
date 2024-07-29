package com.backend.demo.dao;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.BlackListedToken;

@Repository
public interface BlackListedTokenDao extends JpaRepository<BlackListedToken, String> {

	Optional<BlackListedToken> findByToken(String token);
	@Transactional
    void deleteByExpirationBefore(LocalDateTime now);

}
