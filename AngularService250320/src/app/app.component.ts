import { Component, OnInit } from '@angular/core';
import { UserserviceService } from './myservices/userservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'AngularService250320';
  employees: any;
  users: any;
  usersStudent: any[];
  constructor(private userservice: UserserviceService) { }
  errMsg: string;
  noError: boolean;
  ngOnInit() {
    //this.users = this.userservice.getAllUsers();
    /*this.userservice.getAllEmployees()
      .subscribe(
        //(data) => { this.noError = true; this.employees = data },
        (data) => { this.noError = true; this.employees = data },
        //(error)=>{this.noError=false; this.errMsg=error.message}
        (error) => { this.noError = false; this.errMsg = error }
      );*/
     this.userservice.getAllUsers()
      .subscribe(
        //(data) => { this.noError = true; this.employees = data },
        (data) => { this.noError = true; this.users = data },
        //(error)=>{this.noError=false; this.errMsg=error.message}
        (error) => { this.noError = false; this.errMsg = error }
      ); 
      /*this.userservice.getAllUsersStudent()
      .subscribe(
        //(data) => { this.noError = true; this.employees = data },
        (data) => { this.noError = true; this.usersStudent = data },
        //(error)=>{this.noError=false; this.errMsg=error.message}
        (error) => { this.noError = false; this.errMsg = error }
      );  */
  }
  usersArrayFromService: any[] = this.userservice.getAllUsersArray();//Or directly assign
  //bellowline not recomended (note: classvar assign onlyatdeclaretime
  //further assign mustbe done inside method; constructor for
  //creating instance like new operator, not for value assignment 
  //anyclassvar: any[] = new UserserviceService().getAllUsers(); //no recommend
  usersArrayFromComponent: any[] = [
    { id: 101, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") },
    { id: 102, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") },
    { id: 103, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") },
    { id: 104, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") },
    { id: 105, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") },
    { id: 106, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") },
    { id: 107, name: "john", city: "Dhaka", salary: 2000, dob: new Date("12/25/1980") }
  ];
  heroes = ['Windstorm', 'Bombasto', 'Magneta', 'Tornado'];
  heroes2 = [
    new Hero(1, "shfl"),
    new Hero(13, 'Bombasto'),
    new Hero(15, 'Magneta'),
    new Hero(20, 'Tornado')
  ];
}
export class Hero {
  constructor(public id: number, public name: string) {

  }
}
export class Note {
  constructor(public id: number, public title: string, public content: string,public createdAt: Date,public updateddAt: Date) { }

}
export class Users {
  constructor(public id: number, public name: string, public email: string) { }

}