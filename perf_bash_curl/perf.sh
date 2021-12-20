#!/bin/bash

download_all() {
    for ((i=1; i<=50; i++))
    do
        urls=("http://localhost:8080/"  "http://localhost:8080/")
        for value in ${urls[*]}
        do
            echo "[$i] read from $value"
            curl $value  > /dev/null 2> /dev/null
        done
    done
}

time download_all
