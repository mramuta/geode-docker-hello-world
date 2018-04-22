#!/usr/bin/env bash

gfsh run --file=/geode/setup/config-geode.sh
tail -f /server/*.log