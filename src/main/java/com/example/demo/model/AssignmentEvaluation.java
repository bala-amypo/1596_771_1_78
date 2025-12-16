package com.example.demo.model;
import java.time.LocalDateTime
public class AssignmentEvaluation{
    private long id;
    private long taskId;
    private long volunteerId;
    private LocalDateTime assignedAt;
    private String status;
    private String notes;
}
public AssignmentEvaluation(){

}
public Student(long id,long taskId,long volunterrId,LocalDateTime,String status,String notes){
    this.id=id;
    this.taskId=taskId;
    this.volunteerId=volunterrId;
    this.assignedAt=assignedAt;
    this.status=status;
    this.notes=notes;
}
public void SetId(long id){
    this.id=id;
}
public void SetTaskId(long taskId){
    this.taskId=taskId;
}
public void SetVolunteerId(long volunterrId){
    this.volunteerId=volunteerId;
}
public void 