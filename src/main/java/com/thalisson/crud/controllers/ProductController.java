package com.thalisson.crud.controllers;

import com.thalisson.crud.dtos.ProductDto;
import com.thalisson.crud.model.Product;
import com.thalisson.crud.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Esta classe serve como controlador REST para gerenciar operações relacionadas a produtos.
 * Ela fornece endpoints para manipular operações CRUD em produtos no sistema.
 * A classe aproveita os recursos REST e injeção de dependência do Spring Boot
 * para simplificar o processamento de requisições HTTP e interações com o banco de dados.
 * </p>
 * <p>
 * Endpoints:
 * <br>
 * - GET /products: Recupera a lista de todos os produtos no banco de dados.
 * <br>
 * - POST /products: Cria e persiste um novo produto com base nos dados fornecidos.
 * <br>
 * - GET /products/{id}: Recupera um produto específico pelo seu ID.
 * <br>
 * - DELETE /products/{id}: Exclui um produto específico pelo seu ID.
 * <br>
 * - PUT /products/{id}: Atualiza os detalhes de um produto existente pelo seu ID.
 * </p>
 * <p>
 * Anotações:
 * <br>
 * - @RestController: Indica que esta classe é um Controlador REST do Spring.
 * <br>
 * - @RequestMapping: Mapeia requisições HTTP para métodos específicos na classe.
 * </p>
 * <p>
 * Dependências:
 * <br>
 * - {@link ProductRepository}: Usado para interagir com o banco de dados para dados de produtos.
 * <br>
 * - {@link ProductDto}: Representa o objeto de transferência de dados para requisições relacionadas a produtos.
 * <br>
 * - {@link Product}: Representa a entidade de produto armazenada no banco de dados.
 * </p>
 * <p>
 * Códigos de Status HTTP:
 * <br>
 * - 200 OK: Para recuperação ou exclusão bem-sucedida de recursos.
 * <br>
 * - 201 CREATED: Para criação bem-sucedida de um novo produto.
 * <br>
 * - 302 FOUND: Quando um recurso é localizado com sucesso via ID.
 * <br>
 * - 404 NOT FOUND: Quando o ID do produto especificado não existe.
 * </p>
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        List<Product> listProducts = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductDto dto) {
        var product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") int id) {
        Optional product = repository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(product.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") int id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        repository.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable(value = "id") int id, @RequestBody ProductDto dto) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = product.get();
        BeanUtils.copyProperties(dto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(productModel));
    }

}
