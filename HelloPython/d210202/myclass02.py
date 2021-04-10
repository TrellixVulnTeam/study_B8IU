class Dog:
    def __init__(self):
        self.power_bark = 0

    def teachFromHuman(self):
        self.power_bark += 1


class Bird(Dog):
    def __init__(self):
        super().__init__()
        self.power_fly = 0

    def exercise(self, power):
        self.power_fly += power


if __name__ == '__main__':
    dogBird = Bird()
    print(dogBird.power_bark, dogBird.power_fly)

    dogBird.teachFromHuman()
    dogBird.exercise(5)
    print(dogBird.power_bark, dogBird.power_fly)
