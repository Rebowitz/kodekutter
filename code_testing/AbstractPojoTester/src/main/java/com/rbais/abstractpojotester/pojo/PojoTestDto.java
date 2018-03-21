/**
 * 
 */
package com.rbais.abstractpojotester.pojo;

import java.util.Date;
import java.util.List;

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
    private Integer pojoIntegerValue;
    private Boolean pojoBooleanValue;
    private List<?> pojoList;
	
	public String getPojoStringType() {
		return pojoStringType;
	}

	public void setPojoStringType(String pojoStringType) {
		this.pojoStringType = pojoStringType;
	}

	public Long getPojoLongValue() {
		return pojoLongValue;
	}

	public void setPojoLongValue(Long pojoLongValue) {
		this.pojoLongValue = pojoLongValue;
	}

	public Date getPojoDateTimeValue() {
		return pojoDateTimeValue;
	}

	public void setPojoDateTimeValue(Date pojoDateTimeValue) {
		this.pojoDateTimeValue = pojoDateTimeValue;
	}

	public Integer getPojoIntegerValue() {
		return pojoIntegerValue;
	}

	public void setPojoIntegerValue(Integer pojoIntegerValue) {
		this.pojoIntegerValue = pojoIntegerValue;
	}

	public Boolean getPojoBooleanValue() {
		return pojoBooleanValue;
	}

	public void setPojoBooleanValue(Boolean pojoBooleanValue) {
		this.pojoBooleanValue = pojoBooleanValue;
	}

	public List<?> getPojoList() {
		return pojoList;
	}

	public void setPojoList(List<?> pojoList) {
		this.pojoList = pojoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pojoBooleanValue == null) ? 0 : pojoBooleanValue.hashCode());
		result = prime * result + ((pojoDateTimeValue == null) ? 0 : pojoDateTimeValue.hashCode());
		result = prime * result + ((pojoIntegerValue == null) ? 0 : pojoIntegerValue.hashCode());
		result = prime * result + ((pojoList == null) ? 0 : pojoList.hashCode());
		result = prime * result + ((pojoLongValue == null) ? 0 : pojoLongValue.hashCode());
		result = prime * result + ((pojoStringType == null) ? 0 : pojoStringType.hashCode());
		return result;
	}

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
		if (pojoDateTimeValue == null) {
			if (other.pojoDateTimeValue != null)
				return false;
		} else if (!pojoDateTimeValue.equals(other.pojoDateTimeValue))
			return false;
		if (pojoIntegerValue == null) {
			if (other.pojoIntegerValue != null)
				return false;
		} else if (!pojoIntegerValue.equals(other.pojoIntegerValue))
			return false;
		if (pojoList == null) {
			if (other.pojoList != null)
				return false;
		} else if (!pojoList.equals(other.pojoList))
			return false;
		if (pojoLongValue == null) {
			if (other.pojoLongValue != null)
				return false;
		} else if (!pojoLongValue.equals(other.pojoLongValue))
			return false;
		if (pojoStringType == null) {
			if (other.pojoStringType != null)
				return false;
		} else if (!pojoStringType.equals(other.pojoStringType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PojoTestDto [pojoStringType=" + pojoStringType + ", pojoLongValue=" + pojoLongValue
				+ ", pojoDateTimeValue=" + pojoDateTimeValue + ", pojoIntegerValue=" + pojoIntegerValue
				+ ", pojoBooleanValue=" + pojoBooleanValue + ", pojoList=" + pojoList + "]";
	}



}
