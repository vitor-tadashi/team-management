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
@Table(name="PROFESSIONALALLOCATION")
@NamedQuery(name="professionalallocation.findAll", query="SELECT pa FROM ProfessionalAllocation pa")
@ApiModel(value="professionalallocation", description="Entity that represents a professional allocation")
public class ProfessionalAllocation implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProfessionalAllocation() {
    }

    public ProfessionalAllocation(Integer idEmployee, Integer idDirectManager, TypeAllocation typeAllocation, Date startDate, Date endDate) {
        this.idEmployee = idEmployee;
        this.idDirectManager = idDirectManager;
        this.typeAllocation = typeAllocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idprofessionalallocation")
    @ApiModelProperty(dataType="Int", name="idProfessionalAllocation", required = true, value = "ID of professional allocation")
    private Integer id;

    @Column(name="idemployee")
    @ApiModelProperty(dataType="Int", name="idEmployee", required = true, value = "ID of the allocated employee")
    private Integer idEmployee;

    @Column(name="iddirectmanager")
    @ApiModelProperty(dataType="Int", name="idDirectManager", required = true, value = "Immediate manager ID")
    private Integer idDirectManager;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idtypeallocation", nullable=true)
    @ApiModelProperty(dataType="Int", name="TypeAllocation", required = true, value = "Type allocation")
    private TypeAllocation typeAllocation;

    @Column(name="dtstart")
    @ApiModelProperty(dataType="java.util.Date", name="dtStart", required = true, value = "Start date of allocation")
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @NotNull
    private Date startDate;

    @Column(name="dtend")
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

    public TypeAllocation getTypeAllocation() {
        return typeAllocation;
    }

    public void setTypeAllocation(TypeAllocation typeAllocation) {
        this.typeAllocation = typeAllocation;
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
