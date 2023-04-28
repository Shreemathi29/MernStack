from fastapi import FastAPI
from fastapi.responses import HTMLResponse
from fastapi import Request
from fastapi.templating import Jinja2Templates

app = FastAPI()
templates = Jinja2Templates(directory = "templates")
# @-annotation 'get and post methods' of http protocol 
#root url:htt
@app.get("/")
def home():
    '''
    home pagep://127.0.0.1:8000/
    '''
    return "hello World"

@app.get("/greet1")
def greet_user(name,password):
    '''
    checking username and password
    '''
    
    name = input("Enter your Username: ")
    password = int(input("Enter your Password: "))
    if( password == 12345):
        
        
        return "Successfully sign_in: " +name