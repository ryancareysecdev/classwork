def output_without_whitespace(initialstring):
    newstring = initialstring.replace(' ', '')
    newstring = newstring.replace('\t', '')
    print('Without whitespaces:', newstring)

def get_num_of_characters(initialstring):
    count=0
    for i in range(len(initialstring)):
        count += 1
    return count

def main():
    initialstring = str(input('Enter a string: '))
    print('You entered: ', initialstring)
    print('Number of characters:', get_num_of_characters(initialstring))
    output_without_whitespace(initialstring)

main()
