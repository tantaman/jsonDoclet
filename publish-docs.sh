#!/usr/bin/env bash

find $1 -type f -print0 | xargs -0 -P 10 -i% curl -XPOST $2 --data @%
