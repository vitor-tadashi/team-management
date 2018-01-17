package br.com.team.management.services.model;

import br.com.team.management.services.util.JsonDateDeserializer;
import br.com.team.management.services.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the professionalallocation database table.
 *
 */
@Entity
@Table(name="professionalAllocation")
@NamedQuery(name="professionalAllocation.findAll", query="SELECT e FROM professionalAllocation e")
@ApiModel(value="professionalAllocation", description="Entity that represents a professional allocation")
public class ProfessionalAllocation implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idProfessionalAllocation")
    @ApiModelProperty(dataType="Int", name="idProfessionalAllocation", required = true, value = "ID of professional allocation")
    private Integer id;

    @Column(name="idEmployee")
    @ApiModelProperty(dataType="Int", name="idEmployee", required = true, value = "ID of the allocated employee")
    private Integer idEmployee;

    @Column(name="idDirectManager")
    @ApiModelProperty(dataType="Int", name="idDirectManager", required = true, value = "Immediate manager ID")
    private Integer idDirectManager;

    @Column(name="idTypeAllocation")
    @ApiModelProperty(dataType="Int", name="idTypeAllocation", required = true, value = "ID of type allocation")
    private Integer idTypeAllocation;

    @Column(name="dtStart")
    @ApiModelProperty(dataType="java.util.Date", name="dtStart", required = true, value = "Start date of allocation")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @NotNull
    private Date startDate;

    @Column(name="dtEnd")
    @ApiModelProperty(dataType="java.util.Date", name="dtEnd", required = true, value = "End date of allocation")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @NotNull
    private Date endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdDirectManager() {
        return idDirectManager;
    }

    public void setIdDirectManager(Integer idDirectManager) {
        this.idDirectManager = idDirectManager;
    }

    public Integer getIdTypeAllocation() {
        return idTypeAllocation;
    }

    public void setIdTypeAllocation(Integer idTypeAllocation) {
        this.idTypeAllocation = idTypeAllocation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
