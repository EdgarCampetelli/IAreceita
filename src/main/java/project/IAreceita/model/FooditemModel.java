package project.IAreceita.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="tb_food_item")
@NoArgsConstructor
@AllArgsConstructor
public class FooditemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private LocalDateTime validade;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }
}
