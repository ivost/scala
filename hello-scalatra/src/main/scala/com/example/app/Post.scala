package com.example.app

import java.util.UUID

case class Post(
                 id: UUID,
                 authorName: String,
                 reviewerName: Option[String],
                 title: String,
                 rating: Option[Int],
                 tags: Seq[String]
               )
