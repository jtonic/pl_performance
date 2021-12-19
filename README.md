
See the performance [result](./results.md)

## How to run applications.

0. Start the HTTP server (ktor).

  ```shell
  $ cd perf_kt
  $ gradle :ktors:run
  ```

  Notes:
  > By default the latency of the endpoint is around `1 second`

1. __Python scripts__

    Use the vs-code [run configuration](perf_python/.vscode/launch.json), seen/configured automatically by vs code.

2. __JS application__

  ```shell
  $ cd perf_js
  $ nmp install
  $ npm start
  ```

3. __Rust application__

  ```shell
  $ cd perf_rust
  $ cargo build
  $ cargo run main
  ```

4. __Haskell application__

  ```shell
  $ cd PerfHaskell
  $ stack build --fast
  $ stack run PerfHaskell -- +RTS -N # using all cores
  $ stack run PerfHaskell -- +RTS -N2 # using two cores
  ```

5. __Java/Vert.x application__

6. __Kotlin application__

  - build the gradle multi project
  ```shell
  $ cd perf_kt
  $ gradle build
  ```

  - run ktor client (async with coroutines)
  ```shell
  $ gradle :ktorc:run
  ```

  - run http4k client (sync):
  ```shell
  $ gradle :http4kc:run
  ```



7. __Go application__

8. __Swift application__









