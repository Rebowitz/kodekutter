/**
 * 
 */
package com.rbais.jsongenerator.object;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @author Robert B. Andrews
 * $Rev$
 * $Date$
 *
 */
public class PojoTestDto {
	
	private String pojoStringType;
    private Long pojoLongValue;
    private Date pojoDateTimeValue;
    private Integer pojoIntegverValue;
    private Boolean pojoBooleanValue;
    private Collection<?> pojoCollection;
    private Set<?> pojoSet;
	
    /**
	 * @return the pojoStringType
	 */
	public String getPojoStringType() {
		return pojoStringType;
	}

	/**
	 * @param pojoStringType the pojoStringType to set
	 */
	public void setPojoStringType(String pojoStringType) {
		this.pojoStringType = pojoStringType;
	}

	/**
	 * @return the pojoLongValue
	 */
	public Long getPojoLongValue() {
		return pojoLongValue;
	}

	/**
	 * @param pojoLongValue the pojoLongValue to set
	 */
	public void setPojoLongValue(Long pojoLongValue) {
		this.pojoLongValue = pojoLongValue;
	}

	/**
	 * @return the pojoDateTimeValue
	 */
	public Date getPojoDateTimeValue() {
		return pojoDateTimeValue;
	}

	/**
	 * @param pojoDateTimeValue the pojoDateTimeValue to set
	 */
	public void setPojoDateTimeValue(Date pojoDateTimeValue) {
		this.pojoDateTimeValue = pojoDateTimeValue;
	}

	/**
	 * @return the pojoIntegverValue
	 */
	public Integer getPojoIntegverValue() {
		return pojoIntegverValue;
	}

	/**
	 * @param pojoIntegverValue the pojoIntegverValue to set
	 */
	public void setPojoIntegverValue(Integer pojoIntegverValue) {
		this.pojoIntegverValue = pojoIntegverValue;
	}

	/**
	 * @return the pojoBooleanValue
	 */
	public Boolean getPojoBooleanValue() {
		return pojoBooleanValue;
	}

	/**
	 * @param pojoBooleanValue the pojoBooleanValue to set
	 */
	public void setPojoBooleanValue(Boolean pojoBooleanValue) {
		this.pojoBooleanValue = pojoBooleanValue;
	}

	/**
	 * @return the pojoCollection
	 */
	public Collection getPojoCollection() {
		return pojoCollection;
	}

	/**
	 * @param pojoCollection the pojoCollection to set
	 */
	public void setPojoCollection(Collection pojoCollection) {
		this.pojoCollection = pojoCollection;
	}

	/**
	 * @return the pojoSet
	 */
	public Set getPojoSet() {
		return pojoSet;
	}

	/**
	 * @param pojoSet the pojoSet to set
	 */
	public void setPojoSet(Set pojoSet) {
		this.pojoSet = pojoSet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pojoBooleanValue == null) ? 0 : pojoBooleanValue.hashCode());
		result = prime * result + ((pojoCollection == null) ? 0 : pojoCollection.hashCode());
		result = prime * result + ((pojoDateTimeValue == null) ? 0 : pojoDateTimeValue.hashCode());
		result = prime * result + ((pojoIntegverValue == null) ? 0 : pojoIntegverValue.hashCode());
		result = prime * result + ((pojoLongValue == null) ? 0 : pojoLongValue.hashCode());
		result = prime * result + ((pojoSet == null) ? 0 : pojoSet.hashCode());
		result = prime * result + ((pojoStringType == null) ? 0 : pojoStringType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PojoTestDto other = (PojoTestDto) obj;
		if (pojoBooleanValue == null) {
			if (other.pojoBooleanValue != null)
				return false;
		} else if (!pojoBooleanValue.equals(other.pojoBooleanValue))
			return false;
		if (pojoCollection == null) {
			if (other.pojoCollection != null)
				return false;
		} else if (!pojoCollection.equals(other.pojoCollection))
			return false;
		if (pojoDateTimeValue == null) {
			if (other.pojoDateTimeValue != null)
				return false;
		} else if (!pojoDateTimeValue.equals(other.pojoDateTimeValue))
			return false;
		if (pojoIntegverValue == null) {
			if (other.pojoIntegverValue != null)
				return false;
		} else if (!pojoIntegverValue.equals(other.pojoIntegverValue))
			return false;
		if (pojoLongValue == null) {
			if (other.pojoLongValue != null)
				return false;
		} else if (!pojoLongValue.equals(other.pojoLongValue))
			return false;
		if (pojoSet == null) {
			if (other.pojoSet != null)
				return false;
		} else if (!pojoSet.equals(other.pojoSet))
			return false;
		if (pojoStringType == null) {
			if (other.pojoStringType != null)
				return false;
		} else if (!pojoStringType.equals(other.pojoStringType))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PojoTestDto [pojoStringType=" + pojoStringType + ", pojoLongValue=" + pojoLongValue
				+ ", pojoDateTimeValue=" + pojoDateTimeValue + ", pojoIntegverValue=" + pojoIntegverValue
				+ ", pojoBooleanValue=" + pojoBooleanValue + ", pojoCollection=" + pojoCollection + ", pojoSet="
				+ pojoSet + "]";
	}


}
