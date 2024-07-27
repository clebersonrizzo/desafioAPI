package com.dio.desafio.controller;

import com.dio.desafio.model.JornadaTrabalho;
import com.dio.desafio.service.JornadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
@Api(value = "API REST - JornadaTrabalho")
@CrossOrigin(origins = "*")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping("/JornadaTrabalho")
    @ApiOperation(value = "Cria JornadaTrabalho")
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping("/JornadaTrabalho/{id}")
    @ApiOperation(value = "Lista JornadaTrabalho")
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();

    }

    @GetMapping("/{idJornada}")
    @ApiOperation(value = "Retorna o id JornadaTrabalho")
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    @ApiOperation(value = "Atualiza JornadaTrabalho")
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    @ApiOperation(value = "Deleta JornadaTrabalho")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        try {
            jornadaService.deleteJornada(idJornada);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }

}


