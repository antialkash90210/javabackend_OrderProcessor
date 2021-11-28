
package ru.taxi.orderprocessor_final.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxi.orderprocessor_final.entity.DriverEntity;

import java.util.UUID;

@Repository
public interface DriverOperationsRepository extends JpaRepository<DriverEntity, UUID> { //Репозиторий операций с драйверами
}