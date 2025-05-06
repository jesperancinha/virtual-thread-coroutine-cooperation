package org.jesperancinha.vtcc.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductDao extends JpaRepository<Product, UUID> {
}