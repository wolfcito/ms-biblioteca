package com.ceiba.biblioteca.controller;


import com.ceiba.biblioteca.model.dto.MensajeDto;
import com.ceiba.biblioteca.model.dto.PrestamoDto;
import com.ceiba.biblioteca.model.dto.RespuestaExistosaDto;
import com.ceiba.biblioteca.model.service.IPrestamoService;
import com.ceiba.biblioteca.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

import static com.ceiba.biblioteca.util.TipoUsuarioUtils.*;

@RestController
public class PrestamoController {

    @Autowired
    IPrestamoService prestamoService;

    @PostMapping("/prestamo")
    public ResponseEntity<?> prestamo(@RequestBody PrestamoDto prestamoDto){


        if(ValidateUser(prestamoDto.getTipoUsuario())){

            Optional<PrestamoDto> result = prestamoService.findByIdentificacionUsuario(prestamoDto.getIdentificacionUsuario());

            if(result.isPresent() && ValidateUserInvitado(prestamoDto.getTipoUsuario())){

                return new ResponseEntity<>(
                        new MensajeDto(String.format("El usuario con identificación %s ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",prestamoDto.getIdentificacionUsuario())),
                        HttpStatus.BAD_REQUEST);
            }else{

                try {

                    Optional<PrestamoDto> prestamoByIsbn = prestamoService.findByIsbn(prestamoDto.getIsbn());
                    if(prestamoByIsbn.isPresent()){
                /*Nota
                De acuerdo al test un usuario NO invitado si podría acceder a más libros, siempre que su ISBN sea diferente
                a uno ya registrado debido a que en la instrucción del problema indica que "identificador único de un libro "
                Por lo que la prueba tal cual se encuentra escrita siempre saldrá fallida.
                */
                        return new ResponseEntity<>(new MensajeDto(String.format("El ISBN %s debería ser un código único",prestamoDto.getIsbn())), HttpStatus.OK);
                    }else{

                        prestamoDto.setLDFechaMaximaDevolucion(DateUtils.addDaysSkippingWeekends(LocalDate.now(), getDayPerUser(prestamoDto.getTipoUsuario())));
                        PrestamoDto prestamoDtoTmp = prestamoService.save(prestamoDto);

                        return new ResponseEntity<>(new RespuestaExistosaDto(prestamoDtoTmp.getId(), prestamoDtoTmp.getFechaMaximaDevolucion()), HttpStatus.OK);
                    }

                }catch (Exception ex){
//                    System.out.println(ex.getMessage());
                    return new ResponseEntity<>(new MensajeDto("Error"), HttpStatus.BAD_REQUEST);
                }
            }
        }else{

            return new ResponseEntity<>(new MensajeDto("Tipo de usuario no permitido en la biblioteca"), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/prestamo/{id-prestamo}")
    public Optional<PrestamoDto> prestamoById(@PathVariable("id-prestamo") Long idPrestamo){
        return prestamoService.findById(idPrestamo);
    }

}

