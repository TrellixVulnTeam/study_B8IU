def solution(skill, skill_trees):
    answer = 0

    for skill_tree in skill_trees:
        isPossible = True
        for i in range(len(skill) - 1):
            if skill[i] not in skill_tree and skill[i + 1] in skill_tree:
                isPossible = False
                break
            if skill[i] in skill_tree and skill[i + 1] in skill_tree:
                if skill_tree.index(skill[i]) > skill_tree.index(skill[i + 1]):
                    isPossible = False

        if isPossible:
            answer += 1

    return answer
