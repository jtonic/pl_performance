module Main where

import           Control.Concurrent (getNumCapabilities)
import           Lib
import           RIO
import           System.IO          (putStrLn)

main :: IO ()
main = do
  ths <- getNumCapabilities
  putStrLn $ "Number of cores: " <> show ths
  downloadAllSync 50 ["https://www.google.com", "https://www.bing.com"]
  -- downloadAllConc 10 ["https://www.google.com", "https://www.bing.com"]
