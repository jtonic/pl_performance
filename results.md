

## __Application__
---

1. heavily IO bound: `100 HTTP calls` to both "http://localhost:8080/" (50) and "http://localhost:8080/" (50)

__Target:__
- How easy is to:
  - get up to speed with a new language
  - (more important) get the most performant application with the `for the impatient` approach
  - (and in the end) the following matters: performance (70%), conciseness (5), readability (10) and developer experience (15)

## <span style="color:green">__Bash script__</span>
---

__Notes:__

1. Sync with __cURL__: `29.947` seconds

## <span style="color:green">__Python__</span>
---

__Notes:__

> Examples from https://python.plainenglish.io/send-http-requests-as-fast-as-possible-in-python-304134d46604


1. Sync with __requests__: `115.76` seconds

2. Sync with __requests__ and tcp connections pool: `117.82` seconds

3. Async with __threads__ and __queue__: `12.25` seconds

4. Async with __ThreadPoolExecutor__: `12.25` seconds

5. Async with __asyncio__ and __aiohttp__: `11.78` seconds


    __Rating:__
    - Developer experience: 4
    - Performance:
      - sync: 3
      - async: 5


## <span style = "color:green">__JavaScript / Node__</span>
---

1. async/await (with request package):  `to be updated and rerun` seconds

## <span style="color:green">__Scala__</span>
---

__Notes:__

> Examples from https://gist.github.com/hohonuuli/7ebfd438f297ef3ee7fc843920936ba9


1. Async with scala.concurrent.ExecutionContext: `to be updated and rerun` seconds

## <span style="color:orange">__Haskell__</span>
---

1. Sync with wreq (lens):  `to be updated and rerun` seconds

    __Rating:__
    - Developer experience: 2
    - Performance:
      - sync: 1
      - async: n/a

## <span style="color:orange">__Rust__</span>
---

1. async and wreq packages : __TBD__


## __Kotlin__
---

1. sync with http4k: `116,47` seconds

2. async with ktor client (OkHttp): `23,47` seconds

## Java / Vert.x
---

## [Optional] GO
---

## [Optional] Swift
---
