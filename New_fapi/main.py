from fastapi import FastAPI
from pydantic import BaseModel
app = FastAPI()
class Book(BaseModel):
    isbn:str
    title:str
    author:list
    price:float
books = {
    1:{
        "isbn":"B09BJLKM6F",
         "title":"Web API Development with Python: A Beginner's Guide using Flask and FastApi",
         "author":["Rehan Haider"],
         "price":449.0,
    },
    2:{
        "isbn":"9332585342",
         "title":"Python Programming - A modular Approach",
         "author":["Taneeja Sheetal", "Kumar Naveen"],
         "price":527.0,
    },
    3:{
        "isbn":"9332585312",
         "title":"JAVA Programming - OOPS CONCEpts",
         "author":["Naveen"],
         "price":550.0,
    }

}

@app.get("/")
def register():
    return "Welcome to DT3"
    """
    Retrieve all details from the book (R)
    Create - POST, Retrieve - GET, Update - PUT, DELETE-delete
    Use : http://127.0.0.1:8000/docs URL for API Demo
    """
@app.get("/api/book/get_details")
def get_details():
    return books
@app.post("/api/book/create")
def create_book(new_book:Book):
    book_id = max(books.keys())+1
    books[book_id] = new_book.dict()
    return books
@app.post("/api/book/{book_id}")
def update_book(book_id: int, updated_book: Book):
    book = books[book_id]
    book["isbn"] = updated_book.isbn
    book["title"] = updated_book.title
    book["author"] = updated_book.author
    book["price"] = updated_book.price
    return books
@app.delete("/api/book/{book_id}")
def delete_book(book_id: int):
    del books[book_id]
    return books

