from fastapi import FastAPI
from pydantic import BaseModel
from pymongo import MongoClient
from typing import List
from fastapi.encoders import jsonable_encoder

app = FastAPI()

uri = "mongodb+srv://demo:Demo_123@cluster0.w2hpa44.mongodb.net/?retryWrites=true&w=majority"
client = MongoClient(uri)
db = client.work


class Member(BaseModel):
    name:str
    roll_no: int
    course :str
    total_mark : int
    percentage:int
    status: str
@app.get("/api/member/findAll", response_model=List[Member])
def list_members():
    members = list(db["members"].find(limit=100))
    return members


@app.post("/api/member/create", response_model=List[Member])
def create_member(member: Member):
    member = jsonable_encoder(member)
    object_id = db["members"].insert_one(member)
    members = list(db["members"].find(limit=100))
    return members


@app.get("/api/member/findOne", response_model=Member)
def find_one(roll_no: int):
    members = db["members"].find_one({"roll_no": roll_no})
    return members


@app.put("/api/member/update")
def update_member(roll_no: int, results:Member ):
    member = jsonable_encoder(member)
    update_member = db["members"].update_one(
        {"roll_no": roll_no}, {"$set": member})
    return f"{roll_no} updated successfully"


@app.delete("/api/member/delete")
def delete_member(roll_no: int):
    delete_member = db["members"].delete_one({"roll_no": roll_no})
    return f"{roll_no} deleted successfully"
