package com.ondrej.microwave.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondrej.microwave.entity.MicrowaveState;

public interface MicrowaveStateRepository extends JpaRepository<MicrowaveState, Integer> {

}
