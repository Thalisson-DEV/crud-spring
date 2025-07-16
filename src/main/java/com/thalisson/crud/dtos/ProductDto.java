package com.thalisson.crud.dtos;

/**
 * Representa um objeto de transferência de dados (DTO) para uma entidade de produto.
 * Esta classe foi projetada para facilitar a transferência de dados do produto
 * entre diferentes camadas da aplicação, como controllers, services e repositories.
 * <p>
 * A classe ProductDto contém apenas os campos essenciais necessários para operações relacionadas a produtos,
 * especificamente o nome e o preço do produto, e é imutável por design.
 * <p>
 * Características principais deste record:
 * <br>
 * - Projetado para otimizar a transferência de dados na aplicação minimizando sobrecarga desnecessária.
 * <br>
 * - Compatível com anotações do Spring Framework como @RequestBody para manipular requisições HTTP.
 * <br>
 * - Utilizado para criar, atualizar e gerenciar dados relacionados a produtos no sistema.
 * <p>
 * Casos de uso aplicáveis:
 * <br>
 * - Criação de um novo produto (por exemplo, em uma requisição POST).
 * <br>
 * - Atualização de um produto existente (por exemplo, em uma requisição PUT).
 * <br>
 * - Fornecimento de entrada para operações da camada de serviço ou persistência no banco de dados.
 */
public record ProductDto(String name, Long price) {
}
