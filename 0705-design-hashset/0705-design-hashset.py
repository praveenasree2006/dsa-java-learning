class MyHashSet(object):
    def __init__(self):
        self.a = [False] * 1000001

    def add(self, key):
        self.a[key] = True

    def remove(self, key):
        self.a[key] = False

    def contains(self, key):
        return self.a[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)