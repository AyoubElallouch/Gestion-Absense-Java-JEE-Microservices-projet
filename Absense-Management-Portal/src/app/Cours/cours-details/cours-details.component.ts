import { Component, OnInit } from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ClassroomsService} from "../../services/classrooms.service";
import {ProfessorsService} from "../../services/professors.service";
import {StudentsService} from "../../services/students.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {elementAt} from "rxjs";

@Component({
  selector: 'app-cours-details',
  templateUrl: './cours-details.component.html',
  styleUrls: ['./cours-details.component.css']
})
export class CoursDetailsComponent implements OnInit {
  course: any;
  errorMessage!: string;
  coursID!: number;
  students: any;
  listId: Array<number> = [];
  listIdFiltred: Array<number> = [];
  constructor(private coursService: CoursesService, private router: Router, private route: ActivatedRoute,
              private studentService : StudentsService, private fb: FormBuilder) {
    this.coursID = this.route.snapshot.params['coursID'];
  }

  ngOnInit(): void {
    this.coursService.getCoursById(this.coursID).subscribe({
      next : (data)=>{
        this.course = data;
        this.studentService.getStudentsByClass(this.course.classroomId).subscribe({
          next: (data)=>{
            this.students = data;
            console.log(data);
          },
          error: (err)=>{}
        })
      },
      error : (err)=>{}
    })
  }

  handelAddCours() {

  }

  handelDeleteCours(id: number) {

  }

  handleSaveAbsenses() {

  }

  handelStudentAbsense() {
    console.log(this.listId);
  }

  onChange(id: number) {
    console.log(id);
    this.listId.push(id);
  }
}
