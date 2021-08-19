triangle_char = input('Enter a character: \n')

triangle_height = int(input('Enter triangle height: \n'))

for x in range(triangle_height):
    for y in range(x+1):
        print(triangle_char, end = ' ')
    print()
