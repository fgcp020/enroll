package com.nercel.enroll.common.sms;

import java.io.Serializable;
import java.util.List;

public class SmsesResult implements Serializable {

    private Integer total_count;

    private Double total_fee;

    private String unit;

    private List<DataInfo> data;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Double total_fee) {
        this.total_fee = total_fee;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<DataInfo> getData() {
        return data;
    }

    public void setData(List<DataInfo> data) {
        this.data = data;
    }

    public static class DataInfo{
        public String msg;
        public Integer count;
        public Double fee;
        public String unit;
        public String mobile;
        public Long sid;
    }

	@Override
	public String toString() {
		return "SmsesResult [total_count=" + total_count + ", total_fee="
				+ total_fee + ", unit=" + unit + ", data=" + data + "]";
	}

}