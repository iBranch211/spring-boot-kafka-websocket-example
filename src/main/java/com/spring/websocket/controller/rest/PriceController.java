package com.spring.websocket.controller.rest;


import com.spring.websocket.model.response.PriceResponseDto;
import com.spring.websocket.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "bitcoin", description = "Retrieve and manage bitcoin")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class PriceController  {

    final PriceService priceService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = PriceResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Get last price")
    @GetMapping("/bitcoin/last")
    @ResponseStatus(HttpStatus.OK)
    public PriceResponseDto getLastPrice(){
        return priceService.getLastPrice();
    }


}
