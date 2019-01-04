#!/bin/bash

ulimit -n 30000
ulimit -u 100000

python 10k.py
