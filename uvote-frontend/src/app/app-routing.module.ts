import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidateListComponent } from './candidate-list/candidate-list.component';

const routes: Routes = [
    { path: 'candidates', component: CandidateListComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }