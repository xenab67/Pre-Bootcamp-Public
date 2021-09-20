#BASICS
for x in range(150):
    print (x)

#MULTIPLES OF FIVE
for x in range(5, 1000):
    if (x%5 == 0):
        print (x)

#COUNTING, THE DOJO WAY
for x in range(1, 100):
    if (x%5 == 0):
        print ("Coding")
    if (x%10 == 0):
        print ("Dojo")
    else:
        print (x)

#ADD ODD INTEGERS B/W 1 AND 500,000
sum=0
for i in range (1, 500000, 2):
    sum+=i
    print (sum)

#COUNTDOWN BY 4
for x in range (2018, 0, -4):
    if (x%2==0):
        print (x)

#FLEXIBLE COUNTER
low = 2
high = 9
mult = 3

for i in range(low,high + 1):
    if i % mult == 0:
        print(i)


