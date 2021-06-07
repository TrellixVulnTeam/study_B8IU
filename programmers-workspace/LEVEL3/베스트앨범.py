def solution(genres, plays):
    answer = []

    genresdict = dict()
    genresrank = dict()

    for index, (genre, play) in enumerate(zip(genres, plays)):
        if genre in genresdict:
            genresdict[genre].append((play, -index,index))
            genresrank[genre] += play
        else:
            genresdict[genre] = [(play, -index, index)]
            genresrank[genre] = play
    genresrank = [(value, key) for key, value in genresrank.items()]
    genresrank.sort(reverse=True)

    for _, genre in genresrank:
        gen = genresdict[genre]
        gen.sort(reverse=True)
        print(gen)
        if len(gen) == 1:
            answer.extend(list(zip(*gen))[2])
        else:
            answer.extend(list(zip(*gen))[2][:2])
    return answer


if __name__ == '__main__':
    print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
    print(solution(['A', 'A', 'B', 'A'], [5, 5, 6, 5]))
    print(solution(["classic", "pop", "classic", "pop", "classic", "classic"], [400, 600, 150, 2500, 500, 500]))
