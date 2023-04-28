from fastapi import FastAPI
from pydantic import BaseModel
from pymongo import MongoClient
from typing import List
from fastapi.encoders import jsonable_encoder

app = FastAPI()
uri = "mongodb+srv://demo:Demo_123@cluster0.w2hpa44.mongodb.net/?retryWrites=true&w=majority"
client = MongoClient(uri)
db = client.school

class Result(BaseModel):
    name:str
    roll_no: int
    course :str
    total_mark : float
    percentage:float
    result: str
    

@app.get("/api/result/findAll", response_model=List[Result])
def list_result():
    students = list (db["result"].find(limit = 100))
    return students
@app.post("/api/result/create", response_model=List[Result])
def create_result(result:Result):
    result = jsonable_encoder(result)
    object_id =db["result"].insert_one(result)
    result = list (db["result"].find(limit = 100))
    return result

@app.get("/api/result/findOne", response_model=List[Result])
def find_result(result:Result):
    result =db["result"].find_one(result)
    return result

@app.put("/api/result/update")
def update_result(roll_no: int, student:Result):
    result = jsonable_encoder(result)
    update_result = db["result"].update_one(
        {"roll_no":roll_no},{"$set":result})
    return f"{roll_no} updated sucessfully"


@app.delete("/api/result/delete")
def delete_result(roll_no: int):
    delete_result =db["result"].delete_one({"roll_no": roll_no})
    return f"{roll_no} deleted sucessfully"
