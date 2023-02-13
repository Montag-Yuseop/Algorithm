import random

lines = []

T = 3
lines.append(f'{T}')
for tc in range(1, T+1):
    N = random.randint(1, 100)
    M = random.randint(1, 100)
    K = random.randint(1, 100)
    lines.append(f'{N} {M} {K}')

    arr = []
    for _ in range(N):
        num = random.randint(0, 11111)
        arr.append(f'{num}')
    
    lines.append(" ".join(arr))

print("\n".join(lines))