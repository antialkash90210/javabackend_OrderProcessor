//DAO описывает его как прослойку между БД и системой.
package ru.taxi.orderprocessor_final.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.taxi.orderprocessor_final.entity.CarEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarOperationsRepository extends JpaRepository<CarEntity, UUID> { //Репозиторий операций с автомобилями расширяет репозиторий Jpa

    //найти по номеру
    Optional<CarEntity> findByNumber(String number);
}