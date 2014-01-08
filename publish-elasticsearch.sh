#!/usr/bin/env bash

# Usage
# publish-elasticsearch.sh doc_path elasticsearch_endpoint
#
# Example:
# ./publish-elasticsearch.sh path/to/docs http://localhost:9200/docs/classes
#
# This will grab all docs in path/to/docs and publish them to the docs index with the classes type.
# the id of each doc will be its fully qualified class name.

find $1 -type f -name *.json -print0 | rev | cut -c6- | rev | tr -d '\n' | xargs -0 -p 10 -i% curl -XPOST $2/% --data @%.json
