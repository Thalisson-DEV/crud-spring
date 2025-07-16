package com.thalisson.crud.model;

import jakarta.persistence.*;

/**
 * Representa uma entidade de produto armazenada no banco de dados. Esta classe está mapeada
 * para uma tabela do banco de dados chamada "product".
 * <p>
 * Esta classe de entidade é usada para gerenciar registros de produtos, e contém atributos
 * como ID do produto, nome e preço. O ID é gerado automaticamente, garantindo uma
 * identificação única para cada produto.
 * <p>
 * A classe é utilizada para operações CRUD no sistema, incluindo criação,
 * recuperação, atualização e exclusão de dados do produto.
 * <p>
 * Anotações:
 * <br>
 * - @Entity: Identifica esta classe como uma entidade JPA.
 * <br>
 * - @Table: Especifica a tabela no banco de dados para a qual esta entidade está mapeada.
 * <br>
 * - @Id: Marca o campo da chave primária.
 * <br>
 * - @GeneratedValue: Indica que a chave primária é gerada automaticamente usando uma estratégia específica.
 */
@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Long price;

    public Product() {
    }
    public Product(int id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
