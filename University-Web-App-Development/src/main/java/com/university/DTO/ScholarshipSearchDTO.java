package com.university.DTO;

public class ScholarshipSearchDTO {
    private String courseName;
    private String level;
    private String duration;
    private String description;
    private String entryRequirements;
    
	public ScholarshipSearchDTO(String courseName, String level, String duration, String description,
			String entryRequirements) {
		super();
		this.courseName = courseName;
		this.level = level;
		this.duration = duration;
		this.description = description;
		this.entryRequirements = entryRequirements;
	}

	public ScholarshipSearchDTO() {
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEntryRequirements() {
		return entryRequirements;
	}
	public void setEntryRequirements(String entryRequirements) {
		this.entryRequirements = entryRequirements;
	}
	@Override
	public String toString() {
		return "ScholarshipSearchDTO [courseName=" + courseName + ", level=" + level + ", duration=" + duration
				+ ", description=" + description + ", entryRequirements=" + entryRequirements + "]";
	}
}
