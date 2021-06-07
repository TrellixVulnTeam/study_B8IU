import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import axes3d, Axes3D  # <-- Note the capitalization!

fig = plt.figure()
ax = fig.gca(projection='3d')  # 보여줄 방식을 3d로 설정합니다.

ax.set_zlabel('Z')
ax.set_ylabel('Y')
ax.set_xlabel('X')

x = [0, 0, 0, 0, 0]
y = [0, 1, 2, 3, 4]
z = [1, 2, 1, 3, 1]

ax.plot(x, y, z)  # y축의 2에 해당하는 위치에 2차원 그래프를 출력합니다.

plt.show()
