import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-snackbar',
  templateUrl: './snackbar.component.html',
  styleUrls: ['./snackbar.component.scss']
})
export class SnackbarComponent implements OnInit {
  @Input() displayMessage!:string;
  snackBarMessage=""
  constructor() { }

  ngOnInit(): void {
    this.snackBarMessage=this.displayMessage;
  }

}
