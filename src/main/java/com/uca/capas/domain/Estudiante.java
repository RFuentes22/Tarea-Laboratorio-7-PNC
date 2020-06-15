package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(generator="estudiante_id_estudiante_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="estudiante_id_estudiante_seq",sequenceName="public.estudiante_id_estudiante_seq", allocationSize = 1)
	@Column(name="id_estudiante")
	private Integer codigoEstudiante;
	
	@Size(message="El Campo no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="El Campo no puede estar vacio")
	@Column(name="nombre")
	private String	nombre;
	
	@Size(message="El Campo no debe de tener mas de 30 caracteres",max=30)
	@NotEmpty(message="El Campo no puede estar vacio")
	@Column(name="apellido")
	private String	apellido;
	
	@NotNull(message="El Campo no puede estar vacio")
	@Min(value=18,message="No puede ser menor a 18 años")
	@Column(name="edad")
	private Integer edad;
	
	@Column(name="estado")
	private Boolean estado;
	/*
	@OneToMany(mappedBy = "estudiante",fetch = FetchType.EAGER)
	private List<Computadora> computadoras;
	*/
	public Estudiante(){
		
	}
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	//Delegate
	public String getEstadoDelegate() {
		if(this.estado==null) return "";
		else {
			return estado == true ? "Activo":"Inactivo";
		}
		
	}
	/*
	public List<Computadora> getComputadoras() {
		return computadoras;
	}
	public void setComputadoras(List<Computadora> computadoras) {
		this.computadoras = computadoras;
	}*/

	

}
