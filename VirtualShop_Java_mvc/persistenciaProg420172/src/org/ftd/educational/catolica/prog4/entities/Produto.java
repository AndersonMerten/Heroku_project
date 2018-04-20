/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftd.educational.catolica.prog4.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Anderson
 */

@Entity
@NamedQueries({
            @NamedQuery(name="Produto.find.by.name",
                    query="SELECT o FROM Produto o WHERE o.name =:name"),
            @NamedQuery(name="produto.find.by.id",
                    query="SELECT o FROM Produto o WHERE o.id =:id"),
            
})
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 45)
    private String name;
    
    @Column(unique = true, nullable = false, length = 15)
    private Long price;    
    
    @Column(unique = false, nullable = false, length = 15)
    private String descricao;


    public Long getId() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = codigo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
