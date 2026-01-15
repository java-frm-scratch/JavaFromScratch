package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller", description = "APIs for managing products")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created successfully",
                    content = @Content(schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @Operation(summary = "Update a product by ID")
    @PutMapping("/{id}")
    public ProductResponse updateProduct(
            @Parameter(description = "ID of the product to be updated") @PathVariable Long id,
            @Parameter(description = "New name for the product") @RequestParam String name) {
        return productService.updateProduct(id, name);
    }

    @Operation(summary = "Get a product by ID")
    @GetMapping("/{id}")
    public ProductResponse getProduct(
            @Parameter(description = "ID of the product to be retrieved") @PathVariable Long id) {
        return productService.getProduct(id);
    }
}