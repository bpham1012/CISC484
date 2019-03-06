import csv
import math

with open('data_sets1/training_set.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=",")
    csv_file.readline()
    totalInstances = 0
    negInstances = 0
    posInstances = 0
    for row in csv_reader:
        # print(row)
        totalInstances += 1
        # print(row[-1])
        if row[-1] == '0': #count negative instances
            # print('hehe')
            negInstances += 1
        elif row[-1] == '1': #count positive instances
            posInstances += 1

# print(negInstances)
# print(posInstances)


#Calculate initial entropy
def calcEntropy(negInst, posInst):
    p0 = negInst/totalInstances
    p1 = posInst/totalInstances
    # print(p0)
    # print(p1)
    entropy = (-p0) * math.log(p0,2.00) + (-p1) * math.log(p1,2.00)
    return entropy

print (calcEntropy(negInstances, posInstances))

