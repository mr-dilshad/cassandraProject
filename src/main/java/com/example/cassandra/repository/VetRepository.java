package com.example.cassandra.repository;

import com.example.cassandra.entity.Vet;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface VetRepository extends CassandraRepository<Vet, UUID> {
}
