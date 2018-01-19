package br.com.team.management.services.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the typeallocation database table.
 *
 */
@Entity
@Table(name="TYPEALLOCATION")
@NamedQuery(name="typeallocation.findAll", query="SELECT ta FROM TypeAllocation ta")
@ApiModel(value="typeallocation", description="Entity that represents a type allocation")
public class TypeAllocation implements Serializable {

    private static final long serialVersionUID = 1L;

    public TypeAllocation() {
    }

    public TypeAllocation(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idtypeallocation")
    @ApiModelProperty(dataType="Int", name="idTypeAllocation", required = true, value = "ID of type allocation")
    private Integer id;

    @Column(name="nmtypeallocation")
    @ApiModelProperty(dataType="Int", name="nmTypeAllocation", required = true, value = "Name of type allocation")
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


