#!/bin/bash

download_all() {
    for ((i=1; i<=50; i++))
    do
        urls=("https://www.google.com"  "https://www.bing.com")
        for value in ${urls[*]}
        do
            echo "[$i] read from $value"
            curl $value  > /dev/null 2> /dev/null
        done
    done
}

time download_all
