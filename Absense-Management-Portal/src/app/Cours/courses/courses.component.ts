import { Component, OnInit } from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  errorMessage!: string;
  courses: any;

  constructor(private coursService : CoursesService, private router:Router) { }

  ngOnInit(): void {
    this.coursService.getCourses().subscribe({
      next: (data) =>{
        this.courses = data;

      },
      error : (err) =>{}
    })
  }

  handelAddCours() {
    this.router.navigateByUrl("new-cours");
  }

  handelCoursDetails(id: number) {
    this.router.navigateByUrl("cours-details/"+id);
  }

  handelDeleteCours(id: number) {
    this.coursService.deleteCours(id);
  }
}
