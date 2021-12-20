## **Application**

---

1. heavily IO bound: `100 HTTP calls` to both "http://localhost:8080/" (50) and "http://localhost:8080/" (50)

**Target:**

- How easy is to:
  - get up to speed with a new language
  - (more important) get the most performant application with the `for the impatient` approach
  - (and in the end) the following matters: performance (70%), conciseness (5), readability (10) and developer experience (15)

## <span style="color:green">**Bash script**</span>

---

**Notes:**

1. Sync with **cURL**: `29.947` seconds

## <span style="color:green">**Python**</span>

---

**Notes:**

> Examples from https://python.plainenglish.io/send-http-requests-as-fast-as-possible-in-python-304134d46604

1. Sync with **requests**: `115.76` seconds

2. Sync with **requests** and tcp connections pool: `117.82` seconds

3. Async with **threads** and **queue**: `12.25` seconds

4. Async with **ThreadPoolExecutor**: `12.25` seconds

5. Async with **asyncio** and **aiohttp**: `11.78` seconds

   **Rating:**

   - Developer experience: 4
   - Performance:
     - sync: 3
     - async: 5

## <span style = "color:green">**JavaScript / Node**</span>

---

1. async/await (with request package): `to be updated and rerun` seconds

## <span style="color:green">**Scala**</span>

---

**Notes:**

> Examples from https://gist.github.com/hohonuuli/7ebfd438f297ef3ee7fc843920936ba9

1. Async with scala.concurrent.ExecutionContext: `to be updated and rerun` seconds

## <span style="color:orange">**Haskell**</span>

---

1. Sync with wreq (lens): `to be updated and rerun` seconds

   **Rating:**

   - Developer experience: 2
   - Performance:
     - sync: 1
     - async: n/a

## <span style="color:orange">**Rust**</span>

---

1. async and wreq packages : **TBD**

## **Kotlin**

---

1. sync with http4k: `115,27` seconds

2. async with ktor client (OkHttp): `23,63` seconds

## Java / Vert.x

---

## [Optional] GO

---

## [Optional] Swift

---

| Language  | Parcon | Technologies                   | Latency (sec) | Rating |
| --------- | ------ | ------------------------------ | ------------- | ------ |
| scala     | async  | BufferedInputStream/Future     | 5.71          |        |
| js        | async  | node/request/promise           | 10.09         |        |
| python    | async  | request, threads, queue        | 11.37         |        |
| python    | async  | asyncio, aiohttp               | 11.40         |        |
| python    | async  | requests, thread pool executor | 11.48         |        |
| kotlin    | async  | ktor client                    | 22,633        |        |
| python    | sync   | requests                       | 113.72        |        |
| python    | sync   | request & tpc conn pool        | 114.01        |        |
| kotlin    | sync   | http4k                         | 115,27        |        |
| haskell   | sync   | Wreq                           | 123.65        |        |
| bash/cURL | sync   |                                | 172.03        |        |
| java      | async  | Vert.x                         |               |        |
| rust      |        |                                |               |        |
| swift     |        |                                |               |        |
| go        |        |                                |               |        |
