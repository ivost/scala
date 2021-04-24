package com.example.app

import java.util.UUID

import com.datastax.driver.core._
import troy.dsl._
import troy.driver.DSL._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

/*
http://www.scalatra.org/2.4/guides/persistence/introduction.html

 */

class MyService(implicit session: Session, ec: ExecutionContext) {
  import scala.concurrent.ExecutionContext.Implicits.global

  val create = withSchema { (authorId: String, title: String) =>
    cql"""
       INSERT INTO test.posts (author_id , post_id , post_title )
       VALUES ( $authorId, now(), $title);
     """.prepared.executeAsync
  }

  val get = withSchema { (authorId: String, postId: UUID) =>
    cql"""
      SELECT post_id, author_name, reviewer_name, post_title, post_rating, post_tags
      FROM test.posts
      WHERE author_id = $authorId AND post_id = $postId;
    """.prepared.as(Post)
  }

  val listByAuthor = withSchema { (authorId: String) =>
    cql"""
         SELECT post_id, author_name, reviewer_name, post_title, post_rating, post_tags
         FROM test.posts
         WHERE author_id = $authorId
       """
      .prepared
      .executeAsync
      .as(Post)
  }

  val update = withSchema { (authorId: String, postId: UUID, newTitle: String) =>
    cql"""
       UPDATE test.posts SET post_title = $newTitle WHERE author_id = $authorId AND post_id = $postId;
     """.prepared.executeAsync
  }

  val delete = withSchema { (authorId: String, postId: UUID) =>
    cql"""
       DELETE FROM test.posts WHERE author_id = $authorId AND post_id = $postId;
     """.prepared.executeAsync
  }

}




