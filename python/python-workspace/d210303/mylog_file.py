import logging

logger = logging.getLogger('simple_example')
logger.setLevel(logging.DEBUG)

# 콘솔 출력을 지정합니다
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)

# 파일 출력을 지정합니다.
fh = logging.FileHandler(filename="../d210303log/run.log")
fh.setLevel(logging.DEBUG)

# add ch to logger
logger.addHandler(ch)
logger.addHandler(fh)

logger.debug("debug")
logger.info("info")
logger.warning("warning")
logger.error("error")
logger.critical("critical")
