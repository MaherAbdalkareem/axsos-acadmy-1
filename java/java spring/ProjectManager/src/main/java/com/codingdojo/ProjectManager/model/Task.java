package com.codingdojo.ProjectManager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="tasks")
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotEmpty(message="task is required!")
    @Size(min=3, max=300, message="task must be between 3 and 30 characters")
    private String task;
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="userTask")
	    private User userTask;
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="projectTask")
	    private Project projectTask;
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    
	    }
		public Task() {
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTask() {
			return task;
		}
		public void setTask(String task) {
			this.task = task;
		}
		public User getUserTask() {
			return userTask;
		}
		public void setUserTask(User userTask) {
			this.userTask = userTask;
		}
		public Project getProjectTask() {
			return projectTask;
		}
		public void setProjectTask(Project projectTask) {
			this.projectTask = projectTask;
		}
		
		
}
