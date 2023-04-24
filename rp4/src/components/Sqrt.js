import React, { useState } from "react";
 function Sqrt () {
    const [num, setNum] = useState("");
        const value = Math.sqrt(num);
    
    return (
        <div className="App" style={{backgroundColor:"gold",
        color:"black",
        width:"300px"}}>
        <form>
        <div>
        <label> Enter a Number : </label>
        <input value={num} onChange={(e) => setNum(e.target.value)} />
        </div>        
        </form>
        <div><h2>Squareroot of num : {value}</h2></div>
        </div>
    );
}

export {Sqrt};