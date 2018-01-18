package br.com.team.management.services.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the solicitationstatus database table.
 *
 */
@Entity
@Table(name="SOLICITATIONSTATUS")
@NamedQuery(name="solicitationstatus.findAll", query="SELECT ss FROM SolicitationStatus ss")
@ApiModel(value="solicitationstatus", description="Entity that represents a solicitation status")
public class SolicitationStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    public SolicitationStatus() {
    }

    public SolicitationStatus(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idsolicitationstatus")
    @ApiModelProperty(dataType="Int", name="idsolicitationstatus", required = true, value = "ID of solicitation status")
    private Integer id;

    @Column(name="nmsolicitationstatus")
    @ApiModelProperty(dataType="Int", name="nmsolicitationstatus", required = true, value = "Name of solicitation status")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
