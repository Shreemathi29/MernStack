import React from 'react';
const Footer = () => {
    return (
        <div className="bg-[#FA7D19] text-white">
            <footer className="footer p-10 justify-items-center">
                <div>
                    <span className="footer-title">Services</span>
                    <a className="link link-hover">Branding</a>
                    <a className="link link-hover">Design</a>
                    <a className="link link-hover">Developing</a>
                    <a className="link link-hover">Advertisement</a>
                </div>
                <div>
                    <span className="footer-title">Company</span>
                    <a className="link link-hover" href='#'>About us</a>
                    <a className="link link-hover" href='#'>Contact</a>
                    <a className="link link-hover" href='#'>Jobs</a>
                    <a className="link link-hover" href='#'>Press kit</a>
                </div>
                <div>
                    <span className="footer-title">Legal</span>
                    <a className="link link-hover">Terms of use</a>
                    <a className="link link-hover">Privacy policy</a>
                    <a className="link link-hover">Cookie policy</a>
                </div>
            </footer>
            <div className="text-center py-8">
                <p>Copyright © 2022 - All right reserved by Codebun</p>
            </div>
        </div>
    );
};
export default Footer;