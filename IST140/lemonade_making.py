def output_ingredients():
    print('Lemonade ingredients - yields', servings, 'servings')
    print(cups_lemon, 'cup(s) lemon juice')
    print(cups_water, 'cup(s) water')
    print(cups_agave, 'cup(s) agave nectar')

def output_gallons():
    print('Lemonade ingredients - yields', servings, 'servings')
    print((cups_lemon / 16), 'gallon(s) lemon juice')
    print((cups_water / 16), 'gallon(s) water')
    print((cups_agave / 16), 'gallon(s) agave nectar')

cups_lemon = float(input('Enter amount of lemon juice (in cups): \n'))
cups_water = float(input('Enter amount of water (in cups): \n'))
cups_agave = float(input('Enter amount of agave nectar (in cups): \n'))
servings = float(input('How many servings does this make? \n\n'))
    
output_ingredients()
# FIXME (2): Prompt user for desired number of servings. Convert and output the ingredients
new_servings = float(input('\nHow many servings would you like to make? \n\n'))
cups_lemon = cups_lemon * (new_servings / servings)
cups_water = cups_water * (new_servings / servings)
cups_agave = cups_agave * (new_servings / servings)
servings = new_servings
output_ingredients()
print()
# FIXME (3): Convert and output the ingredients from (2) to gallons
output_gallons()
   
