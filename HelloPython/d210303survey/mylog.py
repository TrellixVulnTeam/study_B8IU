import logging


class MyLog:
    _instance = None

    @classmethod
    def _getInstance(cls):
        return cls._instance

    @classmethod
    def instance(cls):
        cls._instance = cls()
        cls.instance = cls._getInstance
        return cls._instance

    def __init__(self):
        formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')

        self.logger = logging.getLogger('MyLog')
        self.logger.setLevel(logging.DEBUG)

        # 콘솔 출력을 지정합니다
        ch = logging.StreamHandler()
        ch.setFormatter(formatter)

        # 파일 출력을 지정합니다.
        fh = logging.FileHandler(filename="MyLog.log")
        fh.setFormatter(formatter)

        # add ch to logger
        self.logger.addHandler(ch)
        self.logger.addHandler(fh)
        self.logger.propagate = 0


# class MyLog:
#     def __init__(self):
#         formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
#
#         self.logger = logging.getLogger('MyLog')
#         self.logger.setLevel(logging.DEBUG)
#
#         # 콘솔 출력을 지정합니다
#         ch = logging.StreamHandler()
#         ch.setFormatter(formatter)
#
#         # 파일 출력을 지정합니다.
#         fh = logging.FileHandler(filename="MyLog.log")
#         fh.setFormatter(formatter)
#
#         # add ch to logger
#         self.logger.addHandler(ch)
#         self.logger.addHandler(fh)
#         self.logger.propagate = 0
# formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
#
# logger = logging.getLogger('MyLog')
# logger.setLevel(logging.DEBUG)
#
# # 콘솔 출력을 지정합니다
# ch = logging.StreamHandler()
# ch.setFormatter(formatter)
#
# # 파일 출력을 지정합니다.
# fh = logging.FileHandler(filename="MyLog.log")
# fh.setFormatter(formatter)
#
# # add ch to logger
# logger.addHandler(ch)
# logger.addHandler(fh)


if __name__ == '__main__':
    riri = MyLog()
    riri.logger.warning('message')
