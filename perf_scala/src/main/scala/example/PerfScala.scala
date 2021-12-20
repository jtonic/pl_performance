#!/usr/bin/env scala

/*
  @author Brian Schlining
  @since 2021-10-25

  Scala version of example code at
  https://python.plainenglish.io/send-http-requests-as-fast-as-possible-in-python-304134d46604
*/

import java.io.BufferedInputStream
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.concurrent.Executors
import scala.collection.immutable.LazyList
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success
import scala.util.Using


implicit val ec = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(20))

// Future's are executed asynchronously on the implicit ExecutionContext
def downloadLink(url: URL): Future[Unit] = Future {

  val opt = Using(new BufferedInputStream(url.openStream())) { io => {
    new String(io.readAllBytes(), StandardCharsets.UTF_8)
  }}

  // `Using` automatically closes the input stream from the URL. It returns
  // A Success or Failure. We pattern match to see which was returned.
  opt match {
    case Success(s) => println(s"Read ${s.length} from ${url}")
    case Failure(exception) => println(s"Failed to read from ${url}")
  }
}

// Scala version of Python's: url_list = ["https://www.google.com","https://www.bing.com"]*50
val urls = List("http://localhost:8080/","http://localhost:8080/").map(new URL(_))
val urlList = LazyList.continually(urls)
  .flatten
  .take(100)
  .toList

val start = System.nanoTime()
Await.ready(Future.sequence(urlList.map(downloadLink)), Duration.Inf)
val end = System.nanoTime()
println(s"download ${urlList.length} links in ${(end - start) / 1000000000.0} seconds")

// If the ExecutionContext is not closed, the script won't exit.
ec.shutdown()