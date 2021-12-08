
See the performance [result](./results.md)

## How to run applications.


1. __Python scripts__

    Use the vs-code [run configuration](perf_python/.vscode/launch.json), seen/configured automatically by vs code.

2. __JS application__

  ```shell
  $ cd to perf_js
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

7. __Go application__

9. __Swift application__









