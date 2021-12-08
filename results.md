

## __Application__
---

1. bare (IO bound): `100 HTTP calls` to both "https://www.google.com" (50) and "https://www.bing.com" (50)
2. later on: ...

__Target:__
- How easy is to:
  - get up to speed with a new language
  - (more important) get the most performant application with the `for the impatient` approach
  - (and in the end) the following matters: performance (70%), conciseness (5), readability (10) and developer experience (15)

## <span style="color:green">__Python__</span>
---

__Notes:__

> Examples from https://python.plainenglish.io/send-http-requests-as-fast-as-possible-in-python-304134d46604


1. Sync with __requests__: `24.13224196434021` seconds

2. Sync with __requests__ and tcp connections pool: `17.942963123321533` seconds

3. Async with __threads__ and __queue__: `2.560472011566162` seconds

4. Async with __ThreadPoolExecutor__: `2.5277481079101562` seconds

5. Async with __asyncio__ and __aiohttp__: `1.285111904144287` seconds


    __Rating:__
    - Developer experience: 4
    - Performance:
      - sync: 3
      - async: 5


## <span style = "color:green">__JavaScript / Node__</span>
---

1. async/await (with request package):  `7.157` seconds

## <span style="color:green">__Scala__</span>
---

__Notes:__

> Examples from https://gist.github.com/hohonuuli/7ebfd438f297ef3ee7fc843920936ba9


1. Async with scala.concurrent.ExecutionContext: `1.302314285` seconds

## <span style="color:orange">__Haskell__</span>
---

1. Sync with wreq (lens):  `41.81` seconds

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

## Java / Vert.x
---

## [Optional] GO
---

## [Optional] Swift
---
