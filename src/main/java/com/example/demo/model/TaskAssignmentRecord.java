package com.example.demo.model;
import java.time.LocalDateTime;
public class TaskAssignmentRecord{
    private long id;
    private long taskId;
    private long volunteerId;
    private LocalDateTime assignedAt;
    private String status;
    private String notes;
}
public TaskAssignmentRecord(){

}
public TaskAssignmentRecord(long id,long taskId,long volunterrId,LocalDateTime AssignedAt,String status,String notes){
    this.id=id;
    this.taskId=taskId;
    this.volunteerId=volunterrId;
    this.assignedAt=assignedAt;
    this.status=status;
    this.notes=notes;
}
public void SetTaskId(long taskId){
    this.taskId=taskId;
}
public void SetVolunteerId(long volunterrId){
    this.volunteerId=volunteerId;
}
public void SetAssignedId(LocalDateTime assignedAt){
    this.assignedAt=assignedAt;
}
public void SetStatus(String status){
    this.status=status;
}
public void SetNotes(String notes){
    this.notes=notes;
}
public long getTaskId(){
    return taskid;
}
public long VolunteerId(){
    return volunteerid;
}
public LocalDateTime AssignedAt(){
    return assignedAt;
}
public String getStatus(){
    return status;
}
public String Notes(){
    return notes;
}