import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  user!:string;
password!:string;

message!:string;
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  
}
