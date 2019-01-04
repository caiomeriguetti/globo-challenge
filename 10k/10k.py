import requests
from threading import Thread

report = {
    "200": 0,
    "not200": 0
}

n = 10000
k = 0
w = 0

def req():
    global k

    r = requests.get('https://localhost:9443/public/sleep', verify=False)
    if r.status_code == 200:
        report["200"] += 1
    else:
        report["not200"] +=1

    k += 1

    print float(k)/float(n)


def main():
    threads = []
    for i in range(0, n):
        t = Thread(target=req)
        threads.append(t)

        t.start()

    for t in threads:
        t.join()

    print report


if __name__ == "__main__":
    main()
