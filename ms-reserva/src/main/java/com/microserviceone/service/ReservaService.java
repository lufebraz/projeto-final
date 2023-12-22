package com.microserviceone.service;

import com.microserviceone.model.*;
import com.microserviceone.repository.ReservaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    private RestTemplate restTemplate;
    private void init() {
        if (restTemplate == null) {
            this.restTemplate = new RestTemplate();
        }
    }
    @Value("${base.url.ms-restaurante}")
    private String BASE_URL;


    public List<Reserva> findReservas() {
        return reservaRepository.findAll();
    }

    public ResponseEntity<Object> createReserva(ReservaRequest request) {

        RestauranteRequest restauranteRequest = new RestauranteRequest();
        restauranteRequest.setNomeRestaurante(request.getNomeRestaurante());
        init();
        String url = BASE_URL + "/find-by-name";
        System.out.println("URL: " + url);

        try {
            ResponseEntity<Restaurante> forEntity = restTemplate.postForEntity(url, restauranteRequest, Restaurante.class);
            if (forEntity.getStatusCode().value() == 200) {
                Reserva reserva = new Reserva();

                reserva.setNomeCliente(request.getNomeCliente());
                reserva.setContatoCliente(request.getContatoCliente());
                reserva.setDataHora(request.getDataHora());
                reserva.setNumeroDePessoas(request.getNumeroPessoas());
                reserva.setRestauranteId(forEntity.getBody().getId());

                Reserva savedReserva = reservaRepository.save(reserva);

                ReservaResponse reservaResponse = new ReservaResponse();
                BeanUtils.copyProperties(savedReserva, reservaResponse);
                reservaResponse.setNomeRestaurante(forEntity.getBody().getNomeRestaurante());
                reservaResponse.setDataHora(reserva.getDataHora().toString());
                reservaResponse.setRestauranteId(savedReserva.getRestauranteId());
                return ResponseEntity.ok(reservaResponse);

            }
            return ResponseEntity.badRequest().body("Restaurante não localizado.");

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Não foi possivel gerar reserva.");
        }
    }


    public ResponseEntity<Object> deletarReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            reservaRepository.deleteById(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<String> fallbackMethod() {
        return ResponseEntity.internalServerError().body("Servico fora do ar");
    }
}
