import requests
import socket
import time
from threading import Thread

n = 10000

def opensock():
    s = socket.socket(
    socket.AF_INET, socket.SOCK_STREAM)

    s.connect(("localhost", 9443))

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

    whi

if __name__ == "__main__":
    main()
