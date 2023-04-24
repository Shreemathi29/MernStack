// import React from 'react'
// import './Pages.css'
// function Home() {
//     return (
//         <div className = 'content'>
//             <h1>Home Page</h1>
//         </div>
//     )
// }

// export default Home


import './Home.css';
import React from 'react';
import Header from '../Components/Header';
import Footer from '../Components/Footer';
const Home = (props) => {
    return (
        <div>
            <Header/>
            <div className="banner-container">
                <div className="text-center">
                    <h1 className="text text-orange-600 font-bold">Welcome to Codebun</h1>
                    <h4 className="text text-white">Your very own personal tutorial corner</h4>
                </div>
            </div>
            <Footer />
        </div>
    );
};
export default Home;