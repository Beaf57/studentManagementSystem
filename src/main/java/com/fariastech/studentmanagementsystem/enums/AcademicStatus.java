package com.fariastech.studentmanagementsystem.enums;

public enum AcademicStatus {
	APPROVED(1),
	RECOVERY(2),
	FAILED(3);
	
	
	private final int code;
	
	AcademicStatus(int code){
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static AcademicStatus fromCode(int code) {
		for(AcademicStatus status : AcademicStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid AcademicStatus code: " + code);
	}
}
