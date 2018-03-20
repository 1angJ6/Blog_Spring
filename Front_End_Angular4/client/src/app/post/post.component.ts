import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostService } from '../app-service/post.service';
import { Post } from '../post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  private post_id: string;
  private list_posts: boolean;

  private posts: Post[];
  private post: Post;

  constructor(
    private activatedRoute : ActivatedRoute,
    private postService: PostService,
    private router: Router) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.post_id = params.get("post_id");
      this.list_posts = this.post_id === null;

      this.postService.getPosts().subscribe(data => {
        this.posts = data;
      });
      
      if (!this.list_posts) {
        this.postService.getPost(this.post_id).subscribe(
          data => this.post = data,
          error => this.router.navigate(["/oops"]));
      }
    });
  }

}
