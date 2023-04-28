from pymongo import MongoClient
uri = "mongodb+srv://demo:Demo_123@cluster0.w2hpa44.mongodb.net/?retryWrites=true&w=majority"
client = MongoClient(uri)
db = client.college
students = list (db["students"].find(limit = 100))
print(students)