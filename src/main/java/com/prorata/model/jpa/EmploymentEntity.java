/*
 * Created on 5 Mar 2016 ( Time 20:49:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.prorata.model.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Persistent class for entity stored in table "employment"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="employment", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="EmploymentEntity.countAll", query="SELECT COUNT(x) FROM EmploymentEntity x" )
} )
@JsonIgnoreProperties(ignoreUnknown = true) 
public class EmploymentEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="employment_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employment_employment_id_pk_seq")
    @SequenceGenerator(name = "employment_employment_id_pk_seq", sequenceName = "employment_employment_id_pk_seq")
    protected Integer    employmentId ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", nullable=false, length=10)
    protected String     name         ;

    @Column(name="hourly_rate", nullable=false)
    protected BigDecimal hourlyRate   ;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date", nullable=false)
    protected Date       startDate    ;

    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    protected Date       endDate      ;

    @Column(name="hours_per_week")
    protected BigDecimal hoursPerWeek ;

	// "employerId" (column "employer_id") is not defined by itself because used as FK in a link 
	// "prorataUserId" (column "prorata_user_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @JsonManagedReference("EmploymentEntity_EmploymentSessionEntity")
    @OneToMany(mappedBy="employment", targetEntity=EmploymentSessionEntity.class)
    protected List<EmploymentSessionEntity> listOfEmploymentSession;

    @JsonBackReference("ProrataUserEntity_EmploymentEntity")
    @ManyToOne
    @JoinColumn(name="prorata_user_id", referencedColumnName="prorata_user_id")
    protected ProrataUserEntity prorataUser ;

    @JsonManagedReference("EmploymentEntity_ContractEntity")
    @OneToMany(mappedBy="employment", targetEntity=ContractEntity.class)
    protected List<ContractEntity> listOfContract;

    @JsonManagedReference("EmploymentEntity_PaymentEntity")
    @OneToMany(mappedBy="employment", targetEntity=PaymentEntity.class)
    protected List<PaymentEntity> listOfPayment;

    @JsonBackReference("EmployerEntity_EmploymentEntity")
    @ManyToOne
    @JoinColumn(name="employer_id", referencedColumnName="employer_id")
    protected EmployerEntity employer    ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EmploymentEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setEmploymentId( Integer employmentId ) {
        this.employmentId = employmentId ;
    }
    public Integer getEmploymentId() {
        return this.employmentId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : name ( varchar ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : hourly_rate ( numeric ) 
    public void setHourlyRate( BigDecimal hourlyRate ) {
        this.hourlyRate = hourlyRate;
    }
    public BigDecimal getHourlyRate() {
        return this.hourlyRate;
    }

    //--- DATABASE MAPPING : start_date ( date ) 
    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }

    //--- DATABASE MAPPING : end_date ( date ) 
    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }

    //--- DATABASE MAPPING : hours_per_week ( numeric ) 
    public void setHoursPerWeek( BigDecimal hoursPerWeek ) {
        this.hoursPerWeek = hoursPerWeek;
    }
    public BigDecimal getHoursPerWeek() {
        return this.hoursPerWeek;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfEmploymentSession( List<EmploymentSessionEntity> listOfEmploymentSession ) {
        this.listOfEmploymentSession = listOfEmploymentSession;
    }
    public List<EmploymentSessionEntity> getListOfEmploymentSession() {
        return this.listOfEmploymentSession;
    }

    public void setProrataUser( ProrataUserEntity prorataUser ) {
        this.prorataUser = prorataUser;
    }
    public ProrataUserEntity getProrataUser() {
        return this.prorataUser;
    }

    public void setListOfContract( List<ContractEntity> listOfContract ) {
        this.listOfContract = listOfContract;
    }
    public List<ContractEntity> getListOfContract() {
        return this.listOfContract;
    }

    public void setListOfPayment( List<PaymentEntity> listOfPayment ) {
        this.listOfPayment = listOfPayment;
    }
    public List<PaymentEntity> getListOfPayment() {
        return this.listOfPayment;
    }

    public void setEmployer( EmployerEntity employer ) {
        this.employer = employer;
    }
    public EmployerEntity getEmployer() {
        return this.employer;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(employmentId);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(hourlyRate);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        sb.append("|");
        sb.append(hoursPerWeek);
        return sb.toString(); 
    } 

}
