#!/usr/bin/env bash

start locator --dir=locator --jmx-manager-hostname-for-clients=localhost
start server --dir=server
create region --name=hello --type=REPLICATE