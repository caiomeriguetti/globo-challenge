import requests
import socket
import time
from threading import Thread

import resource as res

res.setrlimit(res.RLIMIT_NOFILE,(30000,30000))

n = 10000

def opensock():
    print "criou thread"
    s = socket.socket(
    socket.AF_INET, socket.SOCK_STREAM)

    print "connecting"

    #s.connect(("localhost", 9443))
    #s.connect(("34.196.85.137", 9443))

    print "connected"

    while 1:
        time.sleep(1)

def main():
    threads = []
    for i in range(0, n):
        t = Thread(target=opensock)
        threads.append(t)
        t.start()

    for t in threads:
        t.join()


if __name__ == "__main__":
    main()
