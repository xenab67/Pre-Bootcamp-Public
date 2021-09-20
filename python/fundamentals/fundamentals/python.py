
num1 = 42 # variable declaration, number initialized
num2 = 2.3 # variable declaration, decimal/float initialized
boolean = True # variable declaration, boolean initialized
string = 'Hello World' # variable declaration, string initialized

# variable declaration, list initialized
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives']

# variable declaration, dictionary initialized
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False}

# variable declaration, tuple initialized
fruit = ('blueberry', 'strawberry', 'banana')
# print to console, type check
print(type(fruit))

# print to console, List access value
print(pizza_toppings[1])

#list add value
pizza_toppings.append('Mushrooms')

# print to console, Dictionary access value
print(person['name'])

# Dictionary change value
person['name'] = 'George'
# Dictionary change value
person['eye_color'] = 'blue'

# print to console, Tuple access data
print(fruit[2])

# Conditional if, evaluation, print to console, Conditional else, print to console
if num1 > 45:
    print("It's greater")
else:
    print("It's lower")

# Conditional if - elif - else, print to console.
if len(string) < 5:
    print("It's a short word!")
elif len(string) > 15:
    print("It's a long word!")
else:
    print("Just right!")

# For Loop start at 0 and goes up to until 5
for x in range(5):
    print(x)
# For Loop start at 2 and goes up to until 5
for x in range(2,5):
    print(x)
# For loop start at 2 goes up to until 10, increments by 3
for x in range(2,10,3):
    print(x)

#While Loop, variblae declaration
x = 0
while(x < 5):
    # printing to console
    print(x)
    # incrementing x
    x += 1

# List delete value at end
pizza_toppings.pop()
# list delete value at index
pizza_toppings.pop(1)

# print to console of dictionary
print(person)
# Dictionary delete value
person.pop('eye_color')
#print to console of dictionary
print(person)

# for loop through a list
for topping in pizza_toppings:
    #Conditional if
    if topping == 'Pepperoni':
        # Conintues
        continue
    # print to console
    print('After 1st if statement')
    # Conditional if
    if topping == 'Olives':
        # stops the loop
        break

# function declaration
def print_hello_ten_times():
    # for loop starts at 0 goes up until 10
    for num in range(10):
        # print to console
        print('Hello')

# Function Call
print_hello_ten_times()

# function Declaration with parameter x
def print_hello_x_times(x):
    # For loop up until a given number x
    for num in range(x):
        # print to console
        print('Hello')

# function call arguement of 4
print_hello_x_times(4)

# function declaration with default parameter
def print_hello_x_or_ten_times(x = 10):
    # For loop until x
    for num in range(x):
        # print to console
        print('Hello')

# Function call goes to 10
print_hello_x_or_ten_times()
# function call goes to 4
print_hello_x_or_ten_times(4)

#Numbers:

print(type(24))
print(type(3.9))
print(type(3j))


int_to_float = float(35)
float_to_int = int(44.2)
int_to_complex = complex(35)
print(int_to_float)
print(float_to_int)
print(int_to_complex)
print(type(int_to_float))
print(type(float_to_int))
print(type(int_to_complex))

import random
print(random.randint(2,5)) # provides a random number between 2 and 5

#Strings:

print("this is a sample string")

name = "Zen"
print("My name is", name)

name = "Zen"
print("My name is " + name)

print("Hello" + 42)			# output: TypeError
print("Hello" + str(42))		# output: Hello 42

total = 35
user_val = "26"
total = total + user_val		# output: TypeError
total = total + int(user_val)		# total will be 61

first_name = "Zen"
last_name = "Coder"
age = 27
print(f"My name is {first_name} {last_name} and I am {age} years old.")

first_name = "Zen"
last_name = "Coder"
age = 27
print("My name is {} {} and I am {} years old.".format(first_name, last_name, age))
# output: My name is Zen Coder and I am 27 years old.
print("My name is {} {} and I am {} years old.".format(age, first_name, last_name))
# output: My name is 27 Zen and I am Coder years old.

"""
String Methods:
string.upper(): returns a copy of the string with all the characters in uppercase.
string.lower(): returns a copy of the string with all the characters in lowercase.
string.count(substring): returns number of occurrences of substring in string.
string.split(char): returns a list of values where string is split at the given character. Without a parameter the default split is at every space.
string.find(substring): returns the index of the start of the first occurrence of substring within string.
string.isalnum(): returns boolean depending on whether the string's length is > 0 and all characters are alphanumeric (letters and numbers only). Strings that include spaces and punctuation will return False for this method. Similar methods include .isalpha(), .isdigit(), .islower(), .isupper(), and so on. All return booleans.
string.join(list): returns a string that is all strings within our set (in this case a list) concatenated.
string.endswith(substring): returns a boolean based upon whether the last characters of string match substring.
"""

#lists
ninjas = ['Rozen', 'KB', 'Oliver']
my_list = ['4', ['list', 'in', 'a', 'list'], 987]
empty_list = []

fruits = ['apple', 'banana', 'orange', 'strawberry']
vegetables = ['lettuce', 'cucumber', 'carrots']
fruits_and_vegetables = fruits + vegetables
print(fruits_and_vegetables)
salad = 3 * vegetables
print(salad)

drawer = ['documents', 'envelopes', 'pens']
#access the drawer with index of 0 and print value
print(drawer[0])  #prints documents
#access the drawer with index of 1 and print value
print(drawer[1]) #prints envelopes
#access the drawer with index of 2 and print value
print(drawer[2]) #prints pens

x = [1,2,3,4,5]
x.append(99)    #Appends a new item onto the end of the given list. You can pass any data type into this function.
print(x)
#the output would be [1,2,3,4,5,99]

x = [99,4,2,5,-3]
print(x[:])
#the output would be [99,4,2,5,-3]
print(x[1:])
#the output would be [4,2,5,-3];
print(x[:4])
#the output would be [99,4,2,5]
print(x[2:4])
#the output would be [2,5];

my_list = [1, 'Zen', 'hi']
print(len(my_list))
# output
3

"""Sequence functions:
enumerate(sequence) used in a for loop context to return two-item-tuple for each item in the list indicating the index followed by the value at that index.
map(function, sequence) applies the function to every item in the sequence you pass in. Returns a list of the results.
min(sequence) returns the lowest value in a sequence.
sorted(sequence) returns a sorted sequence"""

my_list = [1,5,2,8,4]
my_list.append(7)
print(my_list)
# output:
# [1,5,2,8,4,7]

"""
list.extend(list2) adds all values from a second sequence to the end of the original sequence.
list.pop(index) remove a value at given position. if no parameter is passed, defaults to final value in the list.
list.index(value) returns the index position in a list for the given parameter.
"""

#Tuples
tuple_data = ('physics', 'chemistry', 1997, 2000)
tuple_num = (1, 2, 3, 4, 5 )
tuple_letters = "a", "b", "c", "d"

dog = ("Canis Familiaris", "dog", "carnivore", 12)
print(dog[2])
#result is: carnivore

dog[0] = "X"
#TypeError: 'tuple' object does not support item assignment

dog = dog + ("domestic",)
#result is...
#("Canis Familiaris", "Dog", "carnivore", 12, "domestic")

dog = dog[:3] + ("man's best friend",) + dog[4:]
#result is...
#("Canis Familiaris", "Dog", "carnivore", "man's best friend", "domestic")

x = (1,5,6,9,2)
print(len(x))
# output:
# 5

"""
max(sequence) returns the largest value in the sequence
sum(sequence) return the sum of all values in sequence
enumerate(sequence) used in a for-loop context to return two-item-tuple for each item in the sequence indicating the index followed by the value at that index.
map(function, sequence) applies the function to every item in the sequence you pass in. Returns a list of the results.
min(sequence) returns the lowest value in a sequence.
sorted(sequence) returns a sorted sequence
"""
def get_circle_area(r):
    #Return (circumference, area) of a circle of radius r
    c = 2 * math.pi * r
    a = math.pi * r * r
    return (c, a)

#Dictionaries
weekend = {"Sun": "Sunday", "Sat": "Saturday"} #literal notation
capitals = {} #create an empty dictionary then add values
capitals["svk"] = "Bratislava"
capitals["deu"] = "Berlin"
capitals["dnk"] = "Copenhagen"
"""
Using literal notation. The key-value pairs are enclosed by curly brackets. The pairs are separated by commas. The first value of a pair is a key, which is followed by a colon character and a value. The "Sun" string is a key and the "Sunday" string is a value.

Creating empty dictionary and adding some values. The keys are inside the square brackets, the values are located on the right side of the assignment.

Each key in a dictionary must be unique. If you make an assignment using an existing key as the index, the old value associated with that key is overwritten by the new value. You can use this characteristic to an advantage in order to modify an existing value for an existing key.
"""

print(weekend["Sun"])
print(capitals["svk"])

value_removed = capitals.pop('svk') # will remove the key 'svk' and return it's value
del capitals['dnk'] # will delete the key, and not return anything

"""
context = {
    'questions': [
        { 'id': 1, 'content': 'Why is there a light in the fridge and not in the freezer?'},
        { 'id': 2, 'content': 'Why don\'t sheep shrink when it rains?'},
        { 'id': 3, 'content': 'Why are they called apartments when they are all stuck together?'},
        { 'id': 4, 'content': 'Why do cars drive on the parkway and park on the driveway?'}
   ]
}

Python includes the following standalone functions for dictionaries:

cmp(dict1, dict2) - Compares two dictionaries. The comparison process starts with the length of each dictionary, followed by key names, followed by values. The function returns 0 if the two dicts are equal, -1 if dict1 > dict2, 1 if dict1 < dict2.
len() - give the total length of the dictionary.
str() - produces a string representation of a dictionary.
type() - returns the type of the passed variable. If passed variable is a dictionary, it will then return a dict type.

Python includes the following dictionary methods:
(either dict.method(yourDictionary) or yourDictionary.method() will work)

.clear() - removes all elements from the dictionary
.copy() - returns a shallow copy dictionary
.fromkeys(sequence, [value] ) - create a new dictionary with keys from sequence and values set to value.
.get(key, default=None) - For key key, returns value or default if key is not in dictionary.
.has_key(key) - returns true if a given key is available in the dictionary, otherwise it returns false.
.items() - returns a list of dictionary's (key, value) tuple pairs.
.keys() - return a list of dictionary keys.
.setdefault(key, default=None) - similar to get(), but will set dict[key]=default if key is not already in dictionary.
.update(dict2) = adds dictionary dict2's key-values pairs to an existing dictionary.
.values() - returns list of dictionary values.

"""