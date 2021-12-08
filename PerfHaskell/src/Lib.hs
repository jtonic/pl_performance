{-# LANGUAGE OverloadedStrings #-}

module Lib
  ( downloadAllConc
  , downloadAllSync
  ) where

import           Control.Concurrent   (forkIO)
import           Control.Lens

import           Data.ByteString.UTF8 (toString)
import           Network.Wreq
import           RIO                  (IO, Int, IsString (fromString),
                                       Monad (return, (>>)), Semigroup ((<>)),
                                       Show (show), concat, forConcurrently_,
                                       forM_, replicate, tshow, ($))
import           RIO.ByteString       as RBS hiding (concat, pack, replicate)
import           RIO.ByteString.Lazy  (putStrLn, toStrict)
import           Say                  (say)
import           System.TimeIt        (timeItNamed)

type URL = ByteString

downloadAllConc :: Int -> [URL] -> IO ()
downloadAllConc n xs = forConcurrently_ (urls n xs) downloadLink

downloadAll' :: Int -> [URL] -> IO ()
downloadAll' n xs = forM_ (urls n xs) downloadLink

downloadAllSync :: Int -> [URL] -> IO ()
downloadAllSync n xs =
  timeItNamed "Execution time: " $ forM_ (urls n xs) downloadLinkSync

urls :: Int -> [URL] -> [URL]
urls n xs = concat $ replicate n xs

downloadLink :: URL -> IO ()
downloadLink url = do
  _ <- forkIO $ action url
  return ()

downloadLinkSync :: URL -> IO ()
downloadLinkSync url = do
  getUrl url
  -- (t, _) <- timeItT $ getUrl url
  -- S.putStr $ show t <> " sec -> "
  -- return ()

action :: URL -> IO ()
action url = say $ "Calling " <> tshow url <> "..."

-- >>> RIO.length "Hello"
-- 5
getUrl :: URL -> IO ()
getUrl url = do
  r <- get $ toString url
  let body = toStrict $ r ^. responseBody
  let size = RBS.length body
  let msg = "Read " <> fromString (show size) <> " from " <> url
  RBS.putStr msg >> putStrLn ""
{-

>>> getUrl "https://www.bing.com"

>>> urls 2 ["https://www.google.com","https://www.bing.com"]
["https://www.google.com","https://www.bing.com","https://www.google.com","https://www.bing.com"]

-}
