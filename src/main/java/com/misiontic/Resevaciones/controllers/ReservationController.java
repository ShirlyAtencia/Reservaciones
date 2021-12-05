package com.misiontic.Resevaciones.controllers;
import com.misiontic.Resevaciones.excepciones.ReservaNotFoundException;
import com.misiontic.Resevaciones.models.Reserva;
import com.misiontic.Resevaciones.repositories.ReservaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    private final ReservaRepository reservaRepository;

    public ReservationController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    @GetMapping("/reserva/{username}")
    Reserva getReserva(@PathVariable String username){
        return reservaRepository.findById(username)
                .orElseThrow(()-> new ReservaNotFoundException("No se encontró una reservación asociada al usuario "+
                        username + " solicitado")
                );
    }

    @GetMapping("/")
    String messageRoot(){
        return "Bienvenido a Reservaciones";
    }

    @GetMapping("/reservaciones")
    List<Reserva> getReserva(@RequestBody Reserva reserva){
        return reservaRepository.findAll();

    }

    @PostMapping("/reserva")
    Reserva newReserva(@RequestBody Reserva reserva){

        return reservaRepository.save( reserva );
    }


    @PutMapping("/reserva/update")
    Reserva updateReserva(@RequestBody Reserva reserva) {
        Reserva reserva_update = reservaRepository.findById(reserva.getUsername()).orElse(null);
        if (reserva_update == null)
            throw new ReservaNotFoundException("Usuario no tiene reservación");
        reserva_update.setReserHabitation(reserva.getReserHabitation());
        reserva_update.setFetchIngress(reserva.getFetchIngress());
        reserva_update.setFetchSaida(reserva.getFetchSaida());
        return reservaRepository.save(reserva);

        }


    @DeleteMapping("/reserva/delete/{username}")
    String deleteReserva(@PathVariable String username)
            throws ReservaNotFoundException {
        Reserva reserva = reservaRepository.findById(username)
                .orElseThrow(() -> new ReservaNotFoundException("No se encontró una reservación asociada al usuario "
                        +username+" solicitado"));

        reservaRepository.delete(reserva);
        return "Reserva Eliminada Exitosamente";
    }
}
