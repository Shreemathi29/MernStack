from fastapi import FastAPI
from pydantic import BaseModel
from datetime import date

app = FastAPI()

class Dt3(BaseModel):
    name: str
    email: str
    password: str
    dob: date

members = {
    1: {
        "name": "shree",
        "email": "shree@demo.com",
        "password": "mathi@1239",
        "dob": "2001/04/29"
    },
    2: {
        "name": "Indhu",
        "email": "indhu@demo.com",
        "password": "indhuja@1239",
        "dob": "2000/08/22"
    },
    3: {
        "name": "Naveen",
        "email": "naveen@dt3.com",
        "password": "sample@12345",
        "dob": "2001/08/12"
    },
    4: {
        "name": "Sonu",
        "email": "sonu@dt3.com",
        "password": "sonubabu@12345",
        "dob": "2000/05/10"
    },
    5: {
        "name": "Shruthi",
        "email": "shruthi@dt3.com",
        "password": "shruthi@12345",
        "dob": "2001/04/08"
    },
    6: {
        "name": "Swetha",
        "email": "swetha@dt3.com",
        "password": "swetha@12345",
        "dob": "2001/06/22"
    },
    7: {
        "name": "Venkat",
        "email": "venkat@dt3.com",
        "password": "venkat@12345",
        "dob": "2001/04/07"
    },
    8: {
        "name": "Ishwariya",
        "email": "Ishu@dt3.com",
        "password": "ishu@12345",
        "dob": "2001/11/13"
    }
}


@app.get("/api/members/get_details")
def get_details():
    return members

@app.post("/api/members/create")
def create_member(new_member: Dt3):
    member_id = max(members.keys())+1
    members[member_id] = new_member.dict()
    return members
@app.put("/api/members/{member_id}")
def update_member(member_id: int, update_member:Dt3):
    member = members[member_id]
    member["name"] = update_member.name
    member["email"] = update_member.email
    member["password"] = update_member.password
    member["dob"] = update_member.dob
    return members
@app.delete("/api/member/{user_id}")
def delete_user(member_id: int):
    del members[member_id]
    return members

#@app.get("/")
#def reg():
 #return "hello world"