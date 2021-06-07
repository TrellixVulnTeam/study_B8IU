def solution(new_id):
    # 1단계
    new_id = new_id.lower()
    index = 0

    # 2단계
    while index < len(new_id):
        temp = ord(new_id[index])
        if ord('a') <= temp <= ord('z') or ord('0') <= temp <= ord('9') \
                or new_id[index] in ['-', '_', '.']:
            index += 1
            continue
        new_id = new_id[:index] + new_id[index + 1:]

    # 3단계
    index = 0
    while index < len(new_id) - 1:
        if new_id[index] == '.' and new_id[index + 1] == '.':
            new_id = new_id[:index] + new_id[index + 1:]
            continue
        index += 1

    # 4단계
    if len(new_id) != 0:
        if new_id[0] == '.':
            new_id = new_id[1:]
    if len(new_id) != 0:
        if new_id[len(new_id) - 1] == '.':
            new_id = new_id[:-1]

    # 5단계
    if len(new_id) == 0:
        new_id = 'a'

    # 6단계
    if len(new_id) >= 16:
        new_id = new_id[:15]
    if new_id[-1] == '.':
        new_id = new_id[:-1]

    # 7단계
    while len(new_id) < 3:
        new_id += new_id[len(new_id) - 1]

    return new_id
