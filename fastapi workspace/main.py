from fastapi import FastAPI
from fastapi import Form
from fastapi.responses import HTMLResponse
from fastapi import Request
from fastapi.templating import Jinja2Templates
app = FastAPI()
template = Jinja2Templates(directory ="template")
@app.get("/")
def home():

    return "Welcome"
@app.get("/greetnew") 
def greet_user(name):

    return "Welcome " +name

@app.get("/service")
def user_service(uname,password):

    return "Welcome " +uname,password
    #return "Welcome " +uname+ " password  " +password

    
@app.get("/showGreetPage", response_class=HTMLResponse)
def show_greet_page(request:Request):

    return template.TemplateResponse("greet.html", context={"request":request}) 

@app.post("/greet")
def check_user(uname: str = Form(), password: str = Form()):
    '''
    checking username and password
    '''
    if uname == "shree" and password == "12345":
        return "Successfully sign_in: " +uname
    else:
        return "You are not an authorized user."

