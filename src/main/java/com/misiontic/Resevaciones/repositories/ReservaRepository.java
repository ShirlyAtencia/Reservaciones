package com.misiontic.Resevaciones.repositories;
import com.misiontic.Resevaciones.models.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository <Reserva, String>{
}
