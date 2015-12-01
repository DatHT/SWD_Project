package com.cathl.icook.entity;
// Generated Nov 28, 2015 4:05:49 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblMaterial generated by hbm2java
 */
@Entity
@Table(name = "tbl_material", catalog = "icookdb")
public class TblMaterial implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6528444085301970347L;
	private Integer materialId;
	private String mateialName;

	public TblMaterial() {
	}

	public TblMaterial(String mateialName) {
		this.mateialName = mateialName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MaterialID", unique = true, nullable = false)
	public Integer getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	@Column(name = "MateialName", nullable = false, length = 2000)
	public String getMateialName() {
		return this.mateialName;
	}

	public void setMateialName(String mateialName) {
		this.mateialName = mateialName;
	}

}
