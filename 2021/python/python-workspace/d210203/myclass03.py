class Dog:
    def __init__(self):
        self.power_bark = 0

    def teachFromHuman(self):
        self.power_bark += 1


class Bird:
    def __init__(self):
        self.power_fly = 0

    def exercise(self, power):
        self.power_fly += power


class DogBird(Dog, Bird):
    def __init__(self):
        Dog.__init__(self)
        Bird.__init__(self)


if __name__ == '__main__':
    dogBird = DogBird()
    print(dogBird.power_bark, dogBird.power_fly)

    dogBird.teachFromHuman()
    dogBird.exercise(5)
    print(dogBird.power_bark, dogBird.power_fly)
