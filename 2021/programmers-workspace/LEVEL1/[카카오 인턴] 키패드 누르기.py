def solution(numbers, hand):
    answer = ''
    hand_position_l = 10
    hand_position_r = 11
    keypad_dict = {2: [3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4],
                   5: [2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3],
                   8: [1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2],
                   0: [0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1]}
    for i in numbers:
        if i == 1 or i == 4 or i == 7:
            answer += 'L'
            hand_position_l = i
        elif i == 3 or i == 6 or i == 9:
            answer += 'R'
            hand_position_r = i
        else:
            if keypad_dict[i][hand_position_l] < keypad_dict[i][hand_position_r]:
                answer += 'L'
                hand_position_l = i
            elif keypad_dict[i][hand_position_l] > keypad_dict[i][hand_position_r]:
                answer += 'R'
                hand_position_r = i
            elif hand == "left":
                answer += 'L'
                hand_position_l = i
            else:
                answer += 'R'
                hand_position_r = i

    return answer
