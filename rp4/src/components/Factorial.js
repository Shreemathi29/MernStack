import React, { useState } from "react";
 function Factorial (num) {
    var [num, setNum] = useState("");
    if (num === 0) return 1;
    let fact = 1;
    for (let i = 1; i < num; i++) {
        fact = fact * (i + 1);
    }
    
        
    
    return (
        <div className="App">
        <form>
        <div>
        <label> Enter a Number : </label>
        <input value={num} onChange={(e) => setNum(e.target.value)} />
        </div>        
        </form>
        <div><h2>Factorial of num : {fact}</h2></div>
        </div>
    );
}

export default Factorial;