import math
import matplotlib.pyplot as plt

def c(n):
    calls = 0
    for j in range(1, n + 1):
        if j ** 2 <= n:
            for k in range(j, n + 1):
                calls += 3
    return calls

def a(n):
    calls = 0
    for j in range(1, n + 1):
        for k in range(1, n + 1):
            for m in range(1, n + 1):
                calls += 1
    return calls

def b(n):
    calls = 0
    for j in range(1, n + 1):
        k = min(j, 100)
        for l in range(1, k + 1):
            calls += 1
    return calls

def d(n):
    calls = 0
    for j in range(1, n + 1):
        k = 1
        l = 0
        while k <= j:
            for m in range(l + 1):
                calls += 1
            k = 13 * k
            l += 1
    return calls

if __name__ == '__main__':
    xaxis = []
    yaxis = []
    yref = []
    for i in range(1, 1000000, 100000):
        print(i)
        xaxis.append(i)
        yaxis.append(d(i))

        yref.append(0.7 * i * math.pow(math.log(i, 13), 2))

    plt.plot(xaxis, yaxis, label='f')
    plt.plot(xaxis, yref, label='ref')
    plt.legend(loc='upper left')
    plt.show()