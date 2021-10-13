package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.dto.ProviderDto;
import com.inerxia.saletrackingapi.facade.ProviderFacade;
import com.inerxia.saletrackingapi.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    private ProviderFacade providerFacade;

    public ProviderController(ProviderFacade providerFacade){
        this.providerFacade=providerFacade;
    }

    @GetMapping("/get-by-id/{id}")
    @ApiOperation(value = "Get providers by id", response = ProviderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProviderDto>> findById(@PathVariable Integer id){
        ProviderDto providerDto = providerFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                providerDto));
    }

    @GetMapping("/get-all")
    @ApiOperation(value = "get all providers", response = ProviderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ProviderDto>>> findAll(){

        List<ProviderDto> productDtoList = providerFacade.findAll();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                productDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Save a provider", response = ProviderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProviderDto>> createProduct(
            @Valid @RequestBody ProviderDto providerDto){
        ProviderDto providerDto1 = providerFacade.createProvider(providerDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "provider.create.ok",
                providerDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edit provider", response = ProviderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProviderDto>> editarServicio(
            @Valid @RequestBody ProviderDto providerDto){
        ProviderDto providerDto1 = providerFacade.editProvider(providerDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "provider.editar.exito",
                providerDto1));
    }

}
