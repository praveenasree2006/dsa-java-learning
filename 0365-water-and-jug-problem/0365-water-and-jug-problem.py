class Solution:
    def canMeasureWater(self, x: int, y: int, target: int) -> bool:
        if target > x + y:
            return False
        if target == 0 or x == target or y == target or x + y == target:
            return True

        queue = deque([(0, 0)])
        visited = {(0, 0)}

        while queue:
            i, j = queue.popleft()
            if i + j == target or i == target or j == target:
                return True

            for next_i, next_j in [(x, j),
                                   (i, y),
                                   (0, j),
                                   (i, 0),
                                   (i - min(i, y - j), j + min(i, y - j)),
                                   (i + min(j, x - i), j - min(j, x - i))]:
                if (next_i, next_j) in visited:
                    continue
                visited.add((next_i, next_j))
                queue.append((next_i, next_j))
        return False