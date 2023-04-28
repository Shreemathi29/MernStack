from fastapi import FastAPI
from fastapi.responses import HTMLResponse
from fastapi import Request
from fastapi.templating import Jinja2Templates
from fastapi import Form
from fastapi import File
app = FastAPI()
templates = Jinja2Templates(directory="templates")



@app.post("/register") #http://127.0.0.1:8000/register/
def user(name: str = Form(), email: str = Form(),mobile: str = Form(),dob: str = Form(),Password: str = Form()):
    """This service takes details from client and return a greeting msg"""
    
    file1 = open("response.txt","a")
    file1.write(name +" , "+ email+" , "+ str(mobile)+" , "+ str(dob)+" , "+Password+" , ")
    file1.write("\n")
    file1.close()

    return "Successfully Registered"




@app.post("/login") #http://127.0.0.1:8000/login/
def user_login(name: str = Form(), Password: str = Form()):
    """This service takes details from client and return a greeting msg"""
    
    file1 = open("response.txt","a")
    file1.write(name +" , "+Password+" , ")
    file1.write("\n")
    file1.close()

    return "Login Successfully"



@app.post("/processLogin")#http://127.0.0.1:8000/processLogin/
def check_user(request: Request, Roll_no: str = Form(), DOB: str = Form()):
    '''
    checking username and password
    '''
    user = db["users"].find_one({"username": username})
    if username == user["username"] and password == user["password"] :
        return template1.TemplateResponse("home.html", context={"request": request})
    else:
        return "Unsuccessful sign_in"